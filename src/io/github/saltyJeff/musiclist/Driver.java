package io.github.saltyJeff.musiclist;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to a music player with linklists");
		Sequence seq = new Sequence();
		seq.addFirstNote(new Note('C', ' ', 4, 0.3));
		seq.addFirstNote(new Note('C', ' ', 4, 0.3));
		seq.addFirstNote(new Note('C', ' ', 4, 0.3));
		seq.addAtIndex(new Note('D', '#', 4, 0.3), 1);
		while(true) {
			Scanner cmdParser = new Scanner(input.nextLine());
			String cmd = cmdParser.next();
			switch(cmd) {
				case "print":
					System.out.println(seq);
					break;
				case "add":
					String letterStr = cmdParser.next();
					char letter = 'A';
					char accidental = ' ';
					if(letterStr.length() > 1) {
						letter = letterStr.charAt(0);
						accidental = letterStr.charAt(1);
					}
					else {
						letter = letterStr.charAt(0);
						accidental = ' ';
					}
					int octave = cmdParser.nextInt();
					double duration = cmdParser.nextDouble();
					Note n = new Note(letter, accidental, octave, duration);
					if(cmdParser.hasNextInt()) {
						System.out.println("adding at index");
						seq.addAtIndex(n, cmdParser.nextInt());
					}
					else {
						seq.addLastNote(n);
					}
					System.out.println(n.toString());
					break;
			}
			cmdParser.close();
		}
	}
}
