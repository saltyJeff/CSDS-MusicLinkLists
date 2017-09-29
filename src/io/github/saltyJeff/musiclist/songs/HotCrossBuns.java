package io.github.saltyJeff.musiclist.songs;

import io.github.saltyJeff.musiclist.Note;
import io.github.saltyJeff.musiclist.Sequence;

//ALEK I WANT ME A PARSER/SERIALIZER
public class HotCrossBuns {
	public static Sequence getSong() {
		Sequence seq = new Sequence();
		seq.addLastNote(new Note('E', ' ', 4, 0.3));
		seq.addLastNote(new Note('D', ' ', 4, 0.3));
		seq.addLastNote(new Note('C', ' ', 4, 0.6));
		seq.addLastNote(new Note('E', ' ', 4, 0.3));
		seq.addLastNote(new Note('D', ' ', 4, 0.3));
		seq.addLastNote(new Note('C', ' ', 4, 0.6));
		seq.addLastNote(new Note('C', ' ', 4, 0.3));
		seq.addLastNote(new Note('C', ' ', 4, 0.3));
		seq.addLastNote(new Note('D', ' ', 4, 0.3));
		seq.addLastNote(new Note('D', ' ', 4, 0.3));
		seq.addLastNote(new Note('E', ' ', 4, 0.3));
		seq.addLastNote(new Note('D', ' ', 4, 0.3));
		seq.addLastNote(new Note('C', ' ', 4, 0.6));
		return seq;
	}
}
