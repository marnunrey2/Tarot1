package aiss.model.repository;

import java.util.Collection;
import java.util.Map;

import aiss.model.Spread;
import aiss.model.Card;
import aiss.model.CustomCard;
import aiss.model.Game;

public interface SpreadRepository {
	
	
	// Cards
	public void addCard(Card c);
	public void addCard(String id, Card c);
	public Collection<Card> getAllCards();
	public Card getCard(String cardId);
	public void updateCard(Card c);
	public void deleteCard(String cardId);
	
	// Custom Cards
	public void addCustomCard(CustomCard c);
	public Collection<CustomCard> getAllCustomCards();
	public CustomCard getCustomCard(String cardId);
	public void updateCustomCard(CustomCard c);
	public void deleteCustomCard(String cardId);
	
	// Spreads
	public void addSpread(Spread s);
	public Collection<Spread> getAllSpreads();
	public Spread getSpread(String spreadId);
	public void updateSpread(Spread s);
	public void deleteSpread(String spreadId);
	public Map<String, String> getCards();

	// Games
	public void addGame(Game c);
	public Collection<Game> getAllGames();
	public Game getGame(String cardId);
	public void updateGame(Game c);
	public void deleteGame(String cardId);
	
	
	

}
