package io.github.saltyJeff.musiclist;

public class Sequence {
	private Note firstNote;
	private Note lastNote;

	public void addFirstNote(Note n) {
		if(firstNote == null) {
			firstNote = n;
			lastNote = n;
			return;
		}
		n.next = firstNote;
		firstNote = n;
	}
	public void addLastNote(Note n) {
		if(lastNote == null) {
			firstNote = n;
			lastNote = n;
			return;
		}
		lastNote.next = n;
		lastNote = n;
	}
	public void addAtIndex(Note n, int index) {
		if(index == 0) {
			addFirstNote(n);
			return;
		}
		else {
			int i = 1;
			Note list = firstNote;
			while(list != null && i < index) {
				i++;
				list = list.next;
			}
			Note originalList = list;
			if(originalList != lastNote) {
				originalList.next.prev = n;
			}
			n.next = originalList.next;
			n.prev = originalList;
			originalList.next = n;
		}
	}
	public void play() {
		
	}
	public String toString() {
		Note note = firstNote;
		int i = 0;
		StringBuilder sb = new StringBuilder("Sequence:\n");
		while(note != null) {
			sb.append(i++);
			sb.append(": ");
			sb.append(note);
			note = note.next;
		}
		return sb.toString();
	}
}
