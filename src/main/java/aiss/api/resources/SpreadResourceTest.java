package aiss.api.resources;

import static org.junit.Assert.*;

import java.util.Collection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.model.Spread;
import aiss.model.Card;

public class SpreadResourceTest {

	static Spread playlist, playlist2, playlist3, playlist4;
	static Card card;
	static SpreadResource plr = new SpreadResource();
	static CardResource sr = new CardResource();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		playlist = plr.addPlaylist(new Spread("Test list 1"));
		playlist2 = plr.addPlaylist(new Spread("Test list 2"));
		playlist3 = plr.addPlaylist(new Spread("Test list 3"));
		
	
		card = sr.addCard(new Card("Test title","Test suit","Test upright","2016"));
		if(card!=null)
			plr.addCard(playlist.getId(), card.getId());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		plr.deletePlaylist(playlist.getId());
		plr.deletePlaylist(playlist3.getId());
		plr.deletePlaylist(playlist4.getId());
		if(card!=null)
			sr.deleteCard(card.getId());
	}

	@Test
	public void testGetAll() {
		Collection<Spread> playlists = plr.getAll(); 
		
		assertNotNull("The collection of playlists is null", playlists);
		
		// Show result
		System.out.println("Listing all playlists:");
		int i=1;
		for (Spread pl : playlists) {
			System.out.println("Playlist " + i++ + " : " + pl.getName() + " (ID=" + pl.getId() + ")");
		}
		
	}

	@Test
	public void testGetPlaylist() {
		Spread p = plr.getPlaylist(playlist.getId());
		
		assertEquals("The id of the playlists do not match", playlist.getId(), p.getId());
		assertEquals("The name of the playlists do not match", playlist.getName(), p.getName());
		
		// Show result
		System.out.println("Playlist id: " +  p.getId());
		System.out.println("Playlist name: " +  p.getName());

	}

	@Test
	public void testAddPlaylist() {
		String playlistName = "Add playlist test title";
		String playlistDescription = "Add playlist test description";
		
		playlist4 = plr.addPlaylist(new Spread(playlistName,playlistDescription));
		
		assertNotNull("Error when adding the playlist", playlist4);
		assertEquals("The playlist's name has not been setted correctly", playlistName, playlist4.getName());
		assertEquals("The playlist's description has not been setted correctly", playlistDescription, playlist4.getDescription());
	}

	@Test
	public void testUpdatePlaylist() {
		String playlistName = "Updated playlist name";

		// Update playlist
		playlist.setName(playlistName);

		boolean success = plr.updatePlaylist(playlist);
		
		assertTrue("Error when updating the playlist", success);
		
		Spread pl  = plr.getPlaylist(playlist.getId());
		assertEquals("The playlist's name has not been updated correctly", playlistName, pl.getName());

	}

	@Test
	public void testDeletePlaylist() {
		boolean success = plr.deletePlaylist(playlist2.getId());
		assertTrue("Error when deleting the playlist", success);
		
		Spread pl = plr.getPlaylist(playlist2.getId());
		assertNull("The playlist has not been deleted correctly", pl);
	}

	@Test
	public void testAddCard() {
		if(card!=null) {
			boolean success = plr.addCard(playlist3.getId(), card.getId());
			assertTrue("Error when adding the card", success);
		}
	}

	@Test
	public void testRemoveCard() {
		boolean success = plr.removeCard(playlist.getId(),card.getId());
		assertTrue("Error when deleting the card", success);
		
//		Playlist pl = plr.getPlaylist(card.getId());
//		assertNull("The card has not been deleted correctly", pl);
	}

}
