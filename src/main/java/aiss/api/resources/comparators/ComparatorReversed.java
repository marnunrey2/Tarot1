package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Card;


public class ComparatorReversed implements Comparator<Card> {

	@Override
	public int compare(Card p1, Card p2) {
		return p1.getReversed().compareTo(p2.getReversed());
	}

}
