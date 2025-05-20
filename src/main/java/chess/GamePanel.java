package chess;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class GamePanel extends JPanel implements Runnable{
    
    // SIZE
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();


    // COLOR 
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int CurrentColor = WHITE;


    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.BLACK);
    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        
        // GAME LOOP = sequence of processes that run continuously as long as the game is running.
        // We use System.nanoTime tomease the elapsed time and call update and repaint methods once every 1/60 of a second.

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){

            currentTime = System.nanoTime();
        
            delta += (currentTime - lastTime ) / drawInterval;
            lastTime = currentTime;

            if ( delta >= 1 ){
                update();
                repaint();
                delta--;
            }
        }


    }

    private void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        board.draw(g2);
    }
}
