package map;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.ID;

public class Map {
    public int x, y, width, height;

    public Map(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }

    public void update() {
        // TODO Auto-generated method stub

    }

    public void draw(Graphics g) {
        // TODO Auto-generated method stub

    }
}
