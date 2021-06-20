package multiplayer;

import java.rmi.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import characterSettings.Loadsave;
import serverApplication.ChatInterface;

import java.net.MalformedURLException;


/**
 * This class creates the server connection to the
 * chatinterface and contains chatelements
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_Chat extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8774910327306990507L;
	private ChatInterface server;
	private JTextField tf_sendChatText = new JTextField(5);
	private JTextArea ep_chatFrame = new JTextArea();
	private JButton btn_send = new JButton("send Msg");

	/*
	 * This Constructor for the Chat Panel who contains the Chat Text
	 * the text to send
	 * and the button 
	 */
	public Panel_Chat() throws MalformedURLException,RemoteException,NotBoundException {	
		Font font = new Font("Apple Casual", Font.ITALIC|Font.BOLD, 20);
		Font fontchat = new Font("Apple Casual", 14, 20);
		this.setPreferredSize(new Dimension(300,500));
		this.setLayout(new GridLayout(3,1));
		this.setOpaque(false);

		ep_chatFrame.setText("test");
		ep_chatFrame.setBackground(new Color(0x2b2b2b));
		ep_chatFrame.setForeground(Color.white);
		ep_chatFrame.setFont(fontchat);
		
		btn_send.setFocusable(false);
		btn_send.addActionListener(e -> sendMsg());
		btn_send.setBackground(Color.black);
		btn_send.setFont(font);
		btn_send.setForeground(Color.white);
		
		this.add(ep_chatFrame);
		this.add(tf_sendChatText);
		this.add(btn_send);	
		
		//Connect to server
		try {
	        ChatInterface chatinterface = (ChatInterface)Naming.lookup("rmi://" + Loadsave.loadServerAdress() + "/ChatSrv");	
	        server = chatinterface;
	        
		} catch(Exception e) {
			System.out.println(e);
		}
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			/*
			 * get the message from server
			 */
			public void run() {
				try {
					ep_chatFrame.setText(server.check());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}, 2000, 2000);
	}
	
	/*
	 * This Method send the Message to the Server
	 */
	void sendMsg() {
		try {
			server.newMsg(Loadsave.loadName() + ": " + this.tf_sendChatText.getText());
			this.tf_sendChatText.setText("");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
