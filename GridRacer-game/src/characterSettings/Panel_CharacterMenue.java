package characterSettings;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Lukas -> Layout anpassen

public class Panel_CharacterMenue extends JPanel {
	JButton btn_back = new JButton("Back");
	JButton btn_charOne = new JButton("Character 1");
	JButton btn_charTwo = new JButton("Character 2");
	JButton btn_charThree = new JButton("Character 3");

	JLabel jl_charOne = new JLabel("Charakter1");
	JLabel jl_charTwo = new JLabel("Charakter2");
	JLabel jl_charThree = new JLabel("Charakter3");

	
	private static final long serialVersionUID = -715260095579860078L;

	public Panel_CharacterMenue() {
		this.setPreferredSize(new Dimension(1280, 640));

		btn_back.addActionListener(e -> btn_back_clicked());
		btn_charOne.addActionListener(e -> btn_charOne_clicked());
		btn_charTwo.addActionListener(e -> btn_charTwo_clicked());
		btn_charThree.addActionListener(e -> btn_charThree_clicked());
		
		jl_charOne.setPreferredSize(new Dimension(160,200));
		jl_charOne.setBackground(Color.black);
		jl_charOne.setOpaque(true);
		
		jl_charTwo.setPreferredSize(new Dimension(160,200));
		jl_charTwo.setBackground(Color.black);
		jl_charTwo.setOpaque(true);
		
		jl_charThree.setPreferredSize(new Dimension(160,200));
		jl_charThree.setBackground(Color.black);
		jl_charThree.setOpaque(true);

		this.add(btn_back);
		this.add(jl_charOne);
		this.add(btn_charOne);
		this.add(jl_charTwo);
		this.add(btn_charTwo);
		this.add(jl_charThree);
		this.add(btn_charThree);
	}
    
    private void btn_back_clicked() {
		this.setVisible(false);
		this.getParent().getComponents()[0].setVisible(true);
		this.getParent().remove(this);
    }
    
    private void btn_charOne_clicked() {
    	
    }
    
    private void btn_charTwo_clicked() {
    	
    }
    
    private void btn_charThree_clicked() {
    	
    }
    
}
