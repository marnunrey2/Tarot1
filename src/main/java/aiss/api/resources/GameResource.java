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

import aiss.api.resources.comparators.ComparatorGameName;
import aiss.api.resources.comparators.ComparatorGameNameReversed;
import aiss.api.resources.comparators.ComparatorGameOrigin;
import aiss.api.resources.comparators.ComparatorGameOriginReversed;
import aiss.model.Game;
import aiss.model.repository.MapSpreadRepository;
import aiss.model.repository.SpreadRepository;

@Path("/games")
public class GameResource {

	public static GameResource _instance=null;
	static SpreadRepository repository;
	
	private GameResource(){
		repository=MapSpreadRepository.getInstance();
	}
	
	public static GameResource getInstance()
	{
		if(_instance==null)
			_instance=new GameResource();
		return _instance; 
	}
	
	
	@GET
	@Produces("application/json")
	public static Collection<Game> getAll(@QueryParam("order") String order, @QueryParam("players") Integer players,
			@QueryParam("level") String level, @QueryParam("origin") String origin, @QueryParam("name") String name)
	{
	    List<Game> result = new ArrayList<Game>();
	
	    for (Game game: repository.getAllGames()) {
	        if (level != null && name == null) {
	            if (game.getDifficulty().toString().equals(level)) {
	                result.add(game);
	            } 
	        }
	        
	        if (origin != null && name == null) {
	            if (game.getOrigin().equals(origin)) {
	                result.add(game);
	            } 
	        }
	        
	        if (players != null && name == null) {
	            if (game.getNumPlayers().equals(players)) {
	                result.add(game);
	            } 
	        }
	        
	        if (name != null && level == null && origin == null) {
	        	if (game.getName().contains(name)) {
	        		result.add(game);
	        		break;
	        	}
	        }
	        
	        if (name != null && level != null || name != null && origin != null) {
	        	throw new BadRequestException("Name parameter must be used alone");	
	        }
	    }
	    
	    if (level==null && name==null && origin==null) {
	    	result = repository.getAllGames().stream().collect(Collectors.toList());
	    }
	    
	    
	    if (order != null) {
	    	if (order.equals("name")) {
	            Collections.sort(result, new ComparatorGameName());
	        } 
	    	if (order.equals("-name")) {
	            Collections.sort(result, new ComparatorGameNameReversed());
	        }
	    	if (order.equals("origin")) {
	            Collections.sort(result, new ComparatorGameOrigin());
	        } 
	    	if (order.equals("-origin")) {
	            Collections.sort(result, new ComparatorGameOriginReversed());
	        } 
	    }
	    
	    return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Game get(@PathParam("id") String gameId)
	{
		Game game = repository.getGame(gameId);
		
		if (game == null) {
			throw new NotFoundException("The game with id="+ gameId +" was not found");			
		}
		
		return game;
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addGame(@Context UriInfo uriInfo, Game game) {
		
		if (game.getName() == null || "".equals(game.getName()))
			throw new BadRequestException("The name of the card must not be null");
	
		repository.addGame(game);
	
		// Builds the response. Returns the Card's uri the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(game.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(game);		
		
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateGame(Game game) {
		
		Game oldGame = repository.getGame(game.getId());
		
		if (oldGame == null) {
			throw new NotFoundException("The game with id="+ game.getId() +" was not found");			
		}
		
		if (game.getId() == null)
			throw new BadRequestException("The game must have an id.");
		
		// Update name
		if (game.getName()!=null)
			oldGame.setName(game.getName());
		
		// Update origin
		if (game.getOrigin()!=null)
			oldGame.setOrigin(game.getOrigin());
		
		// Update difficulty
		if (game.getDifficulty()!=null)
			oldGame.setDifficulty(game.getDifficulty());
		
		// Update numPlayers
			if (game.getNumPlayers()!=null)
				oldGame.setNumPlayers(game.getNumPlayers());
		
		// Update numCards
		if (game.getNumCards()!=null)
			oldGame.setNumCards(game.getNumCards());
		
		// Update deck description
			if (game.getDeckDescription()!=null)
				oldGame.setDeckDescription(game.getDeckDescription());
			
		// Update rules
				if (game.getRules()!=null)
					oldGame.setRules(game.getRules());
	
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeGame(@PathParam("id") String gameId) {
		Game gameRemoved = repository.getGame(gameId);
		
		if (gameRemoved == null)
			throw new NotFoundException("The game with id="+ gameId +" was not found");
		else
			repository.deleteGame(gameId);
		
		return Response.noContent().build();
	}
}
