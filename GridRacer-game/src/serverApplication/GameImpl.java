package serverApplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GameImpl extends UnicastRemoteObject implements GameInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3636360585915455313L;
	char AliceIdMoveDirection = ' ';
	char BobIdMoveDirection = ' ';

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
		if (id == 1) AliceIdMoveDirection = d;
		if (id == 2) BobIdMoveDirection = d;
	}

	@Override
	public char getDirection(int id) throws RemoteException {
		if (id == 1) return BobIdMoveDirection;
		return AliceIdMoveDirection;
	}
	
}
