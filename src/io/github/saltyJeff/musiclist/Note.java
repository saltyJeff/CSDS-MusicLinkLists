package io.github.saltyJeff.musiclist;

public class Note {
	public char note;
	public char accidental;
	public int octave;
	public double duration;
	public Note next;
	public Note prev;
	
	public Note(char n, char a, int o, double d) {
		note = n;
		accidental = a;
		octave = o;
		duration = d;
	}
	private static int A4Halfsteps = 4 * 12 + 9;
	public double getPitch() {
		int halfSteps = octave * 12;
		switch(note) {
			case 'C':
				halfSteps += 0;
				break;
			case 'D':
				halfSteps += 2;
				break;
			case 'E':
				halfSteps += 4;
				break;
			case 'F':
				halfSteps += 5;
				break;
			case 'G':
				halfSteps += 7;
				break;
			case 'A':
				halfSteps += 9;
				break;
			case 'B':
				halfSteps += 11;
				break;
		}
		switch(accidental) {
			case '#':
				halfSteps += 1;
				break;
			case 'b':
				halfSteps -= 1;
				break;
		}
		System.out.println("Half steps to A4: "+ (halfSteps - A4Halfsteps));
		return Math.pow(2, (halfSteps - A4Halfsteps)/12.0) * 440; //C4 -> 261.63
	}
	public String toString() {
		return String.format("%c%c%d @ %.2fs\n", note, accidental, octave, duration);
	}
}