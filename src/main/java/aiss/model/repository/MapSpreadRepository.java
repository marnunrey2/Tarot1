package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Spread;
import aiss.model.SpreadType;
import aiss.model.Card;
import aiss.model.CustomCard;
import aiss.model.CustomSuit;
import aiss.model.Game;
import aiss.model.GameDifficulty;


public class MapSpreadRepository implements SpreadRepository{

	Map<String, Spread> spreadMap;
	Map<String, Card> cardMap;
	Map<String, CustomCard> customMap;
	Map<String, Game>  gameMap;
	private static MapSpreadRepository instance=null;
	private int indexC=78;			// Index to create cards identifiers.
	private int indexS=0;			// Index to create spreads identifiers.
	private int indexCC = 0;		// Index to create custom card's identifiers
	private int indexG = 0;			// Index to create game's identifiers
	
	public static MapSpreadRepository getInstance() {
		if (instance==null) {
			instance = new MapSpreadRepository();
			instance.init();
			instance.resetCards();
		}
		return instance;
	}
	
	public Collection<Card> resetCards() {
		cardMap = new HashMap<String,Card>();
		
		// CREATE CARDS
		//Major Arcana
		Card card1 = new Card("c0", 
				 "The Fool",
				 "Major Arcana",
				 "Beginnings, possibilities, impulsiveness, inocence, a free spirit",
				 "Apathy, hesitation, a faluty choice, doldrums, recklessness");
		addCard("c0", card1);
		
		Card card2 = new Card("c1",
				 "The Magician",
				 "Major Arcana",
				 "Originality, self-confidence, skill, a breakthrough, resourcefulness",
				 "Insecurity, delay, lack of imagination, colsed doors, manipulation");
		addCard("c1", card2);
		
		Card card3 = new Card("c2",
				 "The High Priestess",
				 "Major Arcana",
				 "Wisdom, intuition, dreams, meandering, an enigma",
				 "Ignorance, shallowness, lack of trust, a close mind, secrets");
		addCard("c2", card3);
		
		Card card4 = new Card("c3",
				 "The Empress",
				 "Major Arcana",
				 "Fertility, nurturing, accomplishment, nature, abundance",
				 "Feeling undesirable, anxiety, lack of concentartion, smothering, selfishness");
		addCard("c3", card4);
		
		Card card5 = (new Card("c4",
				 "The Emperor",
				 "Major Arcana",
				 "Stability, leadership, bravery, bold action, structure",
				 "Immaturity, pettiness, rigidity, domination, anger"));
		addCard("c4", card5);
		
		Card card6 = new Card("c5",
				 "The Hierophant",
				 "Major Arcana",
				 "Conformity, compassion, social approval, tradition, legacy",
				 "Bucking Trends, vulnerability, feeling adrift, blind faith");
		addCard("c5", card6);
		
		Card card7 = new Card("c6",
				 "The Lovers",
				 "Major Arcana",
				 "Love, harmony, trust, a leap of faith, choice",
				 "Unreliability, separation, second-guessing, values, conflict");
		addCard("c6", card7);
		
		Card card8 = new Card("c7",
				 "The Chariot",
				 "Major Arcana",
				 "A journey, perseverance, rushed decisions, vengeance, victory",
				 "A lack of direction, floundering, stagnation, willfulness");
		addCard("c7", card8);
		
		Card card9 = new Card("c8",
				 "Strength",
				 "Major Arcana",
				 "Courage, determination, conviction, control, patience",
				 "Weakness, self-doubt, abuse of power, pride, negligence");
		addCard("c8", card9);
		
		Card card10 = new Card("c9",
				 "The Hermit",
				 "Major Arcana",
				 "Instrospection, withdrawal, prudence, insight, meditation",
				 "Recklessness, hastiness, avoidance, loneliness, rejection");
		addCard("c9", card10);
		
		Card card11 = new Card("c10",
				 "The Wheel of Fortune",
				 "Major Arcana",
				 "Fortune, an unexpected windfall, karma, destiny, cycles",
				 "Bad luck, a lack of control, the past, misery, dissapointment");
		addCard("c10", card11);
		
		Card card12 = new Card("c11",
				 "Justice",
				 "Major Arcana",
				 "Harmony, balance, equality, virtue, honor",
				 "Bias, false accusations, intolerance, abuse, dishonesty");
		addCard("c11", card12);
		
		Card card13 = new Card("c12",
				 "The Hanged Man",
				 "Major Arcana",
				 "Suspension, restriction, sacrifice, readjustment, improvement",
				 "Willfulness, useless sacrifice, rushing, thoughtlessness, martyrdom");
		addCard("c12", card13);
		
		Card card14 = new Card("c13",
				 "Death",
				 "Major Arcana",
				 "Metamorphosis, evolution, loss, transition, change",
				 "Stagnation, immobility, stubborness, festering, decay");
		addCard("c13", card14);
		
		Card card15 = new Card("c14",
				 "Temperance",
				 "Major Arcana",
				 "Moderation, harmony, purpose, good influence, reconciliation",
				 "Conflict, hostility, frustration, impatience, reclutance");
		addCard("c14", card15);
		
		Card card16 = new Card("c15",
				 "The Devil",
				 "Major Arcana",
				 "Greed, controversy, violence, strange experiences, addiction",
				 "Release, enlightenment, power reclaimed, divorce, moving on");
		addCard("c15", card16);
		
		Card card17 = new Card("c16",
				 "The Tower",
				 "Major Arcana",
				 "Massive change, upheaval, catastrophe, rebuilding, revelation",
				 "Feeling trapped, delaying disaster, fear of pain, avoidance");
		addCard("c16", card17);
		
		Card card18 = new Card("c17",
				 "The Star",
				 "Major Arcana",
				 "Hope, serenity, inspiration, insight, spirituality",
				 "Crushed dreams, insecurity, despair, dejection, exhaustion");
		addCard("c17", card18);
		
		Card card19 = new Card("c18",
				 "The Moon",
				 "Major Arcana",
				 "Trickery, melancholy, anguish, illusion, insecurity",
				 "Joy, enlightenment, resolution, deception revealed, relief");
		addCard("c18", card19);
		
		Card card20 = new Card("c19",
				 "The Sun",
				 "Major Arcana",
				 "Satisfaction, accomplishment, joy, luck, vitality",
				 "Missed oportunities, delays, doubt, fear of missing out, depression");
		addCard("c19", card20);
		
		Card card21 = new Card("c20",
				 "Judgment",
				 "Major Arcana",
				 "Improvement, forgiveness, a change of perspective, absolution, rebirth",
				 "Opression, lack of self-awareness, failure, repeated mistakes, self-loathing");
		addCard("c20", card21);
		
		Card card22 = new Card("c21",
				 "The World",
				 "Major Arcana",
				 "Completion, recognition, fulfillment, triumph, celebration",
				 "Imperfection, disappointment, shortcuts, shortsightedness, anxiety");
		addCard("c21", card22);
		
		//Minor Arcana
 		//Cups
		Card card23 = new Card("c22",
				 "Ace of Cups",
				 "Minor Arcana-Cups",
				 "Happiness, love, intimacy, new emotions, compassion",
				 "Relationship problems, depression, sadness, creative block, repression");
		addCard("c22", card23);
		
		Card card24 = new Card("c23",
				 "Two of Cups",
				 "Minor Arcana-Cups",
				 "Happy relationship, equality, partnership, attraction, connection",
				 "Imbalance, discord, separation, incompatibility, power imbalance");
		addCard("c23", card24);
		
		Card card25 = new Card("c24",
				 "Three of Cups",
				 "Minor Arcana-Cups",
				 "Celebration, friends, indulgence, parties, community",
				 "Overindulgence, infidelity, disintegrating bonds, gossip, isolation");
		addCard("c24", card25);
		
		Card card26 = new Card("c25",
				 "Four of Cups",
				 "Minor Arcana-Cups",
				 "A lack of awareness, pessimism, daydreaming, lethargy, reevaluation",
				 "Motivation, opportunity, optimism, restlessness, boredom");
		addCard("c25", card26);
		
		Card card27 = new Card("c26",
				 "Five of Cups",
				 "Minor Arcana-Cups",
				 "Self-pity, guilt, regret, stagnation, depression",
				 "Moving on, forgiveness, acceptance, finding peace, encouragement");
		addCard("c26", card27);
		
		Card card28 = new Card("c27",
				 "Six of Cups",
				 "Minor Arcana-Cups",
				 "Nostalgia, old friends, simple joys, sharing, childhood",
				 "The future, letting go, leaving home, rose-tinted glasses");
		addCard("c27", card28);
		
		Card card29 = new Card("c28",
				 "Seven of Cups",
				 "Minor Arcana-Cups",
				 "Daydreaming, fantasy, decisions, wishful thinking, procrastination",
				 "Reality, clarity, temptation, confusion, diversion");
		addCard("c28", card29);
		
		Card card30 = new Card("c29",
				 "Eight of Cups",
				 "Minor Arcana-Cups",
				 "Walking away, introspection, escapism, withdrawal, seeking truth",
				 "Aimlessness, fear of abandonment, depression, settling, hopelessness");
		addCard("c29", card30);
		
		Card card31 = new Card("c30",
				 "Nine of Cups",
				 "Minor Arcana-Cups",
				 "Dreams realized, fulfillment, pleasure, recognition, triumph",
				 "Greed, devastation, pessimism, addiction, self-loathing");
		addCard("c30", card31);
		
		Card card32 = new Card("c31",
				 "Ten of Cups",
				 "Minor Arcana-Cups",
				 "Harmony, reunions, security, domestic bliss, found family",
				 "Dysfunctional family, broken home, instability, conflict, neglect");
		addCard("c31", card32);
		
		Card card33 = new Card("c32",
				 "Page of Cups",
				 "Minor Arcana-Cups",
				 "Youthfulness, idealism, sensitivity, romance, spirituality",
				 "Bad news, jealousy, obsession, chilhood problems, immaturity");
		addCard("c32", card33);
		
		Card card34 = new Card("c33",
				 "Knight of Cups",
				 "Minor Arcana-Cups",
				 "Chivalry, affection, invitations, taking action, meaningful gifts",
				 "Heartbreak, infidelity, lack of diplomacy, moodiness, pettiness");
		addCard("c33", card34);
		
		Card card35 = new Card("c34",
				 "Queen of Cups",
				 "Minor Arcana-Cups",
				 "Feminity, warmth, empathy, a counselor, intuition",
				 "Immaturity, selfishness, smothering, sulking, spite");
		addCard("c34", card35);
		
		Card card36 = new Card("c35",
				 "King of Cups",
				 "Minor Arcana-Cups",
				 "Devotion, loyalty, faithfulness, wisdom, generosity",
				 "Anxiety, lack of caring, control, violence, imbalance");
		addCard("c35", card36);
		
		//Coins
		Card card37 = new Card("c36",
				 "Ace of Coins",
				 "Minor Arcana-Coins",
				 "New business, money, investments, abundance, security",
				 "Bad finances, excessive spending, greed, stinginess, poor planing");
		addCard("c36", card37);
		
		Card card38 = new Card("c37",
				 "Two of Coins",
				 "Minor Arcana-Coins",
				 "Multitasking, balance, choice, flexibility, priorization",
				 "Disoganization, a façade, overwhelm, overextending, financial mess");
		addCard("c37", card38);
		
		Card card39 = new Card("c38",
				 "Three of Coins",
				 "Minor Arcana-Coins",
				 "Studying, growth, collaboration, success, recognition",
				 "Poor work ethic, apathy, lack pf goals, willfulness");
		addCard("c38", card39);
		
		Card card40 = new Card("c39",
				 "Four of Coins",
				 "Minor Arcana-Coins",
				 "Hoarding, possession, financial stability, materialism, stinginess",
				 "Gambling, recklessness, letting go, generosity, large purchases");
		addCard("c39", card40);
		
		Card card41 = new Card("c40",
				 "Five of Coins",
				 "Minor Arcana-Coins",
				 "Recession, adversity, isolation, unemployment, ruin",
				 "Paid debts, improved finances, positive change, acceptance, recovery");
		addCard("c40", card41);
		
		Card card42 = new Card("c41",
				 "Six of Coins",
				 "Minor Arcana-Coins",
				 "Generosity, charity, kindness, value, reward",
				 "Abuse of power, scams, extortion, gullibility, greed");
		addCard("c41", card42);
		
		Card card43 = new Card("c42",
				 "Seven of Coins",
				 "Minor Arcana-Coins",
				 "Reward, perseverance, decisions, investment, fruition",
				 "Shortsightedness, laziness, procrastination, setbacks, delay");
		addCard("c42", card43);
		
		Card card44 = new Card("c43",
				 "Eight of Coins",
				 "Minor Arcana-Coins",
				 "Craftsmanship, commitment, determination, ambition, concentration",
				 "Repetition, poor quality, rushing, bad reputation");
		addCard("c43", card44);
		
		Card card45 = new Card("c44",
				 "Nine of Coins",
				 "Minor Arcana-Coins",
				 "Independence, ancestry, pensions, settling down, financial stability",
				 "Scams, superficiality, overinvestment, work-obsessed, ungrateful");
		addCard("c44", card45);
		
		Card card46 = new Card("c45",
				 "Ten of Coins",
				 "Minor Arcana-Coins",
				 "Inheritance, ancetry, pensions, settling down, financial stability",
				 "Financial disater, disputes, instability, broken traditions");
		addCard("c45", card46);
		
		Card card47 = new Card("c46",
				 "Page of Coins",
				 "Minor Arcana-Coins",
				 "Setting goals, loyalty, positivity, opportunities, manifestation",
				 "A lack of common sense, immaturity, laziness, apathy");
		addCard("c46", card47);
		
		Card card48 = new Card("c47",
				 "Knight of Coins",
				 "Minor Arcana-Coins",
				 "Ambition, hard work, persistance, being efficient",
				 "Impatience, apathy, irresponsability, anxiety");
		addCard("c47", card48);
		
		Card card49 = new Card("c48",
				 "Queen of Coins",
				 "Minor Arcana-Coins",
				 "A healer, luxury, being grounded, practicality, movement",
				 "Jealousy, possession, a lack of organization, manipulation");
		addCard("c48", card49);
		
		Card card50 = new Card("c49",
				 "King of Coins",
				 "Minor Arcana-Coins",
				 "Success, dependability, conservatism, strong will, willing to work",
				 "Corruption, materialism, ruthlessness, authority, indulgence");
		addCard("c49", card50);
		
		//Swords
		Card card51 = new Card("c50",
				 "Ace of Swords",
				 "Minor Arcana-Swords",
				 "New projects, truth, assertiveness, creative thinking, clarity",
				 "Lack of communication, misinformation, rigidity, confusion");
		addCard("c50", card51);
		
		Card card52 = new Card("c51",
				 "Two of Swords",
				 "Minor Arcana-Swords",
				 "Facing fears, a stalemate, denial, opposition, a precarious position",
				 "Indecision, lies exposed, delays, overwhelming fears");
		addCard("c51", card52);
		
		Card card53 = new Card("c52",
				 "Three of Swords",
				 "Minor Arcana-Swords",
				 "Heartbreak, self-harm, sadness, grief, separation",
				 "Overcoming grief, optimism, reconcilliation, forgiviness, seeking help");
		addCard("c52", card53);
		
		Card card54 = new Card("c53",
				 "Four of Swords",
				 "Minor Arcana-Swords",
				 "Sanctuary, recouping, mediation, passivity, counseling",
				 "Awakening, healing, returning, burnout, strenth");
		addCard("c53", card54);
		
		Card card55 = new Card("c54",
				 "Five of Swords",
				 "Minor Arcana-Swords",
				 "Surrender, betrayal, bullying, violence, crime",
				 "Resolutio, compromise, sacrifice, peace, justice");
		addCard("c54", card55);
		
		Card card56 = new Card("c55",
				 "Six of Swords",
				 "Minor Arcana-Swords",
				 "Healing, moving foward, stabiliy, escape, journeys",
				 "Feeling trapped, instability, canceled travel, abuse, unresolved issues");
		addCard("c55", card56);
		
		Card card57 = new Card("c56",
				 "Seven of Swords",
				 "Minor Arcana-Swords",
				 "Strategy, cunning, thievery, cheating, manipulation",
				 "Conscience, confession, getting caught, outsmarted, deception");
		addCard("c56", card57);
		
		Card card58 = new Card("c57",
				 "Eight of Swords",
				 "Minor Arcana-Swords",
				 "Anxiety, victimhood, feeling trapped, paralysis, crisis",
				 "Freedom, new perpectives, taking a stand, strenght, healing");
		addCard("c57", card58);
		
		Card card59 = new Card("c58",
				 "Nine of Swords",
				 "Minor Arcana-Swords",
				 "Anxiety, terror, nightmares, obsession, insomnia",
				 "Recovery, acceptance, letting go, accepting help, hope");
		addCard("c58", card59);
		
		Card card60 = new Card("c59",
				 "Ten of Swords",
				 "Minor Arcana-Swords",
				 "Bitterness, betrayal, rock bottom, martyrdom, severing ties",
				 "Surviving disater, recovery, regeneration, the inevitable");
		addCard("c59", card60);
		
		Card card61 = new Card("c60",
				 "Page of Swords",
				 "Minor Arcana-Swords",
				 "Talkativeness, energy, thoughtfulness, curiosity, truthfulness",
				 "Bluntness, cynicism, defensiveness, sullenness, all talk");
		addCard("c60", card61);
		
		Card card62 = new Card("c61",
				 "Knight of Swords",
				 "Minor Arcana-Swords",
				 "Intellect. bravery, confidence, being action-oriented",
				 "Rudeness, bullying, an inferiority complex, passivity");
		addCard("c61", card62);
		
		Card card63 = new Card("c62",
				 "Queen of Swords",
				 "Minor Arcana-Swords",
				 "Protection, meaningful criticism, tough love, skepticism, intelligence",
				 "Bitterness, vindication judgement, malice, pessimism");
		addCard("c62", card63);
		
		Card card64 = new Card("c63",
				 "King of Swords",
				 "Minor Arcana-Swords",
				 "Authority, structure, logic, self-discipline, loyalty",
				 "A dictator, cruelty, violence, oppression, cynicism");
		addCard("c63", card64);
		
		//Wands
		Card card65 = new Card("c64",
				 "Ace of Wands",
				 "Minor Arcana-Wands",
				 "Excitement, creativity, a spark, growth, new beginnings",
				 "Delays, bad news, a creative block, wasted talent");
		addCard("c64", card65);
		
		Card card66 = new Card("c65",
				 "Two of Wands",
				 "Minor Arcana-Wands",
				 "Decisions, travel, business opportunities, future plannig, cooperation",
				 "Indecision, doubt, fear of the unknown, playing it safe");
		addCard("c65", card66);
		
		Card card67 = new Card("c66",
				 "Three of Wands",
				 "Minor Arcana-Wands",
				 "Self-motivation, freedom, reward, romance",
				 "Returning home, wallowing, frustation, delays");
		addCard("c66", card67);
		
		Card card68 = new Card("c67",
				 "Four of Wands",
				 "Minor Arcana-Wands",
				 "Reunion, success, pride, happiness, family",
				 "Self-doubt, diaspora, canceled plans, gloom");
		addCard("c67", card68);
		
		Card card69 = new Card("c68",
				 "Five of Wands",
				 "Minor Arcana-Wands",
				 "Rivalry, opponents, disagreement, competition, clashing egos",
				 "Compromise, peace, harmony, resolution, conflict avoidance");
		addCard("c68", card69);
		
		Card card70 = new Card("c69",
				 "Six of Wands",
				 "Minor Arcana-Wands",
				 "Victory, praise, achievement, reward, fame",
				 "Ego, pride, disrepute, a fall from grace");
		addCard("c69", card70);
		
		Card card71 = new Card("c70",
				 "Seven of Wands",
				 "Minor Arcana-Wands",
				 "Endurance, attack, fighting for beliefs, perseverance, mounting a defense",
				 "Giving up, defeat, timidity, cowardice, overwhelmed");
		addCard("c70", card71);
		
		Card card72 = new Card("c71",
				 "Eight of Wands",
				 "Minor Arcana-Wands",
				 "Speed, momentum, travel, excitement, results",
				 "Lethargy, delays, bad news, slowness, frustration");
		addCard("c71", card72);
		
		Card card73 = new Card("c72",
				 "Nine of Wands",
				 "Minor Arcana-Wands",
				 "Fatigue, persistence, gathering strength, wounds, resilience",
				 "A stalemate, stubbornness, hesitance, giving in, paranoia");
		addCard("c72", card73);
		
		Card card74 = new Card("c73",
				 "Ten of Wands",
				 "Minor Arcana-Wands",
				 "Overwhelm, stress, obligation, refusing aide, duty",
				 "Avoidance, burnout, overcommitting, streched thin, giving up");
		addCard("c73", card74);
		
		Card card75 = new Card("c74",
				 "Page of Wands",
				 "Minor Arcana-Wands",
				 "Playfulness, charisma, discovery, a rogue, enthusiasm",
				 "Naïvety, petulance, a lack of imagination, pessimism");
		addCard("c74", card75);
		
		Card card76 = new Card("c75",
				 "Knight of Wands",
				 "Minor Arcana-Wands",
				 "Adventure, passion, a rebel, a flirt, a hot temper",
				 "Arrogance, jealousy, abuse, recklessness, a braggart");
		addCard("c75", card76);
		
		Card card77 = new Card("c76",
				 "Queen of Wands",
				 "Minor Arcana-Wands",
				 "Optimism, independence, confidence, passion, verve",
				 "Jealousy, spite, avarice, destruction, demands");
		addCard("c76", card77);
		
		Card card78 = new Card("c77",
				 "King of Wands",
				 "Minor Arcana-Wands",
				 "Honesty, passion, leadership, charm, flexibility",
				 "Tyranny, a lack of harmony, weakness, volatility");
		addCard("c77", card78);
		
		return cardMap.values();
	}
	
