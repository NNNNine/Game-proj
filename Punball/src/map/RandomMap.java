package map;
import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RandomMap {
    public static String[] allMap = {"/map/plain.png", "/map/desert.png", "/map/arid.png"};
    public String chooseMap;
    BufferedImage stage;

    public RandomMap() {
        try {
            stage = ImageIO.read(getClass().getResourceAsStream("Punball/src/res/map/arid.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getMap() {
        Random r = new Random();
        int temp_index = r.nextInt(4);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(stage, null, 0, 0);
    }
}
