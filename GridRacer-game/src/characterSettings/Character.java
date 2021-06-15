package characterSettings;

/**
 * Klassen beschreibung
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Character {
	private String name;
	private int score;
	private char character;
	
	/*
	 * Creates the player/character
	 * @param name needs the player name
	 * @param score needs the score
	 * @param character needs the Character
	 */
	Character(String name, int score, char character) {
		this.name = name;
		this.character = character;
		this.score = score;
	}
	
	/*
	 * Change the player name
	 * @param name set the new player name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Change the Score
	 * @param score set the new player score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/*
	 * Change the chosen Character
	 * @param character set the chosen character
	 */
	public void setCharacter(char character) {
		this.character = character;
	}
	
	/*
	 * Get the Player Name
	 * @return name return the player name
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Get the Player Score
	 * @return score return the player score
	 */
	public int getScore() {
		return this.score;
	}
	
	/*
	 * Get the Player Character
	 * @return character return the player chosen character
	 */
	public char getCharacter() {
		return this.character;
	}
	
	
}
