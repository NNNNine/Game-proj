package main;

import javax.swing.*;

import entity.Enemy;
import entity.Player;
import map.RandomMap;


import java.awt.*;

public class GamePanelPaint extends JPanel {
    private Player player;
    private Enemy enemy;
    private RandomMap map;

    public GamePanelPaint(Enemy enemy, Player player, RandomMap map){
        this.player=player;
        this.enemy=enemy;
        this.map=map;
        this.setBounds(0, 0, 960, 780);
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
