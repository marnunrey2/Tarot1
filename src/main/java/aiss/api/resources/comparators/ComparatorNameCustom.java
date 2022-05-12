package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.CustomCard;

public class ComparatorNameCustom implements Comparator<CustomCard> {

	@Override
	public int compare(CustomCard p1, CustomCard p2) {
		return p1.getName().compareTo(p2.getName());
	}

}
