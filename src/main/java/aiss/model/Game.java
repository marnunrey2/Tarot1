package aiss.model;

public class Game {
	
	private String id;
	private String name;
	private String origin;
	private GameDifficulty level;
	private Integer numPlayers;
	private Integer numCard;
	private String deckDescription;
	private String rules;

	public Game() {
	}
	
	public Game(String name, String origin, GameDifficulty level, Integer numPlayers, Integer numCard, String deckDescription, String rules) {
		this.name = name;
		this.origin = origin;
		this.level = level;
		this.numPlayers = numPlayers;
		this.numCard = numCard;
		this.deckDescription = deckDescription;
		this.rules = rules;
	}
	
	public Game(String id, String name, String origin, GameDifficulty level, Integer numPlayers, Integer numCard, String deckDescription, String rules) {
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.level = level;
		this.numPlayers = numPlayers;
		this.numCard = numCard;
		this.deckDescription = deckDescription;
		this.rules = rules;
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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public GameDifficulty getDifficulty() {
		return level;
	}

	public void setDifficulty(GameDifficulty level) {
		this.level = level;
	}

	public Integer getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(Integer numPlayers) {
		this.numPlayers = numPlayers;
	}
	
	public Integer getNumCards() {
		return numCard;
	}

	public void setNumCards(Integer numCard) {
		this.numCard = numCard;
	}
	
	public String getDeckDescription() {
		return deckDescription;
	}

	public void setDeckDescription(String deckDescription) {
		this.deckDescription = deckDescription;
	}
	
	
	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

}
