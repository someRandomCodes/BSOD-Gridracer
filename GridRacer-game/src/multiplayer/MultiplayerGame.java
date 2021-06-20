package multiplayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import serverApplication.RMIServer;
import settingMenue.Panel_Sounds;
import startGame.MyFrame;

/**
 * This class creates the Multiplayer Layout and contains
 * the chat, the game and the playerStats
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class MultiplayerGame {

	/*
	 * Creates the "Game Window" and add all needed Panels to it
	 * The Chat area
	 * The Player stats area
	 * The Game itself
	 */
	public MultiplayerGame() throws RemoteException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("type 1 for Server | 2 for Client | 3 for 2 on 1 pc"));
		
		if (id == 1 || id == 3) {
			new RMIServer();
		}
		if (Panel_Sounds.a == 2 ||Panel_Sounds.a == 3 ) {
			
		}else {
			Panel_Sounds.a = 3;
		}
			
		
		Panel_PlayerInfo playerStats = new Panel_PlayerInfo(id);
		Panel_TheGame game = new Panel_TheGame(id);		
		MyFrame frame = new MyFrame(false);
		Container frameContent = frame.getContentPane();

		frameContent.setBackground(Color.BLACK);
		frameContent.setLayout(new BorderLayout());
		
		frame.setVisible(true);		
		frame.setSize(1200,800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			
			/*
			 *opens JOptionPane with yes or no options
			 *turns menu music on and game music off 
			 */
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frame, 
		            "Are you sure you want to quit the game?", "Quit game?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	if (Panel_Sounds.a==1 || Panel_Sounds.a == 2) {
		        		
		        	}else {
		        		Panel_Sounds.a = 1;
		        	}
		        	
		        }
		    }
		});
		

		if (id != 3) {
			frameContent.add(playerStats, BorderLayout.NORTH);
			try {
				Panel_Chat chat = new Panel_Chat();
				frameContent.add(chat, BorderLayout.EAST);
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		
		frameContent.add(game, BorderLayout.CENTER);
		game.requestFocus();
	}
}
