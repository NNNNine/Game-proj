package main;

import map.MapCollision1;
import map.MapCollision2;
import map.MapCollision3;
import map.RandomMap;

import entity.*;

import java.awt.*;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{
    
    //Screen Res
    final int maxScreenCol = 16;
    final int maxScreenRow = 13;
    final int screenWidth = 960;
    final int screenHeight = 780;

    //Objects
    MouseClick m_Click = new MouseClick();
    MouseMove m_Move = new MouseMove();
    KeyHandler KeyH = new KeyHandler();

    Enemy enemy = new Enemy();
    Player player = new Player(this, KeyH, m_Click);
    RandomMap map = new RandomMap();

    //Map-Collision
    MapCollision1 m1 = new MapCollision1();
    MapCollision2 m2 = new MapCollision2();
    MapCollision3 m3 = new MapCollision3();

    //Switching page
    private CardLayout cardLayout;
    private JPanel mainPanel;

    Thread gameThread;

    public Game(CardLayout cardLayout,JPanel mainPanel) {

        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }

    public Player getPlayer(){
        return player;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    //FPS
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
        player.update();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        map.draw(g2d);
        player.draw(g2d);
        enemy.draw(g2d);
        

        g2d.dispose();
    }
}
