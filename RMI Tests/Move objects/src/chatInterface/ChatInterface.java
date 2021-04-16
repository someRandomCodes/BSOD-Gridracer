package chatInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote { 
	public boolean checkClientCredintials(ChatInterface chatinterface,String clientname) throws RemoteException;
    void broadcastPlayerPosition(char x, int i) throws RemoteException;
    void sendPositionToClient(char x) throws RemoteException;
}