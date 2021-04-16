package client;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.util.Scanner;

import chatInterface.ChatInterface;

public class Client extends UnicastRemoteObject implements ChatInterface , Runnable , KeyListener{
    private static final long serialVersionUID = 1L;
    private ChatInterface server;
    private String ClientName;
    boolean chkExit = true;
    boolean chkLog = false;
    private JLabel player1 = new JLabel();
    private JLabel player2 = new JLabel();
    private static int pID; 
    JTextArea tf_chat = new JTextArea(5, 30);
    JTextField tf_chat_input = new JTextField(30);
 
    protected Client(ChatInterface chatinterface,String clientname) throws RemoteException {
        this.server = chatinterface;
        this.ClientName = clientname;
        chkLog = server.checkClientCredintials(this,clientname);
    }
 
    public boolean checkClientCredintials(ChatInterface chatinterface ,String clientname) throws RemoteException {
        return true;
    }
    

    public void run(){
        if(chkLog) {
            JFrame startFrame = new JFrame();
            startFrame.setTitle("by B.S.O.D");
            startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startFrame.setSize(420,420);
            startFrame.setLayout(null);
            startFrame.addKeyListener(this);
            
            player1.setSize(50,50);
            player1.setLocation(185, 300);
            player1.setBackground(Color.RED);
            player1.setOpaque(true);
            
            player2.setSize(50,50);
            player2.setLocation(185, 20);
            player2.setBackground(Color.BLUE);
            player2.setOpaque(true);
            
            startFrame.add(player1);
            startFrame.add(player2);
            startFrame.setVisible(true);
		}
    }
    
    @Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'w':
			player1.setLocation(player1.getX(), player1.getY()-1);
			try {
				server.broadcastPlayerPosition('w', pID);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 'a':
			player1.setLocation(player1.getX()-1, player1.getY());
			try {
				server.broadcastPlayerPosition('a', pID);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 's':
			player1.setLocation(player1.getX(), player1.getY()+1);
			try {
				server.broadcastPlayerPosition('s', pID);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 'd':
			player1.setLocation(player1.getX()+1, player1.getY());
			try {
				server.broadcastPlayerPosition('d', pID);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}

    
    
    public static void startFrame() {
        JFrame startFrame = new JFrame();
        startFrame.setTitle("B.S.O.D");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setSize(420,320);

        JLabel jl_Welcome = new JLabel();
        jl_Welcome.setText("Welcome to");
        jl_Welcome.setForeground(Color.GRAY);
        jl_Welcome.setFont(new Font("MV Boli", Font.ITALIC,30));
        jl_Welcome.setVerticalTextPosition(JLabel.CENTER);
        jl_Welcome.setHorizontalTextPosition(JLabel.CENTER);

        JLabel jl_FancyChat = new JLabel();
        jl_FancyChat.setText("some Shit");
        jl_FancyChat.setForeground(Color.GRAY);
        jl_FancyChat.setFont(new Font("MV Boli", Font.BOLD,50));
        jl_FancyChat.setVerticalTextPosition(JLabel.CENTER);
        jl_FancyChat.setHorizontalTextPosition(JLabel.CENTER);
    
        JButton btn_Start = new JButton();
        btn_Start.setText("Enter");
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
    	pID = Integer.parseInt(JOptionPane.showInputDialog("Gib iD: "));
        ChatInterface chatinterface = (ChatInterface)Naming.lookup("//localhost/RMIServer");
        new Thread(new Client(chatinterface , clientName)).start();
    }
    
    
    public static void main(String[] args) {
		try {
			System.out.println(LocateRegistry.getRegistry());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	startFrame();
    }

	public void broadcastPlayerPosition(char x) throws RemoteException {}

	public void sendPositionToClient(char x) throws RemoteException {
		switch(x) {
		case 'w':
			player2.setLocation(player2.getX(), player2.getY()+1);
			break;
		case 'a':
			player2.setLocation(player2.getX()+1, player2.getY());
			break;
		case 's':
			player2.setLocation(player2.getX(), player2.getY()-1);
			break;
		case 'd':
			player2.setLocation(player2.getX()-1, player2.getY());
			break;
		}
	}

	@Override
	public void broadcastPlayerPosition(char x, int i) throws RemoteException {}
}