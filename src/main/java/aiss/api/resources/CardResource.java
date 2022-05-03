package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Card;

public class CardResource {

	//private String uri = "http://playlist-api.appspot.com/api/cards";
	private String uri = "http://localhost:8095/api/cards";

	
	public Collection<Card> getAll() {
		ClientResource cr = null;
		Card [] cards = null;
		try {
			cr = new ClientResource(uri);
			cards = cr.get(Card[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all cards: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(cards);
	}
	

	public Card getCard(String cardId) {
		ClientResource cr = null;
		Card card = null;
		try {
			cr = new ClientResource(uri + "/" + cardId);
			card = cr.get(Card.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the card: " + cr.getResponse().getStatus());
		}
		
		return card;
	}
	

	public Card addCard(Card card) {
		ClientResource cr = null;
		Card resultCard = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultCard = cr.post(card,Card.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the card: " + cr.getResponse().getStatus());
		}
		
		return resultCard;

	}
	
	public boolean updateCard(Card card) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(card);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the card: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	

	public boolean deleteCard(String cardId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + cardId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the card: " + cr.getResponse().getStatus());
			success = false;
			throw re;
		}
		
		return success;
		
	}
}
