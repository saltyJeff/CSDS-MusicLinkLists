package io.github.saltyJeff.musiclist;
import java.util.Scanner;

import io.github.saltyJeff.musiclist.songs.HotCrossBuns;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to a music editor with linklists");
		System.out.println("Enter your commands:");
		Sequence seq = HotCrossBuns.getSong();
		while(true) {
			Scanner cmdParser = new Scanner(input.nextLine());
			String cmd = cmdParser.next();
			switch(cmd) {
				case "exit":
					System.out.println("Goodbye");
					input.close();
					cmdParser.close();
					return;
				case "help":
					System.out.println(getHelp());
					break;
				case "print":
					System.out.println(seq);
					break;
				case "play":
					System.out.println("Playing sequence");
					seq.play();
					System.out.println("Done playing");
					break;
				case "clear":
					seq.clear();
					System.out.println("Sequence cleared");
					break;
				case "remove":
					System.out.print("Removed note: ");
					System.out.print(seq.removeAtIndex(cmdParser.nextInt()));
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
						seq.addAtIndex(n, cmdParser.nextInt());
					}
					else {
						seq.addLastNote(n);
					}
					System.out.println(n.toString());
					break;
				default:
					System.out.println("Unknown command, enter \"help\" for help");
					break;
			}
			cmdParser.close();
		}
	}
	public static String getHelp() {
		String help = "Help:\n";
		help += "print:\tprint the current sequence\n";
		help += "add <note> <octave> <duration> [index]:\tadd a new <note> at <octave> for <duration> as the last note. Optional: add it at [index]\n";
		help += "play:\tplay your sequence\n";
		help += "exit:\texit the program\n";
		help += "help:\tprint this help screen\n";
		return help;
	}
}
