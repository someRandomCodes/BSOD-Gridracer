package serverApplication;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface charstatInterface extends Remote {
	char getPlayerPic(int id) throws RemoteException;
	String getPlayerName(int id) throws RemoteException;
	void setPlayerPic(int id, char c) throws RemoteException;
	void setPlayerName(int id, String s) throws RemoteException;
}
