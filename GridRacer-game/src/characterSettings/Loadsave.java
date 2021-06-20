package characterSettings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * this class is to used to save into txt files and load from them
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Loadsave {
	private static File settings = new File(".\\settings\\settings.txt");
	private static File clientSettings = new File(".\\settings\\clientsettings.txt");
	private static char[] alphabet = 
			{ 'a', 'b', 'c','d',
			'e','f','g','h','i','j','k','l',
			'm','n','o','p','q','r','s','t',
			'u','v','w','x','y','z','0','1',
			'2','3','4','5','6','7','8','9',
			'A','B','C','D','E','F','G','H',
			'I','J','K','L','M','N','O','P',
			'Q','R','S','T','U','V','W','X',
			'Y','Z'};
	
	/*
	 * load the player name from file
	 * @return String Player name
	 */
	public static String loadName() {
		try {
			Scanner scan = new Scanner(settings);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();	
				if (line.contains("playername:")) {
					scan.close();	
					return decode(line.substring(line.indexOf(":")+1));
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
					return Integer.parseInt(decode(line.substring(line.indexOf(":")+1)));
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
					return decode(line.substring(line.indexOf(":")+1)).charAt(0);
				} 
			}
			scan.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return '1';
	}
	
	/*
	 * load static if game has rated
	 * @return boolean gamerated
	 */
	public static boolean loadGamerated() {
		try {
			Scanner scan = new Scanner(settings);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();	
				if (line.contains("rated:")) {
					scan.close();	
					return (line.substring(line.indexOf(":")+1) == "true") ? true : false;
				} 
			}
			scan.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * save the player settings in file
	 */
	public static void savePlayer(String name, int score, char character, boolean rated) {
		try {
			settings.createNewFile();
			PrintWriter write = new PrintWriter(new FileWriter(settings));
			write.println("playername:" + encode(name));
			write.println("score:" + encode(Integer.toString(score)));
			write.println("char:" + encode(String.valueOf(character)));
			if (rated) {
				write.println("rated:true");
			} else {
				write.println("rated:" + loadGamerated());
			}
			write.flush();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Encode the string with cesar chiffre(modded)
	 */
	private static String encode(String toDecode) {
		char[] chars = toDecode.toCharArray();
		String encoded = "";
		
		for (int k = 0; k < chars.length; k++) {
			for (int i = 0; i < 62 ;i++) {
				if (chars[k] == alphabet[i]) encoded += alphabet[(i + 4) % 62];
			}
		}	
		return encoded;
	}
	
	/*
	 * Decode the string with cesar chiffre(modded)
	 */
	private static String decode(String toEncode) {
		char[] chars = toEncode.toCharArray();
		String decoded = "";
		
		for (int k = 0; k < chars.length; k++) {
			for (int i = 0; i < 62 ;i++) {
				if (chars[k] == alphabet[i]) decoded += alphabet[Math.abs((i - 4) % 62)];
			}
		}	
		return decoded;
	}
	
	/*
	 * Save the ip adress and port number to 
	 * clientsetting.txt
	 * 
	 * @param String port address
	 * @param String ip adress
	 */
	public static void saveClientSettings(String ip, String port) {
		try {
			FileOutputStream fos = new FileOutputStream(clientSettings);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			writer.write(ip + ":" + port);
			writer.flush();
			writer.close();
			JOptionPane.showInternalMessageDialog(null, "Adresse und Port wurde gespeichert");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * load ip adress and port number from
	 * clientsetting.txt
	 * 
	 * @return String  Serveradress and port
	 */
	public static String loadServerAdress() {
		try {
			String address;
			Scanner scan = new Scanner(clientSettings);
			address = scan.next();
			scan.close();	
			return address;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("No saved name found: Enter a name in Character Settings");
		return "player1";
	}
}