	public void init() {
		
		spreadMap = new HashMap<String,Spread>();
		customMap = new HashMap<String,CustomCard>();
		gameMap = new HashMap<String,Game>();
		
		
		
		
		// Create spreads
		Spread spreadaiss = new Spread();
		spreadaiss.setName("Five-Card Spread");
		spreadaiss.setType(SpreadType.Daily);
		spreadaiss.setDescription("Card 1 represents the present, Card 2 represents the past, Card 3 represents the future, Card 4 shows unseen influences affecting the situation, and Card 5 represents the potential for an alternate future");
		spreadaiss.setNumCard(5);
		addSpread(spreadaiss);
		
		Spread decisions = new Spread();
		decisions.setName("Make a decision");
		decisions.setType(SpreadType.Daily);
		decisions.setDescription("When you are between two options you can use this spread, so that you can easily make a decision. Each card talk about the consecuences of one of the options.");
		decisions.setNumCard(2);
		addSpread(decisions);
		
		
		// Create custom cards
		CustomCard cc1 = new CustomCard("Belen Esteban", 
				CustomSuit.celebrities,
				"Vast, Selective, Sassy, Icky",
				"Brainy, Roomy, Gorgeous, Puffy");
		addCustomCard(cc1);
		
		CustomCard cc2 = new CustomCard("Sponge Bob", 
				CustomSuit.characters,
				"Careless, dumb decisions, sacandalous, selfish",
				"Educational, obedient, smart decisions");
		addCustomCard(cc2);
		
		
		CustomCard cc3 = new CustomCard("Squirrel", 
				CustomSuit.animals,
				"Cute, puffy, sleepy, noisy",
				"Terrific, aggresive, sordid");
		addCustomCard(cc3);
		
		CustomCard cc4 = new CustomCard("Minokawa", 
				CustomSuit.mythology,
				"Giant, fearless, ambitious, persistance",
				"Coward, lazy, cryful");
		addCustomCard(cc4);
		
		CustomCard cc5 = new CustomCard("Computer expert", 
				CustomSuit.others,
				"Geek, shy, awkward, nerdy",
				"Social, outgoing, popular");
		addCustomCard(cc5);
		
		
		// Create Games
		Game g1 = new Game("Partita",
				"Italy",
				GameDifficulty.Easy,
				4,
				54,
				"Trumps from I to XXI, The Fool, Spades and Clubs: King, Queen, Cavalier, Valet, Ten to Seven, Diamonds and Hearts: King, Queen, Cavalier, Valet, Ace to Four",
				"Card strength\n"
				+ "Trumps:\n"
				+ "Trumps are the strongest and always take the trick when played. By strength they go from XXI(the strongest) to VI, and trump I, II, III, III and V are all of equal strength. In case that any of the trumps from I to V are played in the same trick, the last one played wins the trick.\n"
				+ "\n"
				+ "Suits:\n"
				+ "Suits go from strongest to weakest in this order:\n"
				+ "\n"
				+ "Spades and Clubs: King, Queen, Cavalier, Valet, Ten to Seven\n"
				+ "Diamonds and Hearts: King, Queen, Cavalier, Valet, Ace to Four\n"
				+ "The Fool:\n"
				+ "The Fool is an excuse. He can be played at any time as an excuse to not play a card. The team that played the Fool takes him into their trick pile.\n"
				+ "\n"
				+ "Teams, the game and the dealer\n"
				+ "Partita is played in fixed teams for an entire game. One game usually consists of four deals, but if you want you can change that, so that you can play the entire night in fixed teams.\n"
				+ "\n"
				+ "Teams are formed in regards to the dealer. Dealer of the next game is always the partner of the player who dealt the last hand of the previous game. The first dealer is chosen at random by card draw.\n"
				+ "\n"
				+ "The deal\n"
				+ "Each player is dealt 13 cards and the dealer takes the last two, so he has 15 cards. The dealer then discards two cards into his teams trick pile. He can not discard Kings, Trump I or XXI and the Fool. He can only discard trumps if he has no other option, but he has to announce it and show them to the other players.\n"
				+ "\n"
				+ "Gameplay\n"
				+ "The game itself is played like any other tarot trick taking card game. The dealer leads the first trick and other players must follow suite, if they can’t, they have to play a trump, if they don’t have a trump, they can play any card(but it doesn’t win). The player that took the previous trick always leads the next trick. Play continues this way until players run out of cards.\n"
				+ "\n"
				+ "Scoring\n"
				+ "Scoring is done is done by counting two cards at a time. Each pair of cards is worth 1 point, plus the value of any court cards or the I and XXI of trumps that it might contain. Value of these cards is as follows:\n"
				+ "\n"
				+ "Trump XXI = 4 points\n"
				+ "Trump I = 4 points\n"
				+ "Kings = 4 points\n"
				+ "Queens = 3 points\n"
				+ "Cavaliers = 2 points\n"
				+ "Valets = 1 point\n"
				+ "The Fool is always counted separately and is worth 5 points.\n"
				+ "\n"
				+ "If a team has an odd number of cards, the odd empty card is also worth 1 point.\n"
				+ "\n"
				+ "If a team scored below 40 points, it gets a negative score equal to the difference between 40 and their score.\n"
				+ "\n"
				+ "If a team scored above 40 points, it gets a positive score equal to the difference between 40 and their score.");
		addGame(g1);
		
		Game g2 = new Game("French Tarot",
				"French",
				GameDifficulty.Hard,
				3,
				78,
				"21 numbered trump cards (atouts), and 1 unnumbered trump card: the \"Excuse\" or \"Fool\" (L'excuse or Fou)\n"
				+ "3 of which (oudlers) are trumps with particular importance: the 1 of trumps, the 21 of trumps and the \"Excuse\" (or Fool) as these determine the contract the taker commits to in that particular game.\n"
				+ "4 suits of 14 cards each:\n"
				+ "numbered \"pip cards\" (aka 'fillers') from 1 to 10 have no true value, except when taking its \"fold\" or add .5 point at counting (the \"Ace\" has always the lowest value and so it is marked with number 1 instead of the \"A\" common in 52-card decks),\n"
				+ "four \"face cards\"; the Valet (Jack), Cavalier (Knight; not seen in 52-card decks), Dame (Queen) and Roi (King) are respectively worth 2, 3, 4 and 5 points at end of match counting.",
				"Rank of cards\n"
				+ "Three cards known as oudlers (\"honors\") are of particular importance in the game: the 1 of trumps (le petit or \"Little one\"), the 21 of trumps (le monde or \"The World\", a holdover from the name of this card in the Tarot of Marseilles), and the Excuse (the Fool). These cards, when captured by the high bidder, lower the point threshold needed to fulfill the contract. In colloquial French, oudlers are often referred to as bouts (ends).\n"
				+ "\n"
				+ "The ranking of the hearts, clubs, diamonds and spades from the top is: King, Queen, Knight, Jack, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 (Ace).\n"
				+ "\n"
				+ "As an aside, the trumps and Fool can be removed to yield a 56-card deck very similar to a 52-card French deck but with the additional Cavalier (knight, lit. horseman) court card in each suit. This deck configuration, plus the Fool, was copied using culture-neutral card designs and values to create the deck for the Rook game.\n"
				+ "\n"
				+ "Excuse\n"
				+ "The only card with a special effect is the \"Fool\", L'Excuse. The Excuse may be played on any trick; it \"excuses\" the player from following suit. However, it normally doesn't win the trick. The card also normally remains the property of the person who played it, not the winner of that trick; to compensate for this in the scoring count, the owner of the Excuse should instead give the winner of the trick a half-point card (a trump other than an oudler, or a suited number card; see Scoring) from his or her score pile.\n"
				+ "\n"
				+ "Two common exceptions to the above behaviors are seen when the Excuse is played on the last trick, and what happens depends on whether the side playing the Fool has taken all the previous tricks (see Chelem/Slam below). If the side has taken all previous tricks, the card takes the last trick; if not, it changes hands to the other side, even if the trick is won by a partner or fellow defender of the person playing it."
				+ "Three-player variant\n"
				+ "The dog consists of six cards, each hand of 24 cards, dealt in packets of three. 13 trumps are needed for a single handful, 15 for a double handful, 18 for a triple."
				+ "Scoring\n"
				+ "When the last trick has been played, the round ends. The taker counts the number of oudlers and the point value of all cards in his scoring pile. Alternatively, if the taker has taken the majority of tricks, the defenders can pool their scoring piles and count their oudlers and points; the taker has all remaining points.\n"
				+ "\n"
				+ "Value of the cards\n"
				+ "Cards for scoring purposes are divided into two groups: \"counters\" (face cards and oudlers) and \"ordinary\" cards or cartes basses (any suited pip card, and any trump except the 1 and 21). Cards are paired, with each counter matched to an ordinary card, and remaining ordinary cards are also paired. The values of pairs are then counted and summed:\n"
				+ "\n"
				+ "1 King or oudler + 1 ordinary card: 5 points\n"
				+ "1 Queen + 1 ordinary card: 4 points\n"
				+ "1 Knight + 1 ordinary card: 3 points\n"
				+ "1 Jack + 1 ordinary card: 2 points\n"
				+ "2 ordinary cards: 1 point\n"
				+ "Each card thus has an individual value; the pairing simply makes it easier to count points. If a card cannot be paired, because there are an odd number in the scoring pile (common with three or five players) or more counters than ordinary cards:\n"
				+ "\n"
				+ "Kings and oudlers are worth 4+1⁄2 points each;\n"
				+ "Queens are worth 3+1⁄2;\n"
				+ "Knights are worth 2+1⁄2;\n"
				+ "Jacks are worth 1+1⁄2;\n"
				+ "All other cards are worth 1⁄2 point.\n"
				+ "Winning\n"
				+ "The number of points the taker needs depends on how many of the oudlers (Excuse, Petit, 21 of trumps) are among his won tricks.\n"
				+ "\n"
				+ "With 3 oudlers the taker needs at least 36 card points to win;\n"
				+ "With 2 oudlers the taker needs at least 41 card points to win;\n"
				+ "With 1 oudler the taker needs at least 51 card points to win;\n"
				+ "With none the taker needs at least 56 card points to win.\n"
				+ "There are 91 points to be taken in a round, so if the taker has:\n"
				+ "\n"
				+ "3 oudlers, the defenders need at least 55+1⁄2 card points to win;\n"
				+ "2 oudlers, the defenders need at least 50+1⁄2 card points to win;\n"
				+ "1 oudler, the defenders need at least 40+1⁄2 card points to win;\n"
				+ "no oudler, the defenders need at least 35+1⁄2 card points to win.");
		addGame(g2);
	}
	
	
	
	
	
	
	// Spread related operations
	@Override
	public void addSpread(Spread s) {
		String id = "s" + indexS++;	
		s.setId(id);
		spreadMap.put(id,s);
	}
	
