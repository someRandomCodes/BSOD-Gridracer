package serverApplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This class is for the Game Logic on Server Side
 * 
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

	/*
	 *This Method changes the Moving direction of an player
	 *by setting a other value to an variable
	 *
	 * @param int  which one player changes the direction
	 * @param char for the direction
	 */
	@Override
	public void ChangeDirection(int id, char d) throws RemoteException {
		if (id == 1) hostIdMoveDirection = d;
		if (id == 2) clientIdMoveDirection = d;
	}

	/*
	 *This Method changes the Moving direction of an player
	 *by setting a other value to an variable
	 *
	 * @param int  which one player 
	 * @return returns the direction
	 */
	@Override
	public char getDirection(int id) throws RemoteException {
		if (id == 1) return hostIdMoveDirection;
		return clientIdMoveDirection;
	}

	/*
	 *This Method checks if all player chose an direction to start
	 *
	 * @return boolean all players ready
	 */
	@Override
	public boolean playerRdy() throws RemoteException {
		if (hostIdMoveDirection != ' ' && clientIdMoveDirection != ' ') return true;
		return false;
	}

	/*
	 *This Method resets the directions to nothing
	 */
	@Override
	public void resetGame() throws RemoteException {
		hostIdMoveDirection = ' ';
		clientIdMoveDirection = ' ';
	}
	
}
