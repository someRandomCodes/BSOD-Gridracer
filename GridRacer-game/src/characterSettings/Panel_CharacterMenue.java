package characterSettings;

import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
import javax.swing.JTextField;

/**
 * Klassen beschreibung
 * @author Thomas Guede Stork
 * @author Islyam Makanalin
 * @author Lukas Mohrbacher
 */
public class Panel_CharacterMenue extends JPanel {
	private char chosen = ' ';
	private JButton btn_back = new JButton("Back");
	private JButton btn_charOne = new JButton("Lvl 1 crook");
	private JButton btn_charTwo = new JButton("Lvl 69 gangster");
	private JButton btn_charThree = new JButton("Lvl 1000 mafia boss");
	private JButton btn_save = new JButton("Save");

	private JLabel jl_charOne = new JLabel("Charakter1");
	private JLabel jl_charTwo = new JLabel("Charakter2");
	private JLabel jl_charThree = new JLabel("Charakter3");
	private JLabel jl_charDesc = new JLabel("Charakter");
	private JLabel backgroundGif = new JLabel(new ImageIcon("src\\assets\\img\\test3.gif"));	
	
	private JLabel jl_score = new JLabel("Score");
	private JLabel jl_score_text = new JLabel();
	private JTextField jl_name = new JTextField(15);
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	int volume = -20;

	
	private static final long serialVersionUID = -715260095579860078L;

	/*
	 * Methoden Kommentar
	 */
	public Panel_CharacterMenue() {
		Font font = new Font("Apple Casual", Font.ITALIC|Font.BOLD, 20);
		jl_name.setText(Loadsave.loadName());
		
		jl_name.setBounds(540,260,200,40);
		jl_name.setBackground(Color.black);
		jl_name.setFont(font);
		jl_name.setForeground(Color.white);
		
		jl_score.setText("Score: " + Integer.toString(Loadsave.loadScore()));
		
		jl_score.setBounds(540,260,200,40);
		jl_score.setBackground(Color.black);
		jl_score.setFont(font);
		jl_score.setForeground(Color.white);
		
		jl_charDesc.setBounds(540,260,200,40);
		jl_charDesc.setBackground(Color.black);
		jl_charDesc.setFont(font);
		jl_charDesc.setForeground(Color.white);
		
		this.setPreferredSize(new Dimension(1280, 640));
		this.setLayout(null);
		
		backgroundGif.setBounds(0,0,1280,640);
		backgroundGif.setVisible(true);
		this.add(backgroundGif);
		
		backgroundGif.setLayout(new GridBagLayout());
		gbc.insets = new Insets(20, 20, 20, 20);

		btn_back.addActionListener(e -> btn_back_clicked());
		
		btn_back.setBounds(540,260,200,40);
		btn_back.setBackground(Color.black);
		btn_back.setFont(font);
		btn_back.setForeground(Color.white);
		
		btn_charOne.addActionListener(e -> btn_charOne_clicked());
		
		btn_charOne.setBounds(540,260,200,40);
		btn_charOne.setBackground(Color.black);
		btn_charOne.setFont(font);
		btn_charOne.setForeground(Color.white);
		
		btn_charTwo.addActionListener(e -> btn_charTwo_clicked());
		
		btn_charTwo.setBounds(540,260,200,40);
		btn_charTwo.setBackground(Color.black);
		btn_charTwo.setFont(font);
		btn_charTwo.setForeground(Color.white);
		
		btn_charThree.addActionListener(e -> btn_charThree_clicked());
		
		btn_charThree.setBounds(540,260,200,40);
		btn_charThree.setBackground(Color.black);
		btn_charThree.setFont(font);
		btn_charThree.setForeground(Color.white);
		
		btn_save.addActionListener(e -> btn_save_clicked());
		
		btn_save.setBounds(540,260,200,40);
		btn_save.setBackground(Color.black);
		btn_save.setFont(font);
		btn_save.setForeground(Color.white);
		
		
		jl_charOne.setPreferredSize(new Dimension(300,350));
		jl_charOne.setIcon(new ImageIcon("src\\assets\\img\\character1.png"));
		jl_charOne.setOpaque(true);
		
		jl_charTwo.setPreferredSize(new Dimension(300,350));
		jl_charTwo.setIcon(new ImageIcon("src\\assets\\img\\character2.png"));
		jl_charTwo.setOpaque(true);
		
		jl_charThree.setPreferredSize(new Dimension(300,350));
		jl_charThree.setIcon(new ImageIcon("src\\assets\\img\\character3.png"));
		jl_charThree.setOpaque(true);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		backgroundGif.add(btn_back, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		backgroundGif.add(jl_charOne, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		backgroundGif.add(btn_charOne, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		backgroundGif.add(jl_charTwo, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		backgroundGif.add(btn_charTwo, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		backgroundGif.add(jl_charThree, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		backgroundGif.add(btn_charThree, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		backgroundGif.add(jl_name, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		backgroundGif.add(jl_charDesc, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		backgroundGif.add(jl_score, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 3;
		backgroundGif.add(btn_save, gbc);
	}
	
	/*
	 * Methoden Kommentar
	 */
    private void btn_back_clicked() {
		this.setVisible(false);
		this.getParent().getComponents()[0].setVisible(true);
		this.getParent().remove(this);
		
		try {
			ButtonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/*
	 * Methoden Kommentar
	 */
    private void btn_charOne_clicked() {
    	jl_charOne.setIcon(new ImageIcon("src\\assets\\img\\character1selected.png"));
    	jl_charTwo.setIcon(new ImageIcon("src\\assets\\img\\character2.png"));
    	jl_charThree.setIcon(new ImageIcon("src\\assets\\img\\character3.png"));
    	chosen = '1';
    	
    	try {
			ButtonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/*
	 * Methoden Kommentar
	 */
    private void btn_charTwo_clicked() {
    	jl_charTwo.setIcon(new ImageIcon("src\\assets\\img\\character2selected.png"));
    	jl_charOne.setIcon(new ImageIcon("src\\assets\\img\\character1.png"));
    	jl_charThree.setIcon(new ImageIcon("src\\assets\\img\\character3.png"));
    	chosen = '2';
    	
    	try {
			ButtonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/*
	 * Methoden Kommentar
	 */
    private void btn_charThree_clicked() {
    	jl_charThree.setIcon(new ImageIcon("src\\assets\\img\\character3selected.png"));
    	jl_charOne.setIcon(new ImageIcon("src\\assets\\img\\character1.png"));
    	jl_charTwo.setIcon(new ImageIcon("src\\assets\\img\\character2.png"));
    	chosen = '3';
    	
    	try {
			ButtonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/*
	 * Methoden Kommentar
	 */
    private void btn_save_clicked() {
    	Loadsave.savePlayer(jl_name.getText(), Loadsave.loadScore(), chosen);
    	
    	try {
			ButtonClickSound();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public  void ButtonClickSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
    	File file = new File("src\\assets\\sounds\\buttonclick.wav");
    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioStream);
    	FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    	gainControl.setValue((float) + volume);
    	clip.start();
    }
}