	@Override
	public Collection<Spread> getAllSpreads() {
			return spreadMap.values();
	}

	@Override
	public Spread getSpread(String id) {
		return spreadMap.get(id);
	}
	
	@Override
	public void updateSpread(Spread s) {
		spreadMap.put(s.getId(),s);
	}

	@Override
	public void deleteSpread(String id) {	
		spreadMap.remove(id);
	}
	

	@Override
	public Map<String, String> getCards() {
		return getCards();
	}

	
	// Card related operations
	
	@Override
	public void addCard(Card c) {
		String id = "c" + indexC++;
		c.setId(id);
		cardMap.put(id, c);
	}
	
	@Override
	public void addCard(String id, Card c) {
		cardMap.put(id, c);
	}
	
	@Override
	public Collection<Card> getAllCards() {
			return cardMap.values();
	}

	@Override
	public Card getCard(String cardId) {
		return cardMap.get(cardId);
	}

	@Override
	public void updateCard(Card c) {
		Card card = cardMap.get(c.getId());
		card.setName(c.getName());
		card.setSuit(c.getSuit());
		card.setUpright(c.getUpright());
		card.setReversed(c.getReversed());
	}

	@Override
	public void deleteCard(String cardId) {
		cardMap.remove(cardId);
	}

	
	// Custom Cards related operations
	
