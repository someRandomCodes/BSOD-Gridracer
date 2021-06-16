package serverApplication;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface GameInterface extends Remote {
	
	void ChangeDirection(int id, char d) throws RemoteException;
	char getDirection(int id) throws RemoteException;
	boolean playerRdy() throws RemoteException;
	void resetGame() throws RemoteException;
}
