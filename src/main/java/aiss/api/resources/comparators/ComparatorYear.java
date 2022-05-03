package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Song;


public class ComparatorYear implements Comparator<Song> {

	@Override
	public int compare(Song p1, Song p2) {
		return p1.getYear().compareTo(p2.getYear());
	}

}
