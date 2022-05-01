package main;

import map.*;
import entity.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel implements Runnable {

    KeyHandler keyH;

    int playerX = 480;
    int playerY = 665;
    int playerSpeed = 3;

    // Screen Res
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 13;
    public final int screenWidth = 960;
    public final int screenHeight = 780;

    // Objects

    Enemy enemy;
    Player player;
    RandomMap map;
    ObstacleManager obs_m_up, obs_m_down;

    GamePanelPaint gamePanelPaint;

    // Switching page
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // butons test as a ball hit player/enemy on game screen
    JButton buttonTest;
    JButton buttonTest2;

    Thread gameThread;

    public Game(CardLayout cardLayout, JPanel mainPanel, KeyHandler keyH) {
        gameInit(cardLayout, mainPanel, keyH);
    }

    public Game(CardLayout cardLayout, JPanel mainPanel, KeyHandler keyH, int hpLevel, int attack) {
        gameInit(cardLayout, mainPanel, keyH, hpLevel, attack);
    }

    public void gameInit(CardLayout cardLayout, JPanel mainPanel, KeyHandler KeyH) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        keyH = new KeyHandler();

        // Objects
        player = new Player(this, KeyH);
        enemy = new Enemy();
        obs_m_up = new ObstacleManager(this, 7);
        obs_m_down = new ObstacleManager(this, 9);
        map = new RandomMap();
        // Map-Objects
        // handler.addObject(new Map(0, 180, 300, 540));
        // handler.addObject(new Map(0, 0, 960, 180));
        // handler.addObject(new Map(659, 180, 300, 540));

        // Button test as a ball attack player
        Icon iconUpgrade = new ImageIcon("imgs/UpgradeButton.png");
        buttonTest = new JButton(iconUpgrade);
        buttonTest.setBounds(0, 0, 300, 95);
        buttonTest.addActionListener(e -> {
            if (!player.decreaseHP(enemy.getAttack())) {
                cardLayout.show(mainPanel, "loseScreen");
            }
            System.out.println(player.getHP());
        });

        // Button test as a ball attack enemy
        Icon iconNext = new ImageIcon("imgs/NextButton.png");
        buttonTest2 = new JButton(iconNext);
        buttonTest2.setBounds(0, 115, 300, 95);
        buttonTest2.addActionListener(e -> {
            if (!enemy.decreaseHP(player.getAttack())) {
                cardLayout.show(mainPanel, "winScreen");
            }
            System.out.println(enemy.getHP());
        });

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(null);

        this.add(buttonTest);
        this.add(buttonTest2);

        // Player player = (Player) this.player;
        // Enemy enemy = (Enemy) this.enemy;

        gamePanelPaint = new GamePanelPaint(enemy, player, map, obs_m_up, obs_m_down);
        this.add(player.getPlayerHealthBar());
        this.add(enemy.getEnemyHealthBar());
        this.add(gamePanelPaint);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
        this.requestFocus();
    }

    // Overloaded method for upgrade screen
    public void gameInit(CardLayout cardLayout, JPanel mainPanel, KeyHandler KeyH, int hpLevel, int attack) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        keyH = new KeyHandler();

        // Objects
        player = new Player(this, KeyH, hpLevel, attack);
        obs_m_up = new ObstacleManager(this, 7);
        obs_m_down = new ObstacleManager(this, 9);
        // Map-Objects
        /*
         * handler.addObject(new Map(0, 180, 300, 540));
         * handler.addObject(new Map(0, 0, 960, 180));
         * handler.addObject(new Map(659, 180, 300, 540));
         */
        enemy = new Enemy();
        map = new RandomMap();

        // Button test as a ball attack player
        Icon iconUpgrade = new ImageIcon("imgs/UpgradeButton.png");
        buttonTest = new JButton(iconUpgrade);
        buttonTest.setBounds(0, 0, 300, 95);
        buttonTest.addActionListener(e -> {
            if (!player.decreaseHP(enemy.getAttack())) {
                cardLayout.show(mainPanel, "loseScreen");
            }
            System.out.println(player.getHP());
        });

        // Button test as a ball attack enemy
        Icon iconNext = new ImageIcon("imgs/NextButton.png");
        buttonTest2 = new JButton(iconNext);
        buttonTest2.setBounds(0, 115, 300, 95);
        buttonTest2.addActionListener(e -> {
            if (!enemy.decreaseHP(player.getAttack())) {
                cardLayout.show(mainPanel, "winScreen");
            }
            System.out.println(enemy.getHP());
        });

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(null);

        this.add(buttonTest);
        this.add(buttonTest2);

        Player player = (Player) this.player;
        Enemy enemy = (Enemy) this.enemy;
        gamePanelPaint = new GamePanelPaint(enemy, player, map, obs_m_up, obs_m_down);
        this.add(player.getPlayerHealthBar());
        this.add(enemy.getEnemyHealthBar());
        this.add(gamePanelPaint);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
        this.requestFocus();
    }

    public void restartGame(CardLayout cardLayout, JPanel mainPanel, KeyHandler KeyH) {
        this.removeAll(); // remove all components from panel but not completely destroy
        this.revalidate(); // after remove, put back objects~~
        this.repaint();
        System.gc(); // คือการทำบาย objects ที่ไม่ได้ใช้แล้ว ไม่ให้เปลืองความจำ
        this.addKeyListener(KeyH);
        gameInit(cardLayout, mainPanel, keyH);
    }

    // Overloaded method for upgrade screen
    public void restartGame(CardLayout cardLayout, JPanel mainPanel, KeyHandler KeyH, int hpLevel, int attack) {
        this.removeAll();
        this.revalidate();
        this.repaint();
        System.gc();
        System.out.println(hpLevel);
        this.addKeyListener(KeyH);
        gameInit(cardLayout, mainPanel, keyH, hpLevel, attack);
    }

    public Player getPlayer() {
        return (Player) player;
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
        // Player player = (Player) this.player;
        this.player.update();
    }

}
