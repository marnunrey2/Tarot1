package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import aiss.api.resources.comparators.ComparatorNameAlbum;
import aiss.api.resources.comparators.ComparatorNameAlbumReversed;
import aiss.api.resources.comparators.ComparatorNameArtist;
import aiss.api.resources.comparators.ComparatorNameArtistReversed;
import aiss.api.resources.comparators.ComparatorYear;
import aiss.api.resources.comparators.ComparatorYearReversed;
import aiss.model.Playlist;
import aiss.model.Song;
import aiss.model.repository.MapPlaylistRepository;
import aiss.model.repository.PlaylistRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



@Path("/songs")
public class SongResource {

	public static SongResource _instance=null;
	PlaylistRepository repository;
	
	private SongResource(){
		repository=MapPlaylistRepository.getInstance();
	}
	
	public static SongResource getInstance()
	{
		if(_instance==null)
			_instance=new SongResource();
		return _instance; 
	}
	
	@GET
    @Produces("application/json")
    public Collection<Song> getAll(@QueryParam("order") String order, @QueryParam("q") String q)
    {
        List<Song> result = new ArrayList<Song>();
        if (order != null) {
            if (order.equals("album")) {
            	Collections.sort(result, new ComparatorNameAlbum());
            }
            else if (order.equals("artist")) {
                Collections.sort(result, new ComparatorNameArtist());
            }
            else if (order.equals("year")) {
                Collections.sort(result, new ComparatorYear());
            }
            if (order.equals("-album")) {
                Collections.sort(result, new ComparatorNameAlbumReversed());
            }
            else if (order.equals("-artist")) {
                Collections.sort(result, new ComparatorNameArtistReversed());
            }
            else if (order.equals("-year")) {
                Collections.sort(result, new ComparatorYearReversed());
            }
        }
        for (Song song: repository.getAllSongs()) {
            if (q != null) {
                if (song.getAlbum().contains(q)) {
                    result.add(song);
                }
                if (song.getTitle().contains(q)) {
                    result.add(song);
                }
                if (song.getArtist().contains(q)) {
                    result.add(song);
                }
            }
        }
        return result;
    }
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Song get(@PathParam("id") String songId)
	{
		Song song = repository.getSong(songId);
		
		if (song == null) {
			throw new NotFoundException("The song with id="+ songId +" was not found");			
		}
		
		return song;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo, Song song) {
		
		if (song.getTitle() == null || "".equals(song.getTitle()))
			throw new BadRequestException("The name of the song must not be null");

		repository.addSong(song);

		// Builds the response. Returns the song's uri the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(song.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(song);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateSong(Song song) {
		Song oldSong = repository.getSong(song.getId());
		if (oldSong == null) {
			throw new NotFoundException("The song with id="+ song.getId() +" was not found");			
		}
		
		if (song.getId() == null)
			throw new BadRequestException("The song must have an id.");
		
		// Update title
		if (song.getTitle()!=null)
			oldSong.setTitle(song.getTitle());
		
		// Update artist
		if (song.getArtist()!=null)
			oldSong.setArtist(song.getArtist());
		
		// Update album
		if (song.getAlbum()!=null)
			oldSong.setAlbum(song.getAlbum());
		
		// Update year
		if (song.getYear()!=null)
			oldSong.setYear(song.getYear());
	
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeSong(@PathParam("id") String songId) {
		Song songremoved = repository.getSong(songId);
		
		if (songremoved == null)
			throw new NotFoundException("The song with id="+ songId +" was not found");
		else
			repository.deleteSong(songId);
		
		return Response.noContent().build();
	}
	
}
