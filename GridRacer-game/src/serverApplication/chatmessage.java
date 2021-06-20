package serverApplication;

/**
 * this class is a generic class to save
 * the chathistory
 * 
 * @author Thomas Guede Stork
 * @author Lukas Mohrbachen
 * @author Islyam Makanalin
 * 
 */
public class chatmessage <message> {
	private message m;
	
	/*
	 * Constructor who sets the message
	 * to the param
	 * 
	 * @param message m
	 */
	chatmessage(message m) {
		this.m = m;
	}

	/*
	 * returns the message 
	 * 
	 * @return message
	 */
	public message getMessage() {
		return m;
	}
}
