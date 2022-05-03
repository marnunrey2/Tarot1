package aiss.api.resources;

import static org.junit.Assert.*;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import aiss.api.Card;

public class CardResourceTest {
	
	static Card card1, card2, card3,card4,card5,card6,card7,card8,card9,card10,card11,card12,card13,card14,card15,
	card16,card17,card18,card19,card20,card21,card22,card23,card24,card25,card26,card27,card28,card29,card30,card31,card32,
	card33,card34,card35,card36,card37,card38,card39,card40,card41,card42,card43,card44,card45,card46,card47,card48,card49,
	card50,card51,card52,card53,card54,card55,card56,card57,card58,card59,card60,card61,card62,card63,card64,card65,card66,
	card67,card68,card69,card70,card71,card72,card73,card74,card75,card76,card77,card78,testCard1,testCard2,testCard3;
	static CardResource sr = new CardResource();
	
	@BeforeClass
	public static void setup() throws Exception {
		//Cards
			//Major Arcana
		 card1 = sr.addCard(new Card("The Fool",
				 "Major Arcana",
				 "Beginnings, possibilities, impulsiveness, inocence, a free spirit",
				 "Apathy, hesitation, a faluty choice, doldrums, recklessness"));
		 card2 = sr.addCard(new Card("The Magician",
				 "Major Arcana",
				 "Originality, self-confidence, skill, a breakthrough, resourcefulness",
				 "Insecurity, delay, lack of imagination, colsed doors, manipulation"));
		 card3 = sr.addCard(new Card("The High Priestess",
				 "Major Arcana",
				 "Wisdom, intuition, dreams, meandering, an enigma",
				 "Ignorance, shallowness, lack of trust, a close mind, secrets"));
		 card4 = sr.addCard(new Card("The Empress",
				 "Major Arcana",
				 "Fertility, nurturing, accomplishment, nature, abundance",
				 "Feeling undesirable, anxiety, lack of concentartion, smothering, selfishness"));
		 card5 = sr.addCard(new Card("The Emperor",
				 "Major Arcana",
				 "Stability, leadership, bravery, bold action, structure",
				 "Immaturity, pettiness, rigidity, domination, anger"));
		 card6 = sr.addCard(new Card("The Hierophant",
				 "Major Arcana",
				 "Conformity, compassion, social approval, tradition, legacy",
				 "Bucking Trends, vulnerability, feeling adrift, blind faith"));
		 card7 = sr.addCard(new Card("The Lovers",
				 "Major Arcana",
				 "Love, harmony, trust, a leap of faith, choice",
				 "Unreliability, separation, second-guessing, values, conflict"));
		 card8 = sr.addCard(new Card("The Chariot",
				 "Major Arcana",
				 "A journey, perseverance, rushed decisions, vengeance, victory",
				 "A lack of direction, floundering, stagnation, willfulness"));
		 card9 = sr.addCard(new Card("Strength",
				 "Major Arcana",
				 "Courage, determination, conviction, control, patience",
				 "Weakness, self-doubt, abuse of power, pride, negligence"));
		 card10 = sr.addCard(new Card("The Hermit",
				 "Major Arcana",
				 "Instrospection, withdrawal, prudence, insight, meditation",
				 "Recklessness, hastiness, avoidance, loneliness, rejection"));
		 card11 = sr.addCard(new Card("The Wheel of Fortune",
				 "Major Arcana",
				 "Fortune, an unexpected windfall, karma, destiny, cycles",
				 "Bad luck, a lack of control, the past, misery, dissapointment"));
		 card12 = sr.addCard(new Card("Justice",
				 "Major Arcana",
				 "Harmony, balance, equality, virtue, honor",
				 "Bias, false accusations, intolerance, abuse, dishonesty"));
		 card13 = sr.addCard(new Card("The Hanged Man",
				 "Major Arcana",
				 "Suspension, restriction, sacrifice, readjustment, improvement",
				 "Willfulness, useless sacrifice, rushing, thoughtlessness, martyrdom"));
		 card14 = sr.addCard(new Card("Death",
				 "Major Arcana",
				 "Metamorphosis, evolution, loss, transition, change",
				 "Stagnation, immobility, stubborness, festering, decay"));
		 card15 = sr.addCard(new Card("Temperance",
				 "Major Arcana",
				 "Moderation, harmony, purpose, good influence, reconciliation",
				 "Conflict, hostility, frustration, impatience, reclutance"));
		 card16 = sr.addCard(new Card("The Devil",
				 "Major Arcana",
				 "Greed, controversy, violence, strange experiences, addiction",
				 "Release, enlightenment, power reclaimed, divorce, moving on"));
		 card17 = sr.addCard(new Card("The Tower",
				 "Major Arcana",
				 "Massive change, upheaval, catastrophe, rebuilding, revelation",
				 "Feeling trapped, delaying disaster, fear of pain, avoidance"));
		 card18 = sr.addCard(new Card("The Star",
				 "Major Arcana",
				 "Hope, serenity, inspiration, insight, spirituality",
				 "Crushed dreams, insecurity, despair, dejection, exhaustion"));
		 card19 = sr.addCard(new Card("The Moon",
				 "Major Arcana",
				 "Trickery, melancholy, anguish, illusion, insecurity",
				 "Joy, enlightenment, resolution, deception revealed, relief"));
		 card20 = sr.addCard(new Card("The Sun",
				 "Major Arcana",
				 "Satisfaction, accomplishment, joy, luck, vitality",
				 "Missed oportunities, delays, doubt, fear of missing out, depression"));
		 card21 = sr.addCard(new Card("Judgment",
				 "Major Arcana",
				 "Improvement, forgiveness, a change of perspective, absolution, rebirth",
				 "Opression, lack of self-awareness, failure, repeated mistakes, self-loathing"));
		 card22 = sr.addCard(new Card("The World",
				 "Major Arcana",
				 "Completion, recognition, fulfillment, triumph, celebration",
				 "Imperfection, disappointment, shortcuts, shortsightedness, anxiety"));
		 	//Minor Arcana
		 		//Cups
		 card23 = sr.addCard(new Card("Ace of Cups",
				 "Minor Arcana-Cups",
				 "Happiness, love, intimacy, new emotions, compassion",
				 "Relationship problems, depression, sadness, creative block, repression"));
		 card24 = sr.addCard(new Card("Two of Cups",
				 "Minor Arcana-Cups",
				 "Happy relationship, equality, partnership, attraction, connection",
				 "Imbalance, discord, separation, incompatibility, power imbalance"));
		 card25 = sr.addCard(new Card("Three of Cups",
				 "Minor Arcana-Cups",
				 "Celebration, friends, indulgence, parties, community",
				 "Overindulgence, infidelity, disintegrating bonds, gossip, isolation"));
		 card26 = sr.addCard(new Card("Four of Cups",
				 "Minor Arcana-Cups",
				 "A lack of awareness, pessimism, daydreaming, lethargy, reevaluation",
				 "Motivation, opportunity, optimism, restlessness, boredom"));
		 card27 = sr.addCard(new Card("Five of Cups",
				 "Minor Arcana-Cups",
				 "Self-pity, guilt, regret, stagnation, depression",
				 "Moving on, forgiveness, acceptance, finding peace, encouragement"));
		 card28 = sr.addCard(new Card("Six of Cups",
				 "Minor Arcana-Cups",
				 "Nostalgia, old friends, simple joys, sharing, childhood",
				 "The future, letting go, leaving home, rose-tinted glasses"));
		 card29 = sr.addCard(new Card("Seven of Cups",
				 "Minor Arcana-Cups",
				 "Daydreaming, fantasy, decisions, wishful thinking, procrastination",
				 "Reality, clarity, temptation, confusion, diversion"));
		 card30 = sr.addCard(new Card("Eight of Cups",
				 "Minor Arcana-Cups",
				 "Walking away, introspection, escapism, withdrawal, seeking truth",
				 "Aimlessness, fear of abandonment, depression, settling, hopelessness"));
		 card31 = sr.addCard(new Card("Nine of Cups",
				 "Minor Arcana-Cups",
				 "Dreams realized, fulfillment, pleasure, recognition, triumph",
				 "Greed, devastation, pessimism, addiction, self-loathing"));
		 card32 = sr.addCard(new Card("Ten of Cups",
				 "Minor Arcana-Cups",
				 "Harmony, reunions, security, domestic bliss, found family",
				 "Dysfunctional family, broken home, instability, conflict, neglect"));
		 card33 = sr.addCard(new Card("Page of Cups",
				 "Minor Arcana-Cups",
				 "Youthfulness, idealism, sensitivity, romance, spirituality",
				 "Bad news, jealousy, obsession, chilhood problems, immaturity"));
		 card34 = sr.addCard(new Card("Knight of Cups",
				 "Minor Arcana-Cups",
				 "Chivalry, affection, invitations, taking action, meaningful gifts",
				 "Heartbreak, infidelity, lack of diplomacy, moodiness, pettiness"));
		 card35 = sr.addCard(new Card("Queen of Cups",
				 "Minor Arcana-Cups",
				 "Feminity, warmth, empathy, a counselor, intuition",
				 "Immaturity, selfishness, smothering, sulking, spite"));
		 card36 = sr.addCard(new Card("King of Cups",
				 "Minor Arcana-Cups",
				 "Devotion, loyalty, faithfulness, wisdom, generosity",
				 "Anxiety, lack of caring, control, violence, imbalance"));
		 
		 		//Coins
		 card37 = sr.addCard(new Card("Ace of Coins",
				 "Minor Arcana-Coins",
				 "New business, money, investments, abundance, security",
				 "Bad finances, excessive spending, greed, stinginess, poor planing"));
		 card38 = sr.addCard(new Card("Two of Coins",
				 "Minor Arcana-Coins",
				 "Multitasking, balance, choice, flexibility, priorization",
				 "Disoganization, a façade, overwhelm, overextending, financial mess"));
		 card39 = sr.addCard(new Card("Three of Coins",
				 "Minor Arcana-Coins",
				 "Studying, growth, collaboration, success, recognition",
				 "Poor work ethic, apathy, lack pf goals, willfulness"));
		 card40 = sr.addCard(new Card("Four of Coins",
				 "Minor Arcana-Coins",
				 "Hoarding, possession, financial stability, materialism, stinginess",
				 "Gambling, recklessness, letting go, generosity, large purchases"));
		 card41 = sr.addCard(new Card("Five of Coins",
				 "Minor Arcana-Coins",
				 "Recession, adversity, isolation, unemployment, ruin",
				 "Paid debts, improved finances, positive change, acceptance, recovery"));
		 card42 = sr.addCard(new Card("Six of Coins",
				 "Minor Arcana-Coins",
				 "Generosity, charity, kindness, value, reward",
				 "Abuse of power, scams, extortion, gullibility, greed"));
		 card43 = sr.addCard(new Card("Seven of Coins",
				 "Minor Arcana-Coins",
				 "Reward, perseverance, decisions, investment, fruition",
				 "Shortsightedness, laziness, procrastination, setbacks, delay"));
		 card44 = sr.addCard(new Card("Eight of Coins",
				 "Minor Arcana-Coins",
				 "Craftsmanship, commitment, determination, ambition, concentration",
				 "Repetition, poor quality, rushing, bad reputation"));
		 card45 = sr.addCard(new Card("Nine of Coins",
				 "Minor Arcana-Coins",
				 "Independence, ancestry, pensions, settling down, financial stability",
				 "Scams, superficiality, overinvestment, work-obsessed, ungrateful"));
		 card46 = sr.addCard(new Card("Ten of Coins",
				 "Minor Arcana-Coins",
				 "Inheritance, ancetry, pensions, settling down, financial stability",
				 "Financial disater, disputes, instability, broken traditions"));
		 card47 = sr.addCard(new Card("Page of Coins",
				 "Minor Arcana-Coins",
				 "Setting goals, loyalty, positivity, opportunities, manifestation",
				 "A lack of common sense, immaturity, laziness, apathy"));
		 card48 = sr.addCard(new Card("Knight of Coins",
				 "Minor Arcana-Coins",
				 "Ambition, hard work, persistance, being efficient",
				 "Impatience, apathy, irresponsability, anxiety"));
		 card49 = sr.addCard(new Card("Queen of Coins",
				 "Minor Arcana-Coins",
				 "A healer, luxury, being grounded, practicality, movement",
				 "Jealousy, possession, a lack of organization, manipulation"));
		 card50 = sr.addCard(new Card("King of Coins",
				 "Minor Arcana-Coins",
				 "Success, dependability, conservatism, strong will, willing to work",
				 "Corruption, materialism, ruthlessness, authority, indulgence"));
		 
		 		//Swords
		 card51 = sr.addCard(new Card("Ace of Swords",
				 "Minor Arcana-Swords",
				 "New projects, truth, assertiveness, creative thinking, clarity",
				 "Lack of communication, misinformation, rigidity, confusion"));
		 card52 = sr.addCard(new Card("Two of Swords",
				 "Minor Arcana-Swords",
				 "Facing fears, a stalemate, denial, opposition, a precarious position",
				 "Indecision, lies exposed, delays, overwhelming fears"));
		 card53 = sr.addCard(new Card("Three of Swords",
				 "Minor Arcana-Swords",
				 "Heartbreak, self-harm, sadness, grief, separation",
				 "Overcoming grief, optimism, reconcilliation, forgiviness, seeking help"));
		 card54 = sr.addCard(new Card("Four of Swords",
				 "Minor Arcana-Swords",
				 "Sanctuary, recouping, mediation, passivity, counseling",
				 "Awakening, healing, returning, burnout, strenth"));
		 card55 = sr.addCard(new Card("Five of Swords",
				 "Minor Arcana-Swords",
				 "Surrender, betrayal, bullying, violence, crime",
				 "Resolutio, compromise, sacrifice, peace, justice"));
		 card56 = sr.addCard(new Card("Six of Swords",
				 "Minor Arcana-Swords",
				 "Healing, moving foward, stabiliy, escape, journeys",
				 "Feeling trapped, instability, canceled travel, abuse, unresolved issues"));
		 card57 = sr.addCard(new Card("Seven of Swords",
				 "Minor Arcana-Swords",
				 "Strategy, cunning, thievery, cheating, manipulation",
				 "Conscience, confession, getting caught, outsmarted, deception"));
		 card58 = sr.addCard(new Card("Eight of Swords",
				 "Minor Arcana-Swords",
				 "Anxiety, victimhood, feeling trapped, paralysis, crisis",
				 "Freedom, new perpectives, taking a stand, strenght, healing"));
		 card59 = sr.addCard(new Card("Nine of Swords",
				 "Minor Arcana-Swords",
				 "Anxiety, terror, nightmares, obsession, insomnia",
				 "Recovery, acceptance, letting go, accepting help, hope"));
		 card60 = sr.addCard(new Card("Ten of Swords",
				 "Minor Arcana-Swords",
				 "Bitterness, betrayal, rock bottom, martyrdom, severing ties",
				 "Surviving disater, recovery, regeneration, the inevitable"));
		 card61 = sr.addCard(new Card("Page of Swords",
				 "Minor Arcana-Swords",
				 "Talkativeness, energy, thoughtfulness, curiosity, truthfulness",
				 "Bluntness, cynicism, defensiveness, sullenness, all talk"));
		 card62 = sr.addCard(new Card("Knight of Swords",
				 "Minor Arcana-Swords",
				 "Intellect. bravery, confidence, being action-oriented",
				 "Rudeness, bullying, an inferiority complex, passivity"));
		 card63 = sr.addCard(new Card("Queen of Swords",
				 "Minor Arcana-Swords",
				 "Protection, meaningful criticism, tough love, skepticism, intelligence",
				 "Bitterness, vindication judgement, malice, pessimism"));
		 card64 = sr.addCard(new Card("King of Swords",
				 "Minor Arcana-Swords",
				 "Authority, structure, logic, self-discipline, loyalty",
				 "A dictator, cruelty, violence, oppression, cynicism"));
		 
		 		//Wands
		 card65 = sr.addCard(new Card("Ace of Wands",
				 "Minor Arcana-Wands",
				 "Excitement, creativity, a spark, growth, new beginnings",
				 "Delays, bad news, a creative block, wasted talent"));
		 card66 = sr.addCard(new Card("Two of Wands",
				 "Minor Arcana-Wands",
				 "Decisions, travel, business opportunities, future plannig, cooperation",
				 "Indecision, doubt, fear of the unknown, playing it safe"));
		 card67 = sr.addCard(new Card("Three of Wands",
				 "Minor Arcana-Wands",
				 "Self-motivation, freedom, reward, romance",
				 "Returning home, wallowing, frustation, delays"));
		 card68 = sr.addCard(new Card("Four of Wands",
				 "Minor Arcana-Wands",
				 "Reunion, success, pride, happiness, family",
				 "Self-doubt, diaspora, canceled plans, gloom"));
		 card69 = sr.addCard(new Card("Five of Wands",
				 "Minor Arcana-Wands",
				 "Rivalry, opponents, disagreement, competition, clashing egos",
				 "Compromise, peace, harmony, resolution, conflict avoidance"));
		 card70 = sr.addCard(new Card("Six of Wands",
				 "Minor Arcana-Wands",
				 "Victory, praise, achievement, reward, fame",
				 "Ego, pride, disrepute, a fall from grace"));
		 card71 = sr.addCard(new Card("Seven of Wands",
				 "Minor Arcana-Wands",
				 "Endurance, attack, fighting for beliefs, perseverance, mounting a defense",
				 "Giving up, defeat, timidity, cowardice, overwhelmed"));
		 card72 = sr.addCard(new Card("Eight of Wands",
				 "Minor Arcana-Wands",
				 "Speed, momentum, travel, excitement, results",
				 "Lethargy, delays, bad news, slowness, frustration"));
		 card73 = sr.addCard(new Card("Nine of Wands",
				 "Minor Arcana-Wands",
				 "Fatigue, persistence, gathering strength, wounds, resilience",
				 "A stalemate, stubbornness, hesitance, giving in, paranoia"));
		 card74 = sr.addCard(new Card("Ten of Wands",
				 "Minor Arcana-Wands",
				 "Overwhelm, stress, obligation, refusing aide, duty",
				 "Avoidance, burnout, overcommitting, streched thin, giving up"));
		 card75 = sr.addCard(new Card("Page of Wands",
				 "Minor Arcana-Wands",
				 "Playfulness, charisma, discovery, a rogue, enthusiasm",
				 "Naïvety, petulance, a lack of imagination, pessimism"));
		 card76 = sr.addCard(new Card("Knight of Wands",
				 "Minor Arcana-Wands",
				 "Adventure, passion, a rebel, a flirt, a hot temper",
				 "Arrogance, jealousy, abuse, recklessness, a braggart"));
		 card77 = sr.addCard(new Card("Queen of Wands",
				 "Minor Arcana-Wands",
				 "Optimism, independence, confidence, passion, verve",
				 "Jealousy, spite, avarice, destruction, demands"));
		 card78 = sr.addCard(new Card("King of Wands",
				 "Minor Arcana-Wands",
				 "Honesty, passion, leadership, charm, flexibility",
				 "Tyranny, a lack of harmony, weakness, volatility"));
		 
		
		// Test card 1
		testCard1 = sr.addCard(new Card("Test title","Test suit","Test upright","Test reversed"));
		
		// Test card 2
		testCard2 = sr.addCard(new Card("Test title 2","Test suit 2","Test upright 2","Test reversed"));
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		sr.deleteCard(testCard1.getId());
		sr.deleteCard(testCard3.getId());
	}
	
