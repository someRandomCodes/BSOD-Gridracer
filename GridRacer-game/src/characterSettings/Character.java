package characterSettings;

public class Character {
	private String name;
	private int score;
	private char character;
	
	Character(String name, int score, char character) {
		this.name = name;
		this.character = character;
		this.score = score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setCharacter(char character) {
		this.character = character;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public char getCharacter() {
		return this.character;
	}
	
	
}
