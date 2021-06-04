package multiplayer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.rmi.Naming;
import java.rmi.RemoteException;

import serverApplication.ChatInterface;
import startGame.MyFrame;

public class MultiplayerGame {

	/*
	 * Creates the "Game Window" and add all needed Panels to it
	 * The Chat area
	 * The Player stats area
	 * The Game itself
	 */
	public MultiplayerGame() throws RemoteException {
		//Panel_PlayerInfo playerStats = new Panel_PlayerInfo();
		Panel_TheGame game = new Panel_TheGame();
		MyFrame frame = new MyFrame(false);
		Container frameContent = frame.getContentPane();
		
		
		
		frame.setVisible(true);		
		frame.setSize(800,500);
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		//frameContent.add(playerStats, BorderLayout.NORTH);
		frameContent.add(game, BorderLayout.CENTER);
		try {
			Panel_Chat chat = new Panel_Chat();
			frameContent.add(chat, BorderLayout.EAST);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
