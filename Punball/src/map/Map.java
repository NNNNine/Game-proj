package map;

import java.awt.Rectangle;

public abstract class Map {
    public int x, y, width, height;

    public abstract Rectangle getBound();
}
