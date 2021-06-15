package characterSettings;

import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *  Classen kommentar
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

	
	private static final long serialVersionUID = -715260095579860078L;

	/*
	 * Methoden Kommentar
	 */
	public Panel_CharacterMenue() {
		jl_name.setText(Loadsave.loadName());
		jl_score_text.setText(Integer.toString(Loadsave.loadScore()));
		
		this.setPreferredSize(new Dimension(1280, 640));
		this.setLayout(null);
		
		backgroundGif.setBounds(0,0,1280,640);
		backgroundGif.setVisible(true);
		this.add(backgroundGif);
		
		backgroundGif.setLayout(new GridBagLayout());
		gbc.insets = new Insets(20, 20, 20, 20);

		btn_back.addActionListener(e -> btn_back_clicked());
		btn_charOne.addActionListener(e -> btn_charOne_clicked());
		btn_charTwo.addActionListener(e -> btn_charTwo_clicked());
		btn_charThree.addActionListener(e -> btn_charThree_clicked());
		btn_save.addActionListener(e -> btn_save_clicked());
		
		jl_charOne.setPreferredSize(new Dimension(300,400));
		jl_charOne.setIcon(new ImageIcon("src\\assets\\img\\character1.png"));
		jl_charOne.setOpaque(true);
		
		jl_charTwo.setPreferredSize(new Dimension(300,400));
		jl_charTwo.setIcon(new ImageIcon("src\\assets\\img\\character2.png"));
		jl_charTwo.setOpaque(true);
		
		jl_charThree.setPreferredSize(new Dimension(300,400));
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
    }
    
	/*
	 * Methoden Kommentar
	 */
    private void btn_charOne_clicked() {
    	jl_charOne.setIcon(new ImageIcon("src\\assets\\img\\character1selected.png"));
    	jl_charTwo.setIcon(new ImageIcon("src\\assets\\img\\character2.png"));
    	jl_charThree.setIcon(new ImageIcon("src\\assets\\img\\character3.png"));
    	chosen = '1';
    }
    
	/*
	 * Methoden Kommentar
	 */
    private void btn_charTwo_clicked() {
    	jl_charTwo.setIcon(new ImageIcon("src\\assets\\img\\character2selected.png"));
    	jl_charOne.setIcon(new ImageIcon("src\\assets\\img\\character1.png"));
    	jl_charThree.setIcon(new ImageIcon("src\\assets\\img\\character3.png"));
    	chosen = '2';
    }
    
	/*
	 * Methoden Kommentar
	 */
    private void btn_charThree_clicked() {
    	jl_charThree.setIcon(new ImageIcon("src\\assets\\img\\character3selected.png"));
    	jl_charOne.setIcon(new ImageIcon("src\\assets\\img\\character1.png"));
    	jl_charTwo.setIcon(new ImageIcon("src\\assets\\img\\character2.png"));
    	chosen = '3';
    }
    
	/*
	 * Methoden Kommentar
	 */
    private void btn_save_clicked() {
    	Loadsave.savePlayer(jl_name.getText(), Loadsave.loadScore(), chosen);
    }
}
