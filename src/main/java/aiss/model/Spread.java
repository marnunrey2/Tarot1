package aiss.model;

public class Spread {

	private String id;
	private String name;
	private SpreadType type;
	private String description;
	private Integer numCards;
	
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
	public SpreadType getType() {
		return type;
	}
	public void setType(SpreadType type) {
		this.type = type;
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
	
	



}
