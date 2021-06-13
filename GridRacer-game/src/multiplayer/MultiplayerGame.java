package multiplayer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import serverApplication.ChatInterface;
import serverApplication.RMIServer;
import startGame.MyFrame;

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
		Panel_PlayerInfo playerStats = new Panel_PlayerInfo(id);
		Panel_TheGame game = new Panel_TheGame(id);		
		MyFrame frame = new MyFrame(false);
		Container frameContent = frame.getContentPane();
		
		frame.setVisible(true);		
		frame.setSize(800,800);
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		
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
	}
}
