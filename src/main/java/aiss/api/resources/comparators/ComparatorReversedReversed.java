package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Card;

public class ComparatorReversedReversed implements Comparator<Card> {

	public int compare(Card p1, Card p2) {
		return p2.getReversed().compareTo(p1.getReversed());
	}

}
