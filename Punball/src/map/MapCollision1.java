package map;

import java.awt.Rectangle;

//Left mountain
public class MapCollision1 extends Map {

    public MapCollision1() {
        x = 0;
        y = 180;
        height = 540;
        width = 300;
    }

    @Override
    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }
    
}
