package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Song;


public class ComparatorNameArtist implements Comparator<Song> {

	@Override
	public int compare(Song p1, Song p2) {
		return p1.getArtist().compareTo(p2.getArtist());
	}

}
