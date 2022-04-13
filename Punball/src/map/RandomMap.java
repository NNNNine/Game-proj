package map;

import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RandomMap {
    public static String[] allMap = {"res/snow.png", "res/plain.png", "res/desert.png", "res/arid.png"};
    public String chooseMap;
    BufferedImage stage;

    public RandomMap() {
        chooseMap = getMap();

        try {
            stage = ImageIO.read(getClass().getResourceAsStream(chooseMap));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMap() {
        Random r = new Random();
        int temp_index = r.nextInt(4);

        return allMap[temp_index];
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(stage, null, 0, 0);
    }
}
