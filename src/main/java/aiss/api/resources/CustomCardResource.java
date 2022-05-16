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

import aiss.api.resources.comparators.ComparatorNameCustom;
import aiss.api.resources.comparators.ComparatorNameReversedCustom;
import aiss.model.CustomCard;
import aiss.model.repository.MapSpreadRepository;
import aiss.model.repository.SpreadRepository;

@Path("/customs")
public class CustomCardResource {

	public static CustomCardResource _instance=null;
	static SpreadRepository repository;
	
	private CustomCardResource(){
		repository=MapSpreadRepository.getInstance();
	}
	
	public static CustomCardResource getInstance()
	{
		if(_instance==null)
			_instance=new CustomCardResource();
		return _instance; 
	}
	
	
	@GET
	@Produces("application/json")
	public static Collection<CustomCard> getAll(@QueryParam("order") String order, @QueryParam("suit") String suit, 
			@QueryParam("name") String name, @QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit)
	{
	    List<CustomCard> result = new ArrayList<CustomCard>();
	    
	    if (suit != null || name != null) {
		    for (CustomCard card: repository.getAllCustomCards()) {
		        if (suit != null && name == null) {
		            if (card.getSuit().toString().equals(suit)) {
		                result.add(card);
		            } 
		        }
		        if (name != null && suit == null) {
		        	if (card.getName().contains(name)) {
		        		result.add(card);
		        		break;
		        	}
		        }
		        if (name != null && suit != null) {
		        	throw new NotFoundException("Use one parameter only");	
		        }
		    }
		    if (offset != null) {
		    	result = result.subList(offset, result.size());
		    }
		    if (limit != null) {
		    	if (limit <= result.size()) {
    				result = result.subList(0, limit);
    			} else {
    				throw new BadRequestException("The limit is higher than the size of the initial list or the list obtained after the offset");
    			}
		    }
	    }
	    
	    if (suit==null && name==null) {
	    	if (limit == null && offset == null) {
	    		result = repository.getAllCustomCards().stream().collect(Collectors.toList());
	    	} else {
	    		result = repository.getAllCustomCards().stream().collect(Collectors.toList());
	    		if (offset != null) {
	    			result = result.subList(offset, result.size());
	    		}
	    		if (limit != null) {
	    			if (limit <= result.size()) {
	    				result = result.subList(0, limit);
	    			} else {
	    				throw new BadRequestException("The limit is higher than the size of the initial list or the list obtained after the offset");
	    			}
	    		}
	    	}
	    }	    
	    
	    if (order != null) {
	    	if (order.equals("name")) {
	            Collections.sort(result, new ComparatorNameCustom());
	        } 
	    	if (order.equals("-name")) {
	            Collections.sort(result, new ComparatorNameReversedCustom());
	        } 
	    }
	    
	    return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public CustomCard get(@PathParam("id") String cardId)
	{
		CustomCard card = repository.getCustomCard(cardId);
		
		if (card == null) {
			throw new NotFoundException("The card with id="+ cardId +" was not found");			
		}
		
		return card;
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCustomCard(@Context UriInfo uriInfo, CustomCard card) {
		
		if (card.getName() == null || "".equals(card.getName()))
			throw new BadRequestException("The name of the card must not be null");
	
		repository.addCustomCard(card);
	
		// Builds the response. Returns the Card's uri the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(card.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(card);		
		
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateCustomCard(CustomCard card) {
		
		CustomCard oldCard = repository.getCustomCard(card.getId());
		
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
	public Response removeCustomCard(@PathParam("id") String cardId) {
		CustomCard Cardremoved = repository.getCustomCard(cardId);
		
		if (Cardremoved == null)
			throw new NotFoundException("The card with id="+ cardId +" was not found");
		else
			repository.deleteCustomCard(cardId);
		
		return Response.noContent().build();
	}
}
