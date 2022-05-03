package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Spread;

public class ComparatorNameSpreadReversed implements Comparator<Spread> {

	public int compare(Spread p1, Spread p2) {
		return p2.getName().compareTo(p1.getName());
	}

}
