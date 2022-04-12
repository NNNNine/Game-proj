package main;

import java.awt.*;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{
    
    final int maxScreenCol = 16;
    final int maxScreenRow = 13;

    final int screenWidth = 960;
    final int screenHeight = 780;

    KeyHandler KeyH = new KeyHandler();
    Thread gameThread;

    int playerXdis = 480;
    int playerYdis = 690;
    final int playerSpeed = 10;

    public Game() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
     
    final int FPS = 60;

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {

            update();
            
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if(KeyH.leftPress == true) {
            playerXdis -= playerSpeed;
        }
        else if(KeyH.rightPress == true) {
            playerXdis += playerSpeed;
        }
    }
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        g2d.fillOval(playerXdis, playerYdis, 20, 20);

        g2d.dispose();
    }
}
