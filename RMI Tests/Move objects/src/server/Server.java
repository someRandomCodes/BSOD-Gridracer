package server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.util.ArrayList;

import chatInterface.ChatInterface;

public class Server extends UnicastRemoteObject implements ChatInterface {
    private static final long serialVersionUID = 1L;
    private ArrayList<ChatInterface> clientList;
 
    protected Server() throws RemoteException {
        clientList = new ArrayList<ChatInterface>();
    }

    public synchronized boolean checkClientCredintials(ChatInterface chatinterface,String clientname) throws RemoteException {
        boolean chkLog = true;  
        this.clientList.add(chatinterface);
        return chkLog;
    }
 
    public synchronized void broadcastPlayerPosition(char x, int i) throws RemoteException {
    	if (i == 0) {
    		clientList.get(1).sendPositionToClient(x);		
    	} else {
    		clientList.get(0).sendPositionToClient(x);		
    	}
    	System.out.println("Player position " + i +  " updated");
    }
 
    public static void main(String[] arg) throws RemoteException, MalformedURLException {
    	LocateRegistry.createRegistry(1099);
        Naming.rebind("//localhost/RMIServer", new Server());
    }

	public void sendMessageToClients(String message) throws RemoteException {}



	@Override
	public void sendPositionToClient(char x) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

 
}