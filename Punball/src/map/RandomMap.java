package map;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class RandomMap {
    public static String[] allMap = {"/map/snow.png", "/map/plain.png", "/map/desert.png", "/map/arid.png"};

    public static String getMap() {
        Random r = new Random();
        int temp_index = r.nextInt() % 4;

        return allMap[temp_index];
    }
}
