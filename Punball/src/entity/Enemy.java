package entity;

import java.util.Random;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy extends Entity{
    public int health;

    public Enemy() {
        Random r = new Random();
        int temp_h = r.nextInt(10);

        health = temp_h * 1000;

        x = 440;
        y = 270;
    }

    public void update() {

    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.fillRect(x, y, 100, 100);
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, 100, 100);
    }
}
