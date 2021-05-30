package multiplayer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel_TheGame extends JPanel {
	private int gameboardSizeW = 80;
	private int gameboardSizeH = 60;
	private int gameboardSize = gameboardSizeH * gameboardSizeW;
	private boolean gamerun = true;
	private char moveSelfDirektion = 's';
	private movings movingSelfThread = new movings();
	private enemy enemyMovingThread = new enemy();
	private Gameplace[] place = new Gameplace[gameboardSize];

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
			System.out.println((i+1) + "Felder erstellt");
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
		
		movingSelfThread.start();
		enemyMovingThread.start();
		
	}
	
	private class enemy extends Thread {
		public void run() {
			int enemyPos1 = 82;
			while(gamerun) {
				try {
					Thread.sleep(40);
					place[enemyPos1].drawEnemy();
					if(enemyPos1 < gameboardSize) enemyPos1++;
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
			int playerPos1 = 580;
			System.out.println("voher");
			while(gamerun) {
				try {
					System.out.println("voher");
					Thread.sleep(40);
					System.out.println("nachher");
					switch(moveSelfDirektion) {
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
					|| e.getKeyChar() == 'd') moveSelfDirektion = e.getKeyChar();
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
