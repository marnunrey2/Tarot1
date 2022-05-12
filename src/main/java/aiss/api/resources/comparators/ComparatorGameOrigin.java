package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Game;

public class ComparatorGameOrigin implements Comparator<Game> {

	@Override
	public int compare(Game g1, Game g2) {
		// TODO Auto-generated method stub
		return g1.getOrigin().compareTo(g2.getOrigin());
	}

}
