package multiplayer;

import java.rmi.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import serverApplication.ChatInterface;

import java.net.MalformedURLException;


public class Panel_Chat extends JPanel {
	ChatInterface server;
	JTextField tf_sendChatText = new JTextField(5);
	JEditorPane ep_chatFrame = new JEditorPane();
	JButton btn_send = new JButton("send Msg");

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8774910327306990507L;

	public Panel_Chat() throws MalformedURLException,RemoteException,NotBoundException {	
		this.setPreferredSize(new Dimension(300,500));
		this.setLayout(new GridLayout(4,1));
		
		this.add(ep_chatFrame);
		this.add(tf_sendChatText);
		ep_chatFrame.setText("test");
		this.add(btn_send);
		
		btn_send.addActionListener(e -> sendMsg());
		
		try {
	        ChatInterface chatinterface = (ChatInterface)Naming.lookup("rmi://localhost:1099/ChatSrv");	
	        server = chatinterface;
	        
		} catch(Exception e) {
			System.out.println(e);
		}
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				try {
					ep_chatFrame.setText("<p> " + server.check());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 2000, 2000);
	}
	
	void loadMsg() {
		try {
			this.ep_chatFrame.setText("<p> " + server.check());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void sendMsg() {
		try {
			server.newMsg(this.tf_sendChatText.getText());
			this.tf_sendChatText.setText("");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
