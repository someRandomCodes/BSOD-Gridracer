package serverApplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
	private ArrayList<chatmessage<String>> chathistory = new ArrayList<>();
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
		String msg = null;
		for (int i = 0; i < chathistory.size(); i++) {
			msg += chathistory.get(i).getMessage();
		}
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
		chathistory.add(new chatmessage<String>(msg + "\n"));
	}
}
