package io.github.saltyJeff.musiclist.songs;

import io.github.saltyJeff.musiclist.Note;
import io.github.saltyJeff.musiclist.Sequence;

public class ClaireDeLune {
	public static Sequence getSong() {
		double beat = 0.5;
		Sequence seq = new Sequence();
		seq.addLastNote(new Note('A', 'b', 3, beat));
		seq.addLastNote(new Note('A', 'b', 4, 2*beat));
		seq.addLastNote(new Note('F', ' ', 4, 2*beat));
		seq.addLastNote(new Note('A', ' ', 3, beat));
		seq.addLastNote(new Note('E', 'b', 4, beat));
		seq.addLastNote(new Note('F', ' ', 4, beat));
		seq.addLastNote(new Note('E', 'b', 4, 2*beat));
		seq.addLastNote(new Note('A', 'b', 3, beat));
		seq.addLastNote(new Note('D', 'b', 4, beat));
		seq.addLastNote(new Note('E', 'b', 4, beat));
		seq.addLastNote(new Note('D', 'b', 4, beat));
		seq.addLastNote(new Note('F', ' ', 4, beat));
		seq.addLastNote(new Note('D', 'b', 4, beat));
		seq.addLastNote(new Note('G', ' ', 3, beat));
		seq.addLastNote(new Note('C', ' ', 4, beat));
		seq.addLastNote(new Note('D', 'b', 4, beat));
		seq.addLastNote(new Note('C', ' ', 4, 2*beat));
		return seq;
	}
}
