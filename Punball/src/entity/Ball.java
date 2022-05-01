package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import main.ID;

public class Ball {
    public int ball_ammo;
    public int x, y, width, height;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        width = 20;
        height = 20;
    }

    public void update() {

    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }
}
