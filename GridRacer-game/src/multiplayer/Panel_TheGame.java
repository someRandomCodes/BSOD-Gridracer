package multiplayer;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import serverApplication.GameInterface;

/**
 * This class contains the Game itself with Server connection and Colide logic
 * 
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_TheGame extends JPanel {
	GameInterface server;
	private int speed = 100;
	private int gameboardSizeW = 80;
	private int gameboardSizeH = 60;
	private int gameboardSize = gameboardSizeH * gameboardSizeW;
	private boolean gamerun = false;
	private gamestart gameStart = new gamestart();
	private movings movingSelfThread = new movings();
	private enemy enemyMovingThread = new enemy();
	private Gameplace[] place = new Gameplace[gameboardSize];
	private int id;
	private int enemyId;
	private int playerId;
	private int enemypos; //81 
	private int playerPos1; // 4718 start position normal

	/**
	 * 
	 */
	private static final long serialVersionUID = 5438164405065722657L;

	/*
	 * The Game Constructor connects to the Server and load the player positions 
	 * from there.
	 * The "Game board" is an GridLayout and all places are JLabels 
	 * 
	 * @param int 
	 * the Integer id is used to set the player to Host or to Client (or to 2player on 2 PC)
	 */
	Panel_TheGame(int id) {
		this.id = id;
		// id 1 for Server id 2 for client id 3 for 2 on 1 Computer.
		this.playerId = (id == 1 || id == 3) ? 1 : 2;
		this.enemyId = (id == 2) ? 1 : 2;
		System.out.println(playerId);
		System.out.println(enemyId);
		try {
			GameInterface gameinterface = (GameInterface)Naming.lookup("rmi://localhost:1099/GameSrv");	
			server = gameinterface;   
		} catch(Exception e) {
			System.out.println(e);
		}	
		this.setOpaque(false);
		this.setLayout(new GridLayout(gameboardSizeH, gameboardSizeW));
		this.setFocusable(true);
		this.addKeyListener(new MovingListener());
		
		for (int i = 0; i < gameboardSize ;i++) {
			place[i] = new Gameplace();
			this.add(place[i]);	
		}
		
		drawGamefield();
		gameStart.start();
	}
	
	/*
	 * This Method sets the Background from the game places 
	 */
	void drawGamefield(){
		this.enemypos = 81; //81 
		this.playerPos1 = 4718;		

		for (int i = 0; i < gameboardSize ;i++) {
			place[i].resetField();	
		}
		
		// top border
		for (int i = 0; i<gameboardSizeW ; i++) {
			place[i].drawBorder();
		}
		
		// bottom border
		for (int i = gameboardSize-1; i >= gameboardSize-gameboardSizeW ; i--) {
			place[i].drawBorder();
		}
		
		// left border
		for (int i = gameboardSizeW ; i < gameboardSize; i += gameboardSizeW) {
			place[i].drawBorder();
		}
		
		// right border
		for (int i = (gameboardSizeW * 2) -1  ; i < gameboardSize; i += gameboardSizeW) {
			place[i].drawBorder();
		}	
	}

	/*
	 * This Method is invoke when an player Collide to another player 
	 * or Collide to the Border
	 */
	void collide(int id) {
		JOptionPane.showMessageDialog(null, "colide from " + id );
		try {
			server.resetGame();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		drawGamefield();
	}
	
	/**
	 * This Class is to check if the 2 Players are Ready
	 * 
	 */
	private class gamestart extends Thread {
		public void run() {
		while (!gamerun) {
			try {
				gamerun = server.playerRdy();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if (gamerun) {
				movingSelfThread.start();
				enemyMovingThread.start();
				gameStart.interrupt();
			}
			}	
		}
	}
	
	/**
	 * This class draws the enemy-line to the Game board
	 */
	private class enemy extends Thread {
		public void run() {
			place[enemypos].drawEnemy();
			while(gamerun) {
				try {
					Thread.sleep(speed);
					try {
						switch(server.getDirection(enemyId)) {
						case 'w':
							enemypos += gameboardSizeW;
							if(place[enemypos].getBackground() != place[enemypos].getCheckColor()) {
								collide(enemyId);
							}
						    place[enemypos].drawEnemy();
							break;
						case 'd':
							enemypos -= 1;
							if(place[enemypos].getBackground() != place[enemypos].getCheckColor()) {
								collide(enemyId);
							}
						    place[enemypos].drawEnemy();
							break;
						case 's':
							enemypos -= gameboardSizeW;
							if(place[enemypos].getBackground() != place[enemypos].getCheckColor()) {
								collide(enemyId);
							}
						    place[enemypos].drawEnemy();
							break;
						case 'a':
							enemypos += 1;
							if(place[enemypos].getBackground() != place[enemypos].getCheckColor()) {
								collide(enemyId);
							}
						    place[enemypos].drawEnemy();
							break;
						}
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * This class draws the selfPlayer-line to the Game board
	 */
	private class movings extends Thread {
		public void run() {
			 place[playerPos1].drawSelf();
			while(gamerun) {
				try {
					Thread.sleep(speed);
					try {
						switch(server.getDirection(playerId)) {
						case 'w':
							playerPos1 -= gameboardSizeW;
							if(place[playerPos1].getBackground() != place[playerPos1].getCheckColor()) {
								collide(playerId);
							}
						    place[playerPos1].drawSelf();
							break;
						case 'a':
							playerPos1 -= 1;
							if(place[playerPos1].getBackground() != place[playerPos1].getCheckColor()) {
								collide(playerId);
							}
						    place[playerPos1].drawSelf();
							break;
						case 's':
							playerPos1 += gameboardSizeW;
							if(place[playerPos1].getBackground() != place[playerPos1].getCheckColor()) {
								collide(playerId);
							}
						    place[playerPos1].drawSelf();
							break;
						case 'd':
							playerPos1 += 1;
							if(place[playerPos1].getBackground() != place[playerPos1].getCheckColor()) {
								collide(playerId);
							}
						    place[playerPos1].drawSelf();
							break;
						}
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * This class implements the Keylistener to load the 
	 * setted moving direction to the server.
	 * 
	 */
	private class MovingListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			//System.out.println(e.getKeyChar());
			if (e.getKeyChar() == 'w' 
					|| e.getKeyChar() == 'a' 
					|| e.getKeyChar() == 's' 
					|| e.getKeyChar() == 'd')
				try {
					server.ChangeDirection(playerId, e.getKeyChar());
					System.out.print(playerId);
					System.out.println(server.getDirection(playerId));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  ;
			
			if (id == 3 & e.getKeyChar() == 'i' 
					|| e.getKeyChar() == 'j' 
					|| e.getKeyChar() == 'k' 
					|| e.getKeyChar() == 'l')
				try {
					switch(e.getKeyChar()) {
					case 'i':
						server.ChangeDirection(enemyId, 's');
						break;
					case 'j':
						server.ChangeDirection(enemyId, 'd');
						break;
					case 'k':
						server.ChangeDirection(enemyId, 'w');
						break;
					case 'l':
						server.ChangeDirection(enemyId, 'a');
						break;
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
		}

		@Override
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}
	}
}
