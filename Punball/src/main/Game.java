package main;

import map.Map;
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
    ObjectHandler handler;
    // MouseClick m_Click;
    // MouseMove m_Move;
    KeyHandler KeyH;

    Enemy enemy;
    Player player;
    RandomMap map;

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

    public Game(CardLayout cardLayout, JPanel mainPanel, int hpLevel, int attack) {
        gameInit(cardLayout, mainPanel, hpLevel, attack);
    }

    public void gameInit(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        // Objects
        handler = new ObjectHandler();

        // m_Click = new MouseClick();
        // m_Move = new MouseMove();
        KeyH = new KeyHandler();
        player = new Player(this, KeyH, handler);
        handler.addObject(player);

        enemy = new Enemy();

        // Map-Objects
        handler.addObject(new Map(0, 180, 300, 540));
        handler.addObject(new Map(0, 0, 960, 180));
        handler.addObject(new Map(659, 180, 300, 540));

        map = new RandomMap();

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

    // Overloaded method for upgrade screen
    public void gameInit(CardLayout cardLayout, JPanel mainPanel, int hpLevel, int attack) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        // Objects
        handler = new ObjectHandler();

        // m_Click = new MouseClick();
        // m_Move = new MouseMove();
        KeyH = new KeyHandler();
        player = new Player(this, KeyH, handler,hpLevel,attack);
        handler.addObject(player);

        // Map-Objects
        handler.addObject(new Map(0, 180, 300, 540));
        handler.addObject(new Map(0, 0, 960, 180));
        handler.addObject(new Map(659, 180, 300, 540));

        enemy = new Enemy();
        map = new RandomMap();

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

    // Overloaded method for upgrade screen
    public void restartGame(CardLayout cardLayout, JPanel mainPanel, int hpLevel, int attack) {
        this.removeAll();
        this.revalidate();
        this.repaint();
        System.gc();
        System.out.println(hpLevel);
        gameInit(cardLayout, mainPanel, hpLevel, attack);
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
