package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Spread;

public class ComparatorNamePlaylist implements Comparator<Spread> {

	@Override
	public int compare(Spread p1, Spread p2) {
		return p1.getName().compareTo(p2.getName());
	}


}
