package chess;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;


public class GamePanel extends JPanel{
    
    // SIZE
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;

    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.BLACK);
    }

}
