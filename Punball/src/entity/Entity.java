package entity;

import java.awt.Rectangle;

public abstract class Entity {
    public int x, y, height, width;

    public abstract Rectangle getBound();
}
