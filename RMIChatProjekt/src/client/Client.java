package client;

import java.rmi.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.util.Scanner;

import chatInterface.ChatInterface;

public class Client extends UnicastRemoteObject implements ChatInterface , Runnable {
    private static final long serialVersionUID = 1L;
    private ChatInterface server;
    private String ClientName;
    boolean chkExit = true;
    boolean chkLog = false;
    JTextArea tf_chat = new JTextArea(5, 30);
    JTextField tf_chat_input = new JTextField(30);
 
    protected Client(ChatInterface chatinterface,String clientname) throws RemoteException {
        this.server = chatinterface;
        this.ClientName = clientname;
        chkLog = server.checkClientCredintials(this,clientname);
    }

    public void sendMessageToClient(String message) throws RemoteException {
        tf_chat.setText(message + "\n" + tf_chat.getText());
    }
    public void sendMessageToClients(String message) throws RemoteException {
        System.out.println("Updated Messages"); 
    }
 
    public void broadcastMessage(String clientname,String message) throws RemoteException {}
 
    public boolean checkClientCredintials(ChatInterface chatinterface ,String clientname) throws RemoteException {
        return true;
    }
    

    public void run() {
        if(chkLog) {           
            JFrame chatFrame = new JFrame();
            chatFrame.setTitle("Welcome to ChatService by B.S.O.D");
            chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            chatFrame.setSize(390,320);
            
            tf_chat_input.setText("Enter msg here");

            
            JButton btn_Send = new JButton();
            btn_Send.setText("Send Msg");
            btn_Send.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					String message = tf_chat_input.getText();
					try {
						server.broadcastMessage(ClientName, message);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tf_chat_input.setText("");
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub	
				}
            	
            });

            JPanel jp_background = new JPanel();
            jp_background.setBackground(new Color(0x00008B));
            jp_background.setBounds(0,0,390,320);
            jp_background.add(new JScrollPane(tf_chat));
            jp_background.add(tf_chat_input);
            jp_background.add(btn_Send);
            
            chatFrame.add(jp_background);
            chatFrame.setVisible(true);
            tf_chat.setWrapStyleWord(true);
            tf_chat.setLineWrap(true);
            tf_chat.setText(tf_chat.getText() + "Successfully Connected To RMI Server" + "\n");
            tf_chat.setText(tf_chat.getText() + "NOTE : Type LOGOUT to Exit From The Service" + "\n");
            tf_chat.setText(tf_chat.getText() + "Now Your Online To Chat\\n" + "\n");
        }
        else {
            JOptionPane.showMessageDialog(null, "Shit happens ?");
        }  
    }
    
    
    public static void startFrame() {
        JFrame startFrame = new JFrame();
        startFrame.setTitle("Welcome to ChatService by B.S.O.D");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setSize(420,320);

        JLabel jl_Welcome = new JLabel();
        jl_Welcome.setText("Welcome to");
        jl_Welcome.setForeground(Color.GRAY);
        jl_Welcome.setFont(new Font("MV Boli", Font.ITALIC,30));
        jl_Welcome.setVerticalTextPosition(JLabel.CENTER);
        jl_Welcome.setHorizontalTextPosition(JLabel.CENTER);

        JLabel jl_FancyChat = new JLabel();
        jl_FancyChat.setText("The Fancy Chat");
        jl_FancyChat.setForeground(Color.GRAY);
        jl_FancyChat.setFont(new Font("MV Boli", Font.BOLD,50));
        jl_FancyChat.setVerticalTextPosition(JLabel.CENTER);
        jl_FancyChat.setHorizontalTextPosition(JLabel.CENTER);
    
        JButton btn_Start = new JButton();
        btn_Start.setText("Enter Chat");
        btn_Start.setSize(250, 40);
        btn_Start.addActionListener(e -> {
			try {
				startChat();
				startFrame.setVisible(false);
			} catch (MalformedURLException | RemoteException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

        JPanel jp_background = new JPanel();
        jp_background.setBackground(new Color(0x00008B));
        jp_background.setBounds(0,0,420,420);
        jp_background.add(jl_Welcome);
        jp_background.add(jl_FancyChat);
        jp_background.add((btn_Start));
        
        startFrame.add(jp_background);
        startFrame.setVisible(true);
    }
    
    public static void startChat()throws MalformedURLException,RemoteException,NotBoundException {
    	String clientName = JOptionPane.showInputDialog("Gib Name: ");
        ChatInterface chatinterface = (ChatInterface)Naming.lookup("//localhost/RMIServer");
        new Thread(new Client(chatinterface , clientName)).start();
    }
    
    
    public static void main(String[] args) {
    	startFrame();
    }
 
}