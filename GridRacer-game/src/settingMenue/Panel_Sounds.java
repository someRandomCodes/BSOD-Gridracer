package settingMenue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Klassen beschreibung
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_Sounds extends JPanel {
	Font font = new Font("Apple Casual", Font.ITALIC|Font.BOLD, 20);
	JLabel backgroundGif = new JLabel(new ImageIcon("src/assets/img/test3.gif"));
	SoundSettings myVol = new SoundSettings();
	
	JButton btn_back = new JButton();
	JButton btn_musicOff = new JButton();
	JButton btn_musicOn = new JButton();
	
	static JSlider js_sound = new JSlider(0,80,40);
	
	JLabel jl_volumeAnzeige = new JLabel();
	
	static int a = 1;
	

	public Panel_Sounds() {
		setPreferredSize(new Dimension(1280, 640));
		setLayout(null);
		createComponents();
		addComponents();
		
		backgroundGif.setBounds(0,0,1280,640);
		backgroundGif.setVisible(true);
		this.add(backgroundGif);
	}

	

	private void createComponents() {
		btn_back.setText("Back");
		btn_back.addActionListener(e -> btn_back_clicked());
		btn_musicOff.setText("Off");
		btn_musicOff.addActionListener(e -> btn_musicOff_clicked());
		btn_musicOn.setText("On");
		btn_musicOn.addActionListener(e -> btn_musicOn_clicked());
		
	}
	private void addComponents() {
		backgroundGif.add(btn_back);
		btn_back.setBounds(540,260,200,40);
		btn_back.setBackground(Color.black);
		btn_back.setFont(font);
		btn_back.setForeground(Color.white);
		
		backgroundGif.add(btn_musicOff);
		btn_musicOff.setBounds(660,360,100,40);
		btn_musicOff.setBackground(Color.black);
		btn_musicOff.setFont(font);
		btn_musicOff.setForeground(Color.white);
		
		backgroundGif.add(btn_musicOn);
		btn_musicOn.setBounds(520,360,100,40);
		btn_musicOn.setBackground(Color.black);
		btn_musicOn.setFont(font);
		btn_musicOn.setForeground(Color.white);
		
		backgroundGif.add(js_sound);
		js_sound.setBounds(490,280,300,100);
		js_sound.setOpaque(false);		
		js_sound.setPaintTicks(true);
		js_sound.setMajorTickSpacing(5);
		js_sound.setValue(40);
		
		double js_soundValue = js_sound.getValue();
		int volumeAnzeige = (int) (js_soundValue/80*100);
		backgroundGif.add(jl_volumeAnzeige);
		jl_volumeAnzeige.setBounds(800,275,200,100);
		jl_volumeAnzeige.setText(""+volumeAnzeige+"%");
		jl_volumeAnzeige.setFont(font);
		jl_volumeAnzeige.setForeground(Color.white);
		
		
		
		js_sound.addChangeListener(new ChangeListener() {
			   public void stateChanged(ChangeEvent e) {
				   double js_soundValue = js_sound.getValue();
				   int volumeAnzeige = (int) (js_soundValue/80*100);
			       jl_volumeAnzeige.setText(""+volumeAnzeige+"%");
			   }
			 });
	}
	
	private void btn_back_clicked() {
		this.setVisible(false);
		this.getParent().getComponents()[0].setVisible(true);
		this.getParent().remove(this);
	    try {
			buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
	
	private void btn_musicOff_clicked() {
		a = 2;
	    try {
			buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
    }
	
	private void btn_musicOn_clicked() {
		a = 1;
	    try {
			buttonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
    }
	public static int volume() {
		int vol= -80;
		vol += js_sound.getValue();
		return vol;
		
	}
	
	public static int music() {
		int music = a;
		return music;
	}
	public static  void buttonClickSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		File file = new File("src//assets//sounds//buttonclick.wav");
		
		
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(Panel_Sounds.volume());
		clip.start();
		}
	
}
