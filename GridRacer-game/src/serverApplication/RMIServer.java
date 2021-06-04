package serverApplication;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class RMIServer {
    public static void main(String[] arg) throws RemoteException{
    	ChatImp chatserver = new ChatImp();
    	GameImpl gameserver = new GameImpl();
    	
    	boolean bound = false;
    	Registry registry = LocateRegistry.getRegistry(1099);
    	for (int i = 0; ! bound && i < 2; i++) {
    		try {
    		registry.rebind("ChatSrv", chatserver);
    		registry.rebind("GameSrv", gameserver);
    		bound = true;
    		System.out.println("registered");
    		} catch (RemoteException e) {
    			registry = LocateRegistry.createRegistry(1099);
    			System.out.println(e);
    			System.out.println("wtf keine ahnung wieso das nicht geht");
    		}
    	}
    }
}