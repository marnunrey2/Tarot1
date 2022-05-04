package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Card;

public class ComparatorNameReversed implements Comparator<Card> {

	public int compare(Card p1, Card p2) {
		return p2.getName().compareTo(p1.getName());
	}

}
