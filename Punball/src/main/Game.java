package main;

import map.MapCollision1;
import map.MapCollision2;
import map.MapCollision3;
import map.RandomMap;

import entity.*;

import java.awt.*;

import javax.swing.*;

public class Game extends JPanel implements Runnable {

    // Screen Res
    final int maxScreenCol = 16;
    final int maxScreenRow = 13;
    final int screenWidth = 960;
    final int screenHeight = 780;

    // Objects
    MouseClick m_Click;
    MouseMove m_Move;
    KeyHandler KeyH;

    Enemy enemy;
    Player player;
    RandomMap map;

    // Map-Collision
    MapCollision1 m1;
    MapCollision2 m2;
    MapCollision3 m3;

    // Switching page
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // butons test as a ball hit player/enemy on game screen
    JButton buttonTest;
    JButton buttonTest2;

    Thread gameThread;

    public Game(CardLayout cardLayout, JPanel mainPanel) {
        gameInit(cardLayout, mainPanel);
    }

    public void gameInit(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        // Objects
        m_Click = new MouseClick();
        m_Move = new MouseMove();
        KeyH = new KeyHandler();

        enemy = new Enemy();
        player = new Player(this, KeyH, m_Click);
        map = new RandomMap();

        // Map-Collision
        m1 = new MapCollision1();
        m2 = new MapCollision2();
        m3 = new MapCollision3();

        // Button test as a ball attack player
        Icon iconUpgrade = new ImageIcon("imgs/UpgradeButton.png");
        buttonTest = new JButton(iconUpgrade);
        buttonTest.setBounds(0, 0, 300, 95);
        buttonTest.addActionListener(e -> {
            if (!player.decreaseHP(300)) {
                cardLayout.show(mainPanel, "loseScreen");
            }
            System.out.println(player.getHP());
        });

        // Button test as a ball attack enemy
        Icon iconNext = new ImageIcon("imgs/NextButton.png");
        buttonTest2 = new JButton(iconNext);
        buttonTest2.setBounds(0, 115, 300, 95);
        buttonTest2.addActionListener(e -> {
            if (!enemy.decreaseHP(300)) {
                cardLayout.show(mainPanel, "winScreen");
            }
            System.out.println(enemy.getHP());
        });

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(null);

        this.add(buttonTest);
        this.add(buttonTest2);

        this.add(player.getPlayerHealthBar());
        this.add(enemy.getEnemyHealthBar());
        this.add(new GamePanelPaint(enemy, player, map));
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }

    public void restartGame(CardLayout cardLayout, JPanel mainPanel) {
        this.removeAll(); // remove all components from panel but not completely destroy
        this.revalidate(); // after remove, put back objects~~
        this.repaint();
        System.gc(); // คือการทำบาย objects ที่ไม่ได้ใช้แล้ว ไม่ให้เปลืองความจำ
        gameInit(cardLayout, mainPanel);
    }

    public Player getPlayer() {
        return player;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // FPS
    final int FPS = 60;

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if (remainingTime < 0) {
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

}
