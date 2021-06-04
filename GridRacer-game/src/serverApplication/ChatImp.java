package serverApplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatImp extends UnicastRemoteObject implements ChatInterface {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6475519343166703452L;
	private ArrayList<ChatInterface> clientList;
	String msg = "";

	protected ChatImp() throws RemoteException {
        clientList = new ArrayList<ChatInterface>();
	}
 
    public void broadcastMessage(String clientname , String message) throws RemoteException {
        for(int i=0; i<clientList.size(); i++) {
            clientList.get(i).sendMessageToClient(clientname.toUpperCase() + " : "+ message);
        }
    }
 
    public synchronized void sendMessageToClient(String message) throws RemoteException{}

	@Override
	public boolean checkConnection(ChatInterface ci, String name) throws RemoteException {
        this.clientList.add(ci);
		return false;
	}

	@Override
	public String check() throws RemoteException {
		// TODO Auto-generated method stub
		return msg;
	}

	@Override
	public void newMsg(String msg) throws RemoteException {
		this.msg = msg;
		
	}
}
