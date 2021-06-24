package serverApplication;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * This class registered the object
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class RMIServer {
	
	/*
	 * Starts the "server" and registered the objects to the registry
	 */
    public static void main(String[] arg) throws RemoteException{
    	ChatImp chatserver = new ChatImp();
    	GameImpl gameserver = new GameImpl();
    	charstatImpl charstats = new charstatImpl();
    	
    	boolean bound = false;
    	Registry registry = LocateRegistry.getRegistry(1099);
    	for (int i = 0; ! bound && i < 2; i++) {
    		try {
    		registry.rebind("ChatSrv", chatserver);
    		registry.rebind("GameSrv", gameserver);
    		registry.rebind("CharStat", charstats);
    		bound = true;
    		System.out.println("registered");
    		} catch (RemoteException e) {
    			registry = LocateRegistry.createRegistry(1099);
    			System.out.println(e);
    		}
    	}
    }
}