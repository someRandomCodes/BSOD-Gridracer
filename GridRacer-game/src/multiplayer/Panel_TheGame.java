package multiplayer;

import java.awt.Color;
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
 * Klassen beschreibung
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
	 * 
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

	void colide(int id) {
		JOptionPane.showMessageDialog(null, "colide from " + id );
		try {
			server.resetGame();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drawGamefield();
	}
	
	/*
	 * 
	 */
	private class gamestart extends Thread {
		public void run() {
		while (!gamerun) {
			//System.out.println("wait for playerRdy");
			try {
				gamerun = server.playerRdy();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
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
	
	/*
	 * 
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
							if(place[enemypos].getBackground() != Color.cyan) {
								colide(enemyId);
							}
						    place[enemypos].drawEnemy();
							break;
						case 'd':
							enemypos -= 1;
							if(place[enemypos].getBackground() != Color.cyan) {
								colide(enemyId);
							}
						    place[enemypos].drawEnemy();
							break;
						case 's':
							enemypos -= gameboardSizeW;
							if(place[enemypos].getBackground() != Color.cyan) {
								colide(enemyId);
							}
						    place[enemypos].drawEnemy();
							break;
						case 'a':
							enemypos += 1;
							if(place[enemypos].getBackground() != Color.cyan) {
								colide(enemyId);
							}
						    place[enemypos].drawEnemy();
							break;
						}
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * 
	 */
	private class movings extends Thread {
		@SuppressWarnings("deprecation")
		public void run() {
			 place[playerPos1].drawSelf();
			while(gamerun) {
				try {
					Thread.sleep(speed);
					try {
						switch(server.getDirection(playerId)) {
						case 'w':
							playerPos1 -= gameboardSizeW;
							if(place[playerPos1].getBackground() != Color.cyan) {
								colide(playerId);
							}
						    place[playerPos1].drawSelf();
							break;
						case 'a':
							playerPos1 -= 1;
							if(place[playerPos1].getBackground() != Color.cyan) {
								colide(playerId);
							}
						    place[playerPos1].drawSelf();
							break;
						case 's':
							playerPos1 += gameboardSizeW;
							if(place[playerPos1].getBackground() != Color.cyan) {
								colide(playerId);
							}
						    place[playerPos1].drawSelf();
							break;
						case 'd':
							playerPos1 += 1;
							if(place[playerPos1].getBackground() != Color.cyan) {
								colide(playerId);
							}
						    place[playerPos1].drawSelf();
							break;
						}
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
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
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
}
