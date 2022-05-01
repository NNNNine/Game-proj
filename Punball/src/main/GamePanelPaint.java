package main;

import javax.swing.*;

import entity.*;
import map.RandomMap;
import map.ObstacleManager;

import java.awt.*;

public class GamePanelPaint extends JPanel {
    private Player player;
    private Enemy enemy;
    private RandomMap map;
    private ObstacleManager obs;
    private Ball ball;

    public GamePanelPaint(Enemy enemy, Player player, RandomMap map, ObstacleManager obs, Ball ball) {
        this.player = player;
        this.enemy = enemy;
        this.map = map;
        this.obs = obs;
        this.ball = ball;
        this.setBounds(0, 0, 960, 780);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        map.draw(g2d);
        obs.draw(g2d);
        player.draw(g);
        enemy.draw(g2d);
        ball.draw(g2d);

        g2d.dispose();
    }
}
