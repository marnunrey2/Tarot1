package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.api.resources.comparators.ComparatorReversed;
import aiss.api.resources.comparators.ComparatorReversedReversed;
import aiss.api.resources.comparators.ComparatorSuit;
import aiss.api.resources.comparators.ComparatorSuitReversed;
import aiss.api.resources.comparators.ComparatorUpright;
import aiss.api.resources.comparators.ComparatorUprightReversed;
import aiss.model.Card;
import aiss.model.repository.MapSpreadRepository;
import aiss.model.repository.SpreadRepository;

@Path("/cards")
public class CardResource {

	public static CardResource _instance=null;
	SpreadRepository repository;
	
	private CardResource(){
		repository=MapSpreadRepository.getInstance();
	}
	
	public static CardResource getInstance()
	{
		if(_instance==null)
			_instance=new CardResource();
		return _instance; 
	}
	
	@GET
    @Produces("application/json")
    public static Collection<Card> getAll(@QueryParam("order") String order, @QueryParam("q") String q)
    {
        List<Card> result = new ArrayList<Card>();
        if (order != null) {
            if (order.equals("suit")) {
            	Collections.sort(result, new ComparatorSuit());
            }
            else if (order.equals("upright")) {
                Collections.sort(result, new ComparatorUpright());
            }
            else if (order.equals("reversed")) {
                Collections.sort(result, new ComparatorReversed());
            }
            if (order.equals("-suit")) {
                Collections.sort(result, new ComparatorSuitReversed());
            }
            else if (order.equals("-upright")) {
                Collections.sort(result, new ComparatorUprightReversed());
            }
            else if (order.equals("-reversed")) {
                Collections.sort(result, new ComparatorReversedReversed());
            }
        }
        for (Card card: repository.getAllCards()) {
            if (q != null) {
                if (card.getSuit().contains(q)) {
                    result.add(card);
                }
                if (card.getUpright().contains(q)) {
                    result.add(card);
                }
                if (card.getReversed().contains(q)) {
                    result.add(card);
                }
            }
        }
        return result;
    }
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Card get(@PathParam("id") String cardId)
	{
		Card song = repository.getCard(cardId);
		
		if (song == null) {
			throw new NotFoundException("The card with id="+ cardId +" was not found");			
		}
		
		return song;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo, Card card) {
		
		if (card.getName() == null || "".equals(card.getName()))
			throw new BadRequestException("The name of the card must not be null");

		repository.addSong(card);

		// Builds the response. Returns the song's uri the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(card.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(card);		
		
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateSong(Card card) {
		Card oldCard = repository.getCard(card.getId());
		if (oldCard == null) {
			throw new NotFoundException("The card with id="+ card.getId() +" was not found");			
		}
		
		if (card.getId() == null)
			throw new BadRequestException("The card must have an id.");
		
		// Update name
		if (card.getName()!=null)
			oldCard.setName(card.getName());
		
		// Update suit
		if (card.getSuit()!=null)
			oldCard.setSuit(card.getSuit());
		
		// Update upright
		if (card.getUpright()!=null)
			oldCard.setUpright(card.getUpright());
		
		// Update reversed
		if (card.getReversed()!=null)
			oldCard.setReversed(card.getReversed());
	
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeSong(@PathParam("id") String cardId) {
		Card songremoved = repository.getCard(cardId);
		
		if (songremoved == null)
			throw new NotFoundException("The card with id="+ cardId +" was not found");
		else
			repository.deleteSong(cardId);
		
		return Response.noContent().build();
	}
}
