package aiss.api.resources;

import java.net.URI;
import java.time.LocalDate;
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
import javax.ws.rs.WebApplicationException;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.MethodNotAllowedException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorName;
import aiss.api.resources.comparators.ComparatorNameReversed;
import aiss.api.resources.comparators.ComparatorSuit;
import aiss.api.resources.comparators.ComparatorSuitReversed;
import aiss.model.Card;
import aiss.model.repository.MapSpreadRepository;
import aiss.model.repository.SpreadRepository;

@Path("/cards")
public class CardResource {

	public static CardResource _instance=null;
	static SpreadRepository repository;
	
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
    public static Collection<Card> getAll(@QueryParam("order") String order, @QueryParam("suit") String suit, @QueryParam("name") String name)
    {
        List<Card> result = new ArrayList<Card>();
    
        for (Card card: repository.getAllCards()) {
            if (suit != null && name == null) {
                if (card.getSuit().contains(suit)) {
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
            	throw new MethodNotAllowedException("Use one parameter only");	
            }
        }
        
        if (suit==null && name==null) {
        	result = repository.getAllCards().stream().collect(Collectors.toList());
        }
        
        
        if (order != null) {
        	if (order.equals("name")) {
                Collections.sort(result, new ComparatorName());
            } else if (order.equals("suit")) {
            	Collections.sort(result, new ComparatorSuit());
            } else if (order.equals("-name")) {
                Collections.sort(result, new ComparatorNameReversed());
            } else if (order.equals("-suit")) {
                Collections.sort(result, new ComparatorSuitReversed());
            }
        }
        
        return result;
    }
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Card get(@PathParam("id") String cardId)
	{
		Card card = repository.getCard(cardId);
		
		if (card == null) {
			throw new NotFoundException("The card with id="+ cardId +" was not found");			
		}
		
		return card;
	}
	
	@GET
	@Path("/dailyCard")
	@Produces("application/json")
	public String getDailyCard()
	{	
		LocalDate date = LocalDate.now();
		Integer rand = 3*(date.getDayOfMonth() + date.getDayOfYear() + date.getYear());
		Integer mod = Math.floorMod(rand, 156);
		Integer numCard;
		String dailyCard = null;
		for (Card card : repository.getAllCards()) {
			numCard = Integer.valueOf(card.getId().replace("c", ""));
			if (numCard == mod) {
				dailyCard = card.getName()+ "(Upright): " + card.getUpright();
				break;
			}
			if (numCard*2 == mod) {
				dailyCard = card.getName()+ "(Reversed): " + card.getReversed();
				break;
			}
		}
		return dailyCard;
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCard(@Context UriInfo uriInfo, Card card, @QueryParam("key") String key) 
	{
		Response response = Response.noContent().build();
		if (key!=null) {
			if (key.equals("propensos")) {
				if (card.getName() == null || "".equals(card.getName()))
					throw new BadRequestException("The name of the card must not be null");
		
				repository.addCard(card);
		
				// Builds the response. Returns the Card's uri the has just been added.
				UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
				URI uri = ub.build(card.getId());
				ResponseBuilder resp = Response.created(uri);
				resp.entity(card);	
				response = resp.build();
			} else {
				throw new BadRequestException("Wrong password");
			}
			return response;
		}
		else {
			throw new WebApplicationException(Response.status(403).entity("You are not authorized to access this operation").build()); 
		}
	}

	@POST
    @Path("/restore")
    @Produces("application/json")
    public Response reset(@QueryParam("key") String key) 
    {
        Response response = Response.noContent().build();
        if (key!=null) {
            if (key.equals("propensos")) {
                MapSpreadRepository.getInstance().resetCards();
            } else {
                throw new BadRequestException("Wrong password");
            }
            return response;
        } else {
        	throw new WebApplicationException(Response.status(403).entity("You are not authorized to access this operation").build());
        }
    }
	
	
	@PUT
	@Consumes("application/json")
	public Response updateCard(Card card, @QueryParam("key") String key) 
	{
		if (key!=null) {
			if (key.equals("propensos")) {
				
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
			} else {
				throw new BadRequestException("Wrong password");
			}
		} else {
			throw new WebApplicationException(Response.status(403).entity("You are not authorized to access this operation").build());
		}
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeCard(@PathParam("id") String cardId, @QueryParam("key") String key) 
	{
		if (key!=null) {
			if (key.equals("propensos")) {
				Card Cardremoved = repository.getCard(cardId);
				
				if (Cardremoved == null)
					throw new NotFoundException("The card with id="+ cardId +" was not found");
				else
					repository.deleteCard(cardId);
			} else {
				throw new BadRequestException("Wrong password");
			}			
		} else {
			throw new WebApplicationException(Response.status(403).entity("You are not authorized to access this operation").build()); 
		}
		return Response.noContent().build();
	}
}
