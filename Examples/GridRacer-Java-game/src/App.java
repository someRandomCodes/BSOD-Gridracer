import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {

    public static void main(String[] args) {
        JFrame gameStartFrame = new JFrame();
        gameStartFrame.setTitle("Welcome to GridRacer by B.S.O.D");
        gameStartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameStartFrame.setSize(420,320);
        gameStartFrame.setVisible(true);

        JLabel jl_Welcome = new JLabel();
        jl_Welcome.setText("Welcome to");
        jl_Welcome.setForeground(Color.GRAY);
        jl_Welcome.setFont(new Font("MV Boli", Font.ITALIC,30));
        jl_Welcome.setVerticalTextPosition(JLabel.CENTER);
        jl_Welcome.setHorizontalTextPosition(JLabel.CENTER);

        JLabel jl_GridRacer = new JLabel();
        jl_GridRacer.setText("GRIDRACER");
        jl_GridRacer.setForeground(Color.GRAY);
        jl_GridRacer.setFont(new Font("MV Boli", Font.BOLD,50));
        jl_GridRacer.setVerticalTextPosition(JLabel.CENTER);
        jl_GridRacer.setHorizontalTextPosition(JLabel.CENTER);
    
        JButton btn_Start = new JButton();
        btn_Start.setText("Start Game");
        btn_Start.setSize(250, 40);

        JPanel jp_background = new JPanel();
        jp_background.setBackground(new Color(0x00008B));
        jp_background.setBounds(0,0,420,420);

        jp_background.add(jl_Welcome);
        jp_background.add(jl_GridRacer);
        jp_background.add((btn_Start));
        
        gameStartFrame.add(jp_background);

    }
}
