package serverApplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This class is for the Player stats on Server side
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class charstatImpl extends UnicastRemoteObject implements charstatInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3792463173990657167L;
	String playerHost = "Hostplayer";
	String playerClient = "Clientplayer";
	char playerHostPic = 'N';
	char playerClientPic = 'N';

	protected charstatImpl() throws RemoteException {
		super();
	}

	/*
	 * This Method returns the Character Picture of an player
	 * for Host and Client
	 * 
	 * @param int (1 Host | 2 Client)
	 * @return char 
	 * the char to get the Player Picture
	 */
	@Override
	public char getPlayerPic(int id) throws RemoteException {
		return (id == 1) ? playerHostPic : playerClientPic;
	}
	
	/*
	 * This Method returns the Character Name of an player
	 * for Host and Client
	 * 
	 * @param int (1 Host | 2 Client)
	 * @return String 
	 * the char to get the Player Picture
	 */
	@Override
	public String getPlayerName(int id) throws RemoteException {
		return (id == 1) ? playerHost : playerClient;
	}

	/*
	 * This Method set the Character Picture for Host an Client
	 * 
	 * @param int (1 Host | 2 Client)
	 * @param char 
	 * the char to set the Player Picture
	 */
	@Override
	public void setPlayerPic(int id, char c) throws RemoteException {
		if (id == 1) {
			playerHostPic = c;
		} else {
			playerClientPic = c;
		}
	}

	/*
	 * This Method set the Character Name for Host an Client
	 * 
	 * @param int (1 Host | 2 Client)
	 * @param String 
	 * the String to set the Player Name
	 */
	@Override
	public void setPlayerName(int id, String s) throws RemoteException {
		if (id == 1) {
			playerHost = s;
		} else {
			playerClient = s;
		}
	}
	

}
