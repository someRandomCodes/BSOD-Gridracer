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

import serverApplication.ChatInterface;
import serverApplication.GameInterface;

public class Panel_TheGame extends JPanel {
	GameInterface server;
	private int gameboardSizeW = 80;
	private int gameboardSizeH = 60;
	private int gameboardSize = gameboardSizeH * gameboardSizeW;
	private boolean gamerun = false;
	private gamestart gameStart = new gamestart();
	private movings movingSelfThread = new movings();
	private enemy enemyMovingThread = new enemy();
	private Gameplace[] place = new Gameplace[gameboardSize];
	private int enemyId = 2;
	private int playerId = 1;

	/**
	 * 
	 */
	private static final long serialVersionUID = 5438164405065722657L;

	Panel_TheGame() {
		this.setLayout(new GridLayout(gameboardSizeH, gameboardSizeW));
		this.setFocusable(true);
		this.addKeyListener(new MovingListener());
		
		for (int i = 0; i < gameboardSize ;i++) {
			place[i] = new Gameplace();
			this.add(place[i]);	
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
		
		try {
			GameInterface gameinterface = (GameInterface)Naming.lookup("rmi://localhost:1099/GameSrv");	
	        server = gameinterface;   
		} catch(Exception e) {
			System.out.println(e);
		}	
		gameStart.start();
	}
	
	private class gamestart extends Thread {
		public void run() {
		while (!gamerun) {
			System.out.println("wait for playerRdy");
			try {
				gamerun = server.playerRdy();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (gamerun) {
				movingSelfThread.start();
				enemyMovingThread.start();
				gameStart.stop();
			}
			}	
		}
	}
	
	private class enemy extends Thread {
		public void run() {
			int enemypos = 80;
			while(gamerun) {
				try {
					Thread.sleep(200);
					try {
						switch(server.getDirection(enemyId)) {
						case 'i':
							enemypos-= gameboardSizeW;
							if(place[enemypos].getBackground() != Color.cyan) {
								JOptionPane.showMessageDialog(null, "colide");							
								enemyMovingThread.stop();
							}
						    place[enemypos].drawEnemy();
							break;
						case 'j':
							enemypos-=1;
							if(place[enemypos].getBackground() != Color.cyan) {
								JOptionPane.showMessageDialog(null, "colide");							
								enemyMovingThread.stop();
							}
						    place[enemypos].drawEnemy();
							break;
						case 'k':
							enemypos+= gameboardSizeW;
							if(place[enemypos].getBackground() != Color.cyan) {
								JOptionPane.showMessageDialog(null, "colide");
								enemyMovingThread.stop();
							}
						    place[enemypos].drawEnemy();
							break;
						case 'l':
							enemypos+=1;
							if(place[enemypos].getBackground() != Color.cyan) {
								JOptionPane.showMessageDialog(null, "colide");							
								enemyMovingThread.stop();
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
	
	private class movings extends Thread {
		
		@SuppressWarnings("deprecation")
		public void run() {
			int playerPos1 = 4798;
			while(gamerun) {
				try {
					Thread.sleep(200);
					try {
						switch(server.getDirection(playerId)) {
						case 'w':
							playerPos1-= gameboardSizeW;
							if(place[playerPos1].getBackground() != Color.cyan) {
								JOptionPane.showMessageDialog(null, "colide");							
								movingSelfThread.stop();
							}
						    place[playerPos1].drawSelf();
							break;
						case 'a':
							playerPos1-=1;
							if(place[playerPos1].getBackground() != Color.cyan) {
								JOptionPane.showMessageDialog(null, "colide");							
								movingSelfThread.stop();
							}
						    place[playerPos1].drawSelf();
							break;
						case 's':
							playerPos1+= gameboardSizeW;
							if(place[playerPos1].getBackground() != Color.cyan) {
								JOptionPane.showMessageDialog(null, "colide");
								movingSelfThread.stop();
							}
						    place[playerPos1].drawSelf();
							break;
						case 'd':
							playerPos1+=1;
							if(place[playerPos1].getBackground() != Color.cyan) {
								JOptionPane.showMessageDialog(null, "colide");							
								movingSelfThread.stop();
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

	
	private class MovingListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println(e.getKeyChar());
			if (e.getKeyChar() == 'w' 
					|| e.getKeyChar() == 'a' 
					|| e.getKeyChar() == 's' 
					|| e.getKeyChar() == 'd')
				try {
					server.ChangeDirection(playerId, e.getKeyChar());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  ;
			
			if (e.getKeyChar() == 'i' 
					|| e.getKeyChar() == 'j' 
					|| e.getKeyChar() == 'k' 
					|| e.getKeyChar() == 'l')
				try {
					server.ChangeDirection(enemyId, e.getKeyChar());
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
