package map;

import java.awt.Rectangle;

//Right mountain
public class MapCollision3 extends Map {

    public MapCollision3() {
        x = 659; //11 tile -3 pixel + 2 pixel
        y = 180;
        height = 540;
        width = 300;
    }

    @Override
    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }
    
}
