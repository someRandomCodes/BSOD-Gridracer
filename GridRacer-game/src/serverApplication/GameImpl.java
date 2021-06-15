package serverApplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Klassen beschreibung
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class GameImpl extends UnicastRemoteObject implements GameInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3636360585915455313L;
	char hostIdMoveDirection = ' ';
	char clientIdMoveDirection = ' ';

	protected GameImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkIn(GameInterface ci, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void isCollide(int id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ChangeDirection(int id, char d) throws RemoteException {
		if (id == 1) hostIdMoveDirection = d;
		if (id == 2) clientIdMoveDirection = d;
	}

	@Override
	public char getDirection(int id) throws RemoteException {
		if (id == 1) return hostIdMoveDirection;
		return clientIdMoveDirection;
	}

	@Override
	public boolean playerRdy() throws RemoteException {
		if (hostIdMoveDirection != ' ' && clientIdMoveDirection != ' ') return true;
		return false;
	}

	@Override
	public void resetGame() throws RemoteException {
		hostIdMoveDirection = ' ';
		clientIdMoveDirection = ' ';
	}
	
}
