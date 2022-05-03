package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Song;

public class ComparatorYearReversed implements Comparator<Song> {

	public int compare(Song p1, Song p2) {
		return p2.getYear().compareTo(p1.getYear());
	}

}
