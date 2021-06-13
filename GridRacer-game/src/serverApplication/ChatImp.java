package serverApplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatImp extends UnicastRemoteObject implements ChatInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6475519343166703452L;
	String msg = "";
	
    protected ChatImp() throws RemoteException {
		super();
	}

	@Override
	public String check() throws RemoteException {
		return msg;
	}

	@Override
	public void newMsg(String msg) throws RemoteException {
		this.msg += msg + "\n";
	}
}
