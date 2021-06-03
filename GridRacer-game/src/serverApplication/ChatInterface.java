package serverApplication;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
	
    boolean checkIn(ChatInterface ci, String name) throws RemoteException;
    
    void broadcastMessage(String name, String message) throws RemoteException;
    
    void sendMessageToClient(String message) throws RemoteException;

}