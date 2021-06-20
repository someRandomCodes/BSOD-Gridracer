package multiplayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import characterSettings.Loadsave;
import serverApplication.charstatInterface;

/**
 * This class connects to the server and load the character name
 * and character picture from enemy.
 * 
 * And uploaded the own character name and Picture.
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_PlayerInfo extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5379169326559611440L;
	private charstatInterface server;
	
	private JPanel playerOne = new JPanel();
	private JPanel playerTwo = new JPanel();
	private JLabel playerOneName = new JLabel("Player1");
	private JLabel playerTwoName = new JLabel("Player2");
	private JLabel playerOnePicture = new JLabel();
	private JLabel playerTwoPicture = new JLabel();
	private char character1 = 'N';
	private char character2 = 'N';
	
	/*
	 * Creates the Character stats Panel and contains
	 * the enemy Picture and name and also the own name and Picture
	 * 
	 * @param int to set the Player self as an Host or an Client 
	 * 
	 * (1 to Host | 2 to Client | 3 for Host but on 1 PC)
	 * 3 also activates the second key Listener (i j k l to navigate)
	 */
	Panel_PlayerInfo(int id) {
		try {
			charstatInterface charstatinterface = (charstatInterface)Naming.lookup("rmi://" + Loadsave.loadServerAdress() + "/CharStat");	
	        server = charstatinterface;
	        
		} catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			server.setPlayerName(id, Loadsave.loadName());
			server.setPlayerPic(id, Loadsave.loadCharacter());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		this.setPreferredSize(new Dimension(250,100));
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		
		playerOne.setLayout(new FlowLayout());
		playerOne.setSize(new Dimension(250,300));
		playerOne.setOpaque(false);
		playerOne.add(playerOneName);
		playerOne.add(playerOnePicture);
		
		playerTwo.setLayout(new FlowLayout());
		playerTwo.setOpaque(false);
		playerTwo.setSize(new Dimension(300,300));
		playerTwo.add(playerTwoName);
		playerTwo.add(playerTwoPicture);
		
		this.add(playerOne, BorderLayout.WEST);
		this.add(playerTwo, BorderLayout.EAST);		
		this.setVisible(true);
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if (id == 1) {
					try {
						character1 = server.getPlayerPic(1);
						character2 = server.getPlayerPic(2);
						playerOneName.setText(server.getPlayerName(1));
						playerTwoName.setText(server.getPlayerName(2));
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				} else {
					try {
						character1 = server.getPlayerPic(2);
						character2 = server.getPlayerPic(1);
						playerOneName.setText(server.getPlayerName(2));
						playerTwoName.setText(server.getPlayerName(1));
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				if (character1 != 'N' && character2 != 'N') {
					playerOnePicture.setIcon(new ImageIcon(playerImage(character1)));
					playerOnePicture.setOpaque(true);
					
					playerTwoPicture.setIcon(new ImageIcon(playerImage(character2)));
					playerTwoPicture.setOpaque(true);
					timer.cancel(); 
					timer.purge();
				}
			}
		}, 2000, 2000);
	}
	
	/*
	 * Returns the String to the Character Picture
	 * by an passed char.
	 * 
	 * @param char an char to returns the Path to an Picture
	 * @return the Path as an String to an Picture
	 */
	private String playerImage(char pic) {
		if (pic == '1') {
			return "src\\assets\\img\\gamechar1.png";
		} else if (pic == '2') {
			return "src\\assets\\img\\gamechar2.png";
		} else if (pic == '3') {
			return "src\\assets\\img\\gamechar3.png";
		} else {
			return "src\\assets\\img\\secretChar.png";
		}
	}
}
