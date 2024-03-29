package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorNameSpread;
import aiss.api.resources.comparators.ComparatorNameSpreadReversed;
import aiss.model.Spread;
import aiss.model.repository.MapSpreadRepository;
import aiss.model.repository.SpreadRepository;


@Path("/spreads")
public class SpreadResource {
	
	/* Singleton */
	private static SpreadResource _instance=null;
	SpreadRepository repository;
	
	private SpreadResource() {
		repository=MapSpreadRepository.getInstance();
	}
	
	public static SpreadResource getInstance() {
		if(_instance==null)
				_instance=new SpreadResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Spread> getAll(@QueryParam("name") String name, @QueryParam("order") String order) 
	{
		List<Spread> result = new ArrayList<Spread>();
		
		for(Spread spread: repository.getAllSpreads()) {
			if (name != null) {
				if (spread.getName().equals(name)) {
					result.add(spread);
				}
			}
		}
		
		if (name==null) {
        	result = repository.getAllSpreads().stream().collect(Collectors.toList());
        }
		
		if (order != null) {
			if(order.equals("name")) {
				Collections.sort(result, new ComparatorNameSpread());
			} else if (order.equals("-name")) {
				Collections.sort(result, new ComparatorNameSpreadReversed());
			} else {
				throw new BadRequestException("The order parameter must be 'name' or '-name'.");
			}
		}
		
		return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Spread get(@PathParam("id") String id) 
	{		
		Spread list = repository.getSpread(id);
		
		if (list == null) {
			throw new NotFoundException("The spread with id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@GET
	@Path("/{id}/cardsOfSpread")
	@Produces("application/json")
	public List<String> getCards(@PathParam("id") String id) 
	{		
		List<String> cards = new ArrayList<>();
		cards.add(repository.getSpread(id).getDescription());
		List<Integer> randomIdList = new ArrayList<>();
		
		for (int i=0; i<repository.getSpread(id).getNumCards(); i++) {
			Double randomId = (Math.random()*78);
			Double randDirection = Math.random()*2;
			Integer randomIdInt = randomId.intValue();
			while (randomIdList.contains(randomIdInt)) {
				randomIdInt = (int)(Math.random()*78);
			}
			randomIdList.add(randomIdInt);
			Integer randDirectionInt = randDirection.intValue();
			String cardId = "c" + randomIdInt.toString();
			if (randDirectionInt==0) {
				cards.add((i+1) + ". " + repository.getCard(cardId).getName() + " (Reversed): " + repository.getCard(cardId).getReversed());
			}
			else {
				cards.add((i+1) + ". " + repository.getCard(cardId).getName() + " (Upright): " + repository.getCard(cardId).getUpright());
			}
		}
		return cards;
	}
	
	@GET
	@Path("/{id}/customCardsOfSpread")
	@Produces("application/json")
	public List<String> getCustomCards(@PathParam("id") String id)
	{
		List<String> customCards = new ArrayList<>();
		customCards.add(repository.getSpread(id).getDescription());
		List<Integer> randomIdList = new ArrayList<>();
		
		for(int i = 0; i < repository.getSpread(id).getNumCards(); i++) {
			Double randomId = Math.random()*repository.getAllCustomCards().size();
			Double randDirection = Math.random()*2;
			Integer randomIdInt = randomId.intValue();
			while (randomIdList.contains(randomIdInt)) {
				randomIdInt = (int)(Math.random()*repository.getAllCustomCards().size());
			}
			randomIdList.add(randomIdInt);
			Integer randDirectionInt = randDirection.intValue();
			String cardId = "cc" + randomIdInt.toString();
			if(randDirectionInt ==0) {
				customCards.add((i+1) + "." + repository.getCustomCard(cardId).getName() + "(Reversed): " + repository.getCustomCard(cardId).getReversed());
			} else {
				customCards.add((i+1) + "." + repository.getCustomCard(cardId).getName() + "(Upright): " + repository.getCustomCard(cardId).getUpright());
			}
		}
		return customCards;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addSpread(@Context UriInfo uriInfo, Spread spread) 
	{		
		if (spread.getName() == null || "".equals(spread.getName()))
			throw new BadRequestException("The name of the spread must not be null");
		
		repository.addSpread(spread);

		// Builds the response. Returns the spread the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(spread.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(spread);			
		
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateSpread(Spread spread) 
	{		
		Spread oldspread = repository.getSpread(spread.getId());
		if (oldspread == null) {
			throw new NotFoundException("The spread with id="+ spread.getId() +" was not found");			
		}
		
		// Update name
		if (spread.getName()!=null)
			oldspread.setName(spread.getName());

		// Update description
		if (spread.getType()!=null)
			oldspread.setType(spread.getType());
		
		// Update description
		if (spread.getDescription()!=null)
			oldspread.setDescription(spread.getDescription());
		
		// Update numCards
		if (spread.getNumCards()!=null)
			oldspread.setNumCard(spread.getNumCards());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeSpread(@PathParam("id") String id) 
	{
		Spread toberemoved=repository.getSpread(id);
		if (toberemoved == null)
			throw new NotFoundException("The spread with id="+ id +" was not found");
		else
			repository.deleteSpread(id);
		
		return Response.noContent().build();
	}
	
	
}
