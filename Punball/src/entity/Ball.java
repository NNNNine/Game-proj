package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.ID;

public abstract class Ball {
    public int ball_ammo;
    public int x, y, width, height;

    public Ball(int x, int y, ID id) {
        this.x = x;
        this.y = y;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public abstract Rectangle getBound();
}
