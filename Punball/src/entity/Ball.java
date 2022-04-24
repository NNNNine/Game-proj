package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.GameObject;
import main.ID;
import main.ObjectHandler;

public abstract class Ball extends GameObject {
    public int ball_ammo;

    private ObjectHandler handler;

    public Ball(int x, int y, ID id, ObjectHandler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public abstract Rectangle getBound();
}
