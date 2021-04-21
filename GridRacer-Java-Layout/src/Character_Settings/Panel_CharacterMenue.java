package Character_Settings;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Panel_CharacterMenue extends JPanel {
	JButton btn_back = new JButton();
	JButton btn_charOne = new JButton();
	JButton btn_charTwo = new JButton();
	JButton btn_charThree = new JButton();

	JLabel jl_charOne = new JLabel();
	JLabel jl_charTwo = new JLabel();
	JLabel jl_charThree = new JLabel();

	
	private static final long serialVersionUID = -715260095579860078L;

	public Panel_CharacterMenue() {
		this.setPreferredSize(new Dimension(1280, 640));
		createComponents();
		addComponents();
	}
	
	public void createComponents() {
		btn_back.setText("Back");
		
		btn_back.addActionListener(e -> btn_back_clicked());
		btn_charOne.setText("Character 1");
		
		btn_charOne.addActionListener(e -> btn_charOne_clicked());
		btn_charTwo.setText("Character 2");
		btn_charTwo.addActionListener(e -> btn_charTwo_clicked());
		
		btn_charThree.setText("Character 3");
		btn_charThree.addActionListener(e -> btn_charThree_clicked());
		
		jl_charOne.setPreferredSize(new Dimension(160,200));
		jl_charOne.setBackground(Color.black);
		jl_charOne.setOpaque(true);
		jl_charOne.setText("Charakter1");
		
		jl_charTwo.setPreferredSize(new Dimension(160,200));
		jl_charTwo.setBackground(Color.black);
		jl_charTwo.setOpaque(true);
		jl_charTwo.setText("Charakter2");
		
		jl_charThree.setPreferredSize(new Dimension(160,200));
		jl_charThree.setBackground(Color.black);
		jl_charThree.setOpaque(true);
		jl_charThree.setText("Charakter3");
	}
	
    private void addComponents() {  
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
