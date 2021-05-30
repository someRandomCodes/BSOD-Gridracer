package startGame;

import java.awt.Desktop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import characterSettings.Loadsave;


public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 483402340805838478L;

	/*
	 * Create the Standard Frame
	 */
	public MyFrame() {
		setResizable(false);
		setLocationRelativeTo(null);
		addWindowListener(new onClose());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("GridRacer by B.S.O.D");
	}
	
	
	private class onClose extends WindowAdapter {
		
		/*
		 * Listener is for closing operations
		 * open a website by closing the Frame
		 */
        public void windowClosing(WindowEvent e) {
//            if (!Loadsave.loadGamerated()) {
//        		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
//        		    try {
//        				Desktop.getDesktop().browse(new URI("http://www.do7gt.de/"));
//        			} catch (IOException i) {
//        				i.printStackTrace();
//        			} catch (URISyntaxException i) {
//        				i.printStackTrace();
//        			}
//        		}	
//            }
        	JOptionPane.showMessageDialog(null, "Auf wiedersehen " + Loadsave.loadName());
        }
	}
}
