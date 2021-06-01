package multiplayer;

import java.awt.BorderLayout;
import java.awt.Container;

import startGame.MyFrame;

public class MultiplayerGame {

	/*
	 * Creates the "Game Window" and add all needed Panels to it
	 * The Chat area
	 * The Player stats area
	 * The Game itself
	 */
	public MultiplayerGame() {
		Panel_Chat chat = new Panel_Chat();
		Panel_PlayerInfo playerStats = new Panel_PlayerInfo();
		Panel_TheGame game = new Panel_TheGame();
		MyFrame frame = new MyFrame(false);
		Container frameContent = frame.getContentPane();
		
		
		frame.setVisible(true);		
		frame.setSize(600,500);
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		//frameContent.add(playerStats, BorderLayout.NORTH);
		frameContent.add(game, BorderLayout.CENTER);
		//frameContent.add(chat, BorderLayout.EAST);
	}
}
