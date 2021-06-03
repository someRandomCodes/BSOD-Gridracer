package multiplayer;

import java.rmi.*;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import characterSettings.Loadsave;
import serverApplication.ChatInterface;

import java.net.MalformedURLException;


public class Panel_Chat extends JPanel implements Runnable {
	ChatInterface server;

	/**
	 * 
	 */
	private static final long serialVersionUID = -8774910327306990507L;

	public Panel_Chat() throws MalformedURLException,RemoteException,NotBoundException {
		try {
	        ChatInterface chatinterface = (ChatInterface)Naming.lookup("rmi://localhost:1099/ChatObj");		
	        new Thread(new Panel_Chat(chatinterface)).start();
	        
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
    public Panel_Chat(ChatInterface chatinterface) {
    	this.server = chatinterface;
        try {
			if(chatinterface.checkIn(chatinterface, Loadsave.loadName())) System.out.println("Connected");
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public void sendMessageToClient(String message) throws RemoteException {
		JOptionPane.showMessageDialog(null, message);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
