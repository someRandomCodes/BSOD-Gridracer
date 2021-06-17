package startGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import characterSettings.Loadsave;

/**
 * This class creates the Standard Frame 
 */
public class MyFrame extends JFrame {

	private static final long serialVersionUID = 483402340805838478L;

	/*
	 * Create the Standard Frame
	 */
	public MyFrame(Boolean realClose) {
		setResizable(false);
		setLocationRelativeTo(null);
		if (realClose) addWindowListener(new onClose());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("GridRacer by B.S.O.D");
	}
	
	
	private class onClose extends WindowAdapter {
		
		/*
		 * Listener is for closing operations
		 */
        public void windowClosing(WindowEvent e) {
        	JOptionPane.showMessageDialog(null, "Auf wiedersehen " + Loadsave.loadName());
        	System.exit(0);
        }
	}
}
