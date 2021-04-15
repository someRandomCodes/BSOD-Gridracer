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
 
    public synchronized void broadcastMessage(String clientname , String message) throws RemoteException {
        for(int i=0; i<clientList.size(); i++) {
            clientList.get(i).sendMessageToClient(clientname.toUpperCase() + " : "+ message);
            clientList.get(i).sendMessageToClients(message);
        }
    }
 
    public synchronized void sendMessageToClient(String message) throws RemoteException{}

    public static void main(String[] arg) throws RemoteException, MalformedURLException {
    	LocateRegistry.createRegistry(1099);
        Naming.rebind("//localhost/RMIServer", new Server());
    }

	public void sendMessageToClients(String message) throws RemoteException {}
 
}