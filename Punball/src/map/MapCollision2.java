package map;

import java.awt.Rectangle;

//Middle mountain
public class MapCollision2 extends Map {

    public MapCollision2() {
        x = 0;
        y = 0;
        height = 180;
        width = 960;
    }

    @Override
    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }
    
}
