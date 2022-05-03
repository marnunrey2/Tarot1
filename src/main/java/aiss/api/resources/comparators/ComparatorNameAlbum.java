package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Song;


public class ComparatorNameAlbum implements Comparator<Song> {

	@Override
	public int compare(Song p1, Song p2) {
		return p1.getAlbum().compareTo(p2.getAlbum());
	}

}
