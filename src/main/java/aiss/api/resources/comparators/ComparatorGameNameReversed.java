package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Game;

public class ComparatorGameNameReversed implements Comparator<Game> {

	@Override
	public int compare(Game g1, Game g2) {
		// TODO Auto-generated method stub
		return g2.getName().compareTo(g1.getName());
	}

}
