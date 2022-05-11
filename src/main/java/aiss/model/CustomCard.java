package aiss.model;

public class CustomCard {
	
	private String id;
	private String name;
	private CustomSuit customSuit;
	private String upright;
	private String reversed;

	public CustomCard() {
	}

	public CustomCard(String name, CustomSuit customSuit, String upright, String reversed) {
		this.name = name;
		this.customSuit = customSuit;
		this.upright = upright;
		this.reversed = reversed;
	}
	
	public CustomCard(String id, String name, CustomSuit customSuit, String upright, String reversed) {
		this.id=id;
		this.name = name;
		this.customSuit = customSuit;
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

	public CustomSuit getSuit() {
		return customSuit;
	}

	public void setSuit(CustomSuit customSuit) {
		this.customSuit = customSuit;
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

