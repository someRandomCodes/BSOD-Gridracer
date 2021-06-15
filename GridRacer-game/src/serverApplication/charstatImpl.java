package serverApplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Klassen beschreibung
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class charstatImpl extends UnicastRemoteObject implements charstatInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3792463173990657167L;
	String playerHost = "Servertest";
	String playerClient = "TestServer";
	char playerHostPic = 'N';
	char playerClientPic = 'N';

	protected charstatImpl() throws RemoteException {
		super();
	}

	@Override
	public char getPlayerPic(int id) throws RemoteException {
		return (id == 1) ? playerHostPic : playerClientPic;
	}

	@Override
	public String getPlayerName(int id) throws RemoteException {
		return (id == 1) ? playerHost : playerClient;
	}

	@Override
	public void setPlayerPic(int id, char c) throws RemoteException {
		if (id == 1) {
			playerHostPic = c;
		} else {
			playerClientPic = c;
		}
	}

	@Override
	public void setPlayerName(int id, String s) throws RemoteException {
		if (id == 1) {
			playerHost = s;
		} else {
			playerClient = s;
		}
	}
	

}
