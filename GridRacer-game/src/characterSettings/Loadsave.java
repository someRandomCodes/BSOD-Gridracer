package characterSettings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Loadsave {
	static File settings = new File("settings\\settings.txt");
	
	/*
	 * load the player name from file
	 * @return String playername
	 */
	public static String loadName() {
		try {
			Scanner scan = new Scanner(settings);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();	
				if (line.contains("playername:")) {
					scan.close();	
					return line.substring(line.indexOf(":")+1);
				} 
			}
			scan.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("No saved name found: Enter a name in Character Settings");
		return "player1";
	}
	
	/*
	 * load the score from file
	 * @return int score
	 */
	public static int loadScore() {
		try {
			Scanner scan = new Scanner(settings);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();	
				if (line.contains("score:")) {
					scan.close();	
					return Integer.parseInt(line.substring(line.indexOf(":")+1));
				} 
			}
			scan.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * load the chosen char from file
	 * @return char character
	 */
	public static char loadCharacter() {
		try {
			Scanner scan = new Scanner(settings);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();	
				if (line.contains("char:")) {
					scan.close();	
					return line.substring(line.indexOf(":")+1).charAt(0);
				} 
			}
			scan.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return '1';
	}
	
	/*
	 * save the player settings in file
	 */
	public static void savePlayer(String name, int score, char character) {
		try {
			settings.createNewFile();
			PrintWriter write = new PrintWriter(new FileWriter(settings));
			write.println("playername:" + name);
			write.println("score:" + score);
			write.println("char:" + character);
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
