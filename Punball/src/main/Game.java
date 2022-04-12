package main;

import entity.Player;
import java.awt.*;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{
    
    final int maxScreenCol = 16;
    final int maxScreenRow = 13;

    final int screenWidth = 960;
    final int screenHeight = 780;

    Player player = new Player();
    KeyHandler KeyH = new KeyHandler();
    Thread gameThread;

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
        player.update(KeyH);
    }
    
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.WHITE);
        g2d.fillOval(player.x, player.y, 20, 20);

        g2d.dispose();
    }
}
