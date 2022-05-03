package aiss.model.repository;

import java.util.Collection;
import java.util.Map;

import aiss.model.Spread;
import aiss.model.Card;

public interface SpreadRepository {
	
	
	// Cards
	public void addCard(Card c);
	public Collection<Card> getAllCards();
	public Card getCard(String cardId);
	public void updateCard(Card c);
	public void deleteCard(String cardId);
	
	// Spreads
	public void addSpread(Spread s);
	public Collection<Spread> getAllSpreads();
	public Spread getSpread(String spreadId);
	public void updateSpread(Spread s);
	public void deleteSpread(String spreadId);
	public Map<String, String> getCards();

	
	
	
	

}
