package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Card;


public class ComparatorSuit implements Comparator<Card> {

	@Override
	public int compare(Card p1, Card p2) {
		return p1.getSuit().compareTo(p2.getSuit());
	}

}
