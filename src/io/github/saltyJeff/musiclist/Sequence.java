package io.github.saltyJeff.musiclist;

import javax.sound.sampled.*;

public class Sequence {
	private Note firstNote;
	private Note lastNote;
	private AudioFormat af;
	private SourceDataLine line;
	
	private static int SAMPLERATE = 32000; //32 khz
	private static double OFFDURATION = 0.03;
	public Sequence () {
		af = new AudioFormat(SAMPLERATE, 8, 1, true, true);
		try {
			line = AudioSystem.getSourceDataLine(af);
			line.open(af, SAMPLERATE);
		} catch (LineUnavailableException e) {
			System.err.println("Error, cannot get audio line");
			e.printStackTrace();
		}
	}
	public void addFirstNote(Note n) {
		if(firstNote == null) {
			firstNote = n;
			lastNote = n;
			return;
		}
		n.next = firstNote;
		firstNote.prev = n;
		firstNote = n;
	}
	public void addLastNote(Note n) {
		if(lastNote == null) {
			firstNote = n;
			lastNote = n;
			return;
		}
		lastNote.next = n;
		n.prev = lastNote;
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
	public Note removeAtIndex(int index) {
		if(index == 0) {
			Note originalNote = firstNote;
			firstNote = originalNote.next;
			if(originalNote.next != null) {
				originalNote.next.prev = null;
			}
			return originalNote;
		}
		else {
			int i = 0;
			Note list = firstNote;
			while(list != null && i < index) {
				i++;
				list = list.next;
			}
			Note originalList = list;
			if(originalList == lastNote) {
				if(originalList.prev != null) {
					originalList.prev.next = null;
				}
				lastNote = originalList.prev;
			}
			else {
				originalList.prev.next = originalList.next;
				originalList.next.prev = originalList.prev;
			}
			return originalList;
		}
	}
	public void clear() {
		firstNote = null;
		lastNote = null;
	}
	public void play() {
		line.start();
		Note note = firstNote;
		while(note != null) {
			byte[] buffer = generateWave(note);
			line.write(buffer, 0, buffer.length);
			note = note.next;
		}
		line.drain();
	}
	private static byte[] generateWave(Note n) {
		int samples = (int)(n.duration * SAMPLERATE);
		int offSamples = (int)(OFFDURATION * SAMPLERATE); //add the off samples
		byte[] wave = new byte[samples + offSamples];
		double period = SAMPLERATE / n.getPitch();
		for(int i = 0; i < wave.length; i++) {
			double angle = 2.0 * Math.PI * i / period; //step between i steps per period
	        wave[i] = (byte)(Math.sin(angle) * 127f); //sin between -127->127  
		}
		for(int i = samples; i < samples + offSamples; i++ ) {
			wave[i] = 0; //add some off samples so the notes are separate
		}
		return wave;
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
