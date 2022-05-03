package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Card;


public class ComparatorUpright implements Comparator<Card> {

	@Override
	public int compare(Card p1, Card p2) {
		return p1.getUpright().compareTo(p2.getUpright());
	}

}
