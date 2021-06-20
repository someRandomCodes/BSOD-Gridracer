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
        	if (!Loadsave.loadGamerated()) {
        		String eingabe =JOptionPane.showInputDialog("Bewerte das Spiel um die Weitrerleitung zu deaktivieren \n Hast du einen deaktivierungscode ?");
        		if (eingabe.equals("BSOD")) {
        			Loadsave.savePlayer(Loadsave.loadName(),Loadsave.loadScore() , Loadsave.loadCharacter(), true);
        		}
        		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
        		    try {
        				Desktop.getDesktop().browse(new URI("http://www.do7gt.de/"));
        			} catch (IOException ex) {
        				ex.printStackTrace();
        			} catch (URISyntaxException ex) {
        				ex.printStackTrace();
        			}
        		}
        	}
        	System.exit(0);
        }
	}
}
