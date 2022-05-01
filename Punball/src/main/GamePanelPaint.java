package main;

import javax.swing.*;

import entity.Enemy;
import entity.Player;
import map.RandomMap;
import map.ObstacleManager;

import java.awt.*;

public class GamePanelPaint extends JPanel {
    private Player player;
    private Enemy enemy;
    private RandomMap map;
    private ObstacleManager obs1, obs2;

    public GamePanelPaint(Enemy enemy, Player player, RandomMap map, ObstacleManager obs1, ObstacleManager obs2) {
        this.player = player;
        this.enemy = enemy;
        this.map = map;
        this.obs1 = obs1;
        this.obs2 = obs2;
        this.setBounds(0, 0, 960, 780);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        map.draw(g2d);
        obs1.draw(g2d);
        obs2.draw(g2d);
        player.draw(g);
        enemy.draw(g2d);

        g2d.dispose();
    }
}
