package aiss.model;

import java.util.Map;

import aiss.api.resources.CardResource;

public class Spread {

	private String id;
	private String name;
	private String description;
	private Integer numCards;
	private Map<String, String> cards;
	
	public Spread() {}
	
	public Spread(String name) {
		this.name = name;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNumCards() {
		return numCards;
	}
	public void setNumCard(Integer numCards) {
		this.numCards = numCards;
	}
	
	public Map<String, String> getCards() {
		for (int i=0; i<numCards;i++) {
			Double rand = Math.random()*79;
			Double randDirection = Math.random()*2;
			Integer randInt = rand.intValue();
			if (randDirection==0) {
				cards.put(getCard(randInt.toString()).getName(),getCard(randInt.toString()).getReversed());
			}
			else {
				cards.put(getCard(randInt.toString()).getName(),getCard(randInt.toString()).getUpright());
			}
			
		}
		return cards;
	}
	
	public Card getCard(String id) {
		
		Card card =null;
		for(Card c: CardResource.getAll(null, null, null)) {
			if (c.getId().equals(id))
			{
				card=c;
				break;
			}
		}
		return card;
	}



}
