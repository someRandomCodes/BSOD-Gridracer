package serverApplication;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameInterface extends Remote {
	boolean checkIn(GameInterface ci, String name) throws RemoteException;
	
	void ChangeDirection(int id, char d) throws RemoteException;
	
	char getDirection(int id) throws RemoteException;
	
	void isCollide(int id) throws RemoteException;
	
	boolean playerRdy() throws RemoteException;
}
