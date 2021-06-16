package serverApplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This class is for Chat Logic on Server Side
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class ChatImp extends UnicastRemoteObject implements ChatInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6475519343166703452L;
	String msg = "";
	
    protected ChatImp() throws RemoteException {
		super();
	}

    /*
     * This Method returns the messages
     * 
     * @return String the messages for the Chat
     */
	@Override
	public String check() throws RemoteException {
		return msg;
	}
	
    /*
     * This Method add the messages to the message
     * 
     * @param String 
     * the messages to add
     */
	@Override
	public void newMsg(String msg) throws RemoteException {
		this.msg += msg + "\n";
	}
}
