package map;

import java.awt.Graphics;
import java.awt.Rectangle;
import main.GameObject;
import main.ID;

public class Map extends GameObject {
    public int x, y, width, height;

    public Map(int x, int y, int width, int height) {
        super(x, y, ID.Map);
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub

    }
}
