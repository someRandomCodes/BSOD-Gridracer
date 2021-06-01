package characterSettings;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import startGame.Panel_startGame;

// Lukas -> Layout anpassen

public class Panel_CharacterMenue extends JPanel {
	JButton btn_back = new JButton("Back");
	JButton btn_charOne = new JButton("Lvl 1 crook");
	JButton btn_charTwo = new JButton("Lvl 69 gangster");
	JButton btn_charThree = new JButton("Lvl 1000 mafia boss");
	JButton btn_save = new JButton("Save");

	JLabel jl_charOne = new JLabel("Charakter1");
	JLabel jl_charTwo = new JLabel("Charakter2");
	JLabel jl_charThree = new JLabel("Charakter3");
	JLabel jl_charDesc = new JLabel("Charakter");
	
	JLabel jl_score = new JLabel("Score");	//	soll eig JProgressbar sein
	
	JLabel jl_name = new JLabel("Name");	//	soll eig JTextField sein
	
	GridBagConstraints gbc = new GridBagConstraints();

	
	private static final long serialVersionUID = -715260095579860078L;

	public Panel_CharacterMenue() {
		this.setPreferredSize(new Dimension(1280, 640));
		
		setLayout(new GridBagLayout());
		gbc.insets = new Insets(20, 20, 20, 20);

		btn_back.addActionListener(e -> btn_back_clicked());
		btn_charOne.addActionListener(e -> btn_charOne_clicked());
		btn_charTwo.addActionListener(e -> btn_charTwo_clicked());
		btn_charThree.addActionListener(e -> btn_charThree_clicked());
		btn_save.addActionListener(e -> btn_save_clicked());
		
		jl_charOne.setPreferredSize(new Dimension(300,400));
		jl_charOne.setBackground(Color.red);
		jl_charOne.setIcon(new ImageIcon("assets\\img\\character1.png"));
		jl_charOne.setOpaque(true);
		
		jl_charTwo.setPreferredSize(new Dimension(300,400));
		jl_charTwo.setBackground(Color.green);
		jl_charTwo.setIcon(new ImageIcon("assets\\img\\character2.png"));
		jl_charTwo.setOpaque(true);
		
		jl_charThree.setPreferredSize(new Dimension(300,400));
		jl_charThree.setBackground(Color.blue);
		jl_charThree.setIcon(new ImageIcon("assets\\img\\character3.png"));
		jl_charThree.setOpaque(true);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(btn_back, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(jl_charOne, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(btn_charOne, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(jl_charTwo, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		this.add(btn_charTwo, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		this.add(jl_charThree, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		this.add(btn_charThree, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(jl_name, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		this.add(jl_charDesc, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		this.add(jl_score, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 3;
		this.add(btn_save, gbc);
	}
    
    private void btn_back_clicked() {
		this.setVisible(false);
		this.getParent().getComponents()[0].setVisible(true);
		this.getParent().remove(this);
    }
    
    private void btn_charOne_clicked() {
    	jl_charOne.setBorder(getBorder());
    }
    
    private void btn_charTwo_clicked() {
    	jl_charTwo.setBackground(Color.black);
    }
    
    private void btn_charThree_clicked() {
    	jl_charThree.setBackground(Color.black);
    }
    
    private void btn_save_clicked() {

    }
}
