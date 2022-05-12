package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.CustomCard;

public class ComparatorNameReversedCustom implements Comparator<CustomCard> {

	@Override
	public int compare(CustomCard c1, CustomCard c2) {
		return c2.getName().compareTo(c1.getName());
	}


}
