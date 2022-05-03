package aiss.model;

public class Card {

	private String id;
	private String name;
	private String suit;
	private String upright;
	private String reversed;

	public Card() {
	}

	public Card(String name, String suit, String upright, String reversed) {
		this.name = name;
		this.suit = suit;
		this.upright = upright;
		this.reversed = reversed;
	}
	
	public Card(String id, String name, String suit, String upright, String reversed) {
		this.id=id;
		this.name = name;
		this.suit = suit;
		this.upright = upright;
		this.reversed = reversed;
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

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getUpright() {
		return upright;
	}

	public void setUpright(String upright) {
		this.upright = upright;
	}

	public String getReversed() {
		return reversed;
	}

	public void setReversed(String reversed) {
		this.reversed = reversed;
	}

}