	@Test
	public void testGetAll() {
		Collection<Card> cards = sr.getAll();
		
		assertNotNull("The collection of cards is null", cards);
		
		// Show result
		System.out.println("Listing all cards:");
		int i=1;
		for (Card s : cards) {
			System.out.println("Card " + i++ + " : " + s.getName() + " (ID=" + s.getId() + ")");
		}
	}

	@Test
	public void testGetCard() {
		Card s = sr.getCard(card1.getId());
		
		assertEquals("The id of the cards do not match", card1.getId(), s.getId());
		assertEquals("The title of the cards do not match", card1.getName(), s.getName());
		
		// Show result
		System.out.println("Card id: " +  s.getId());
		System.out.println("Card title: " +  s.getName());
	}

	@Test
	public void testAddCard() {
		String CardName = "Add card test title";
		String CardSuit = "Add card test suit";
		String Cardupright = "Add card test upright";
		String CardReversed = "Add card test reversed";
		
		card3 = sr.addCard(new Card(CardName,CardSuit,Cardupright,CardReversed));
		
		assertNotNull("Error when adding the card",card3);
		assertEquals("The card's title has not been setted correctly", CardName, card3.getName());
		assertEquals("The card's suit has not been setted correctly", CardSuit, card3.getSuit());
		assertEquals("The card's upright has not been setted correctly", Cardupright, card3.getUpright());
		assertEquals("The card's reversed has not been setted correctly", CardReversed, card3.getReversed());

	}

	@Test
	public void testUpdateCard() {
		
		String cardName = "Update card test title";
		String cardSuit = "Update card test suit";
		String cardupright = "Update card test upright";
		String cardReversed = "1995";
		
		// Update card
		card1.setName(cardName);
		card1.setSuit(cardSuit);
		card1.setUpright(cardupright);
		card1.setReversed(cardReversed);
		
		boolean success = sr.updateCard(card1);
		
		assertTrue("Error when updating the card", success);
		
		Card card  = sr.getCard(card1.getId());
		assertEquals("The card's title has not been updated correctly", cardName, card.getName());
		assertEquals("The card's suit has not been updated correctly", cardSuit, card.getSuit());
		assertEquals("The card's upright has not been updated correctly", cardupright, card.getUpright());
		assertEquals("The card's reversed has not been updated correctly", cardReversed, card.getReversed());
	}

	@Test()
	public void testDeleteCard() {
		
		// Delete cards
		System.out.println(card2.getId());
		boolean success = sr.deleteCard(card2.getId());
		
		assertTrue("Error when deleting the card", success);
		
		Card card  = sr.getCard(card2.getId());
		assertNull("The card has not been deleted correctly", card);
	}

}
