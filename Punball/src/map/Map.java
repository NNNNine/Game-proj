package map;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import javax.swing.border.LineBorder;

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

    // ขอบเขตของเกมที่ยิงลูกบอล
    public Rectangle getBoundInGame(){ 
        int xLeft = 300; //  จุดxด้านซ้าย
        int yTop = 180; // yด้านบน
        int xRight = 660; //  จุดxขวา
        int yBot = 650; // yด้านล่าง
        return new Rectangle(xLeft,yTop, xRight-xLeft,yBot-yTop);
    }

    public void update() {
        // TODO Auto-generated method stub

    }

    public void draw(Graphics g) {
        // TODO Auto-generated method stub

    }
}
