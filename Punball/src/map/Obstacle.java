package map;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Obstacle {
    public BufferedImage image;
    public boolean collision = false;
    public boolean powerUp = false;
    private Rectangle bound = new Rectangle();;

    public void setBound(int x, int y) {
        bound.x = x;
        bound.y = y;
        bound.width = 60;
        bound.height = 60;
    }

    public Rectangle getBound() {
        return bound;
    }
}