	@Override
	public void addCustomCard(CustomCard c) {
		String id = "cc" + indexCC++;
		c.setId(id);
		customMap.put(id, c);
		
	}

	@Override
	public Collection<CustomCard> getAllCustomCards() {
		return customMap.values();
	}

	@Override
	public CustomCard getCustomCard(String cardId) {
		return customMap.get(cardId);
	}

	@Override
	public void updateCustomCard(CustomCard c) {
		CustomCard card = customMap.get(c.getId());
		card.setName(c.getName());
		card.setSuit(c.getSuit());
		card.setUpright(c.getUpright());
		card.setReversed(c.getReversed());
		
	}

	@Override
	public void deleteCustomCard(String cardId) {
		customMap.remove(cardId);
		
	}

	
	// Game related operations
	
	@Override
	public void addGame(Game g) {
		String id = "g" + indexG++;
		g.setId(id);
		gameMap.put(id, g);
		
	}

	@Override
	public Collection<Game> getAllGames() {
		return gameMap.values();
	}

	@Override
	public Game getGame(String cardId) {
		return gameMap.get(cardId);
	}

	@Override
	public void updateGame(Game g) {
		Game game = gameMap.get(g.getId());
		game.setName(g.getName());
		game.setOrigin(g.getOrigin());
		game.setDifficulty(g.getDifficulty());
		game.setNumCards(g.getNumCards());
		game.setDeckDescription(g.getDeckDescription());
		game.setRules(g.getRules());
		
	}

	@Override
	public void deleteGame(String cardId) {
		gameMap.remove(cardId);
		
	}

	
}
