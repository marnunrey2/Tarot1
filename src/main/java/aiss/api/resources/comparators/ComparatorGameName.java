package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Game;

public class ComparatorGameName implements Comparator<Game> {

	@Override
	public int compare(Game g1, Game g2) {
		return g1.getName().compareTo(g2.getName());
	}

}
