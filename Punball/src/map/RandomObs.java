package map;

import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RandomObs {
    public int[] obstacle = { 0, 0, 1, 1, 1, 1 };

    public void rand_ob() {
        Random r = new Random();
        obstacle[0] = r.nextInt(4) + 2;
        obstacle[1] = r.nextInt(4) + 2;
    }

    public int[] rand_all_ob() {
        int[] s = new int[6];
        boolean[] b = { false, false, false, false, false, false };
        rand_ob();
        Random r = new Random();

        for (int i = 0; i < 6; i += 0) {

            int temp = r.nextInt(6);
            if (b[temp] == false) {
                b[temp] = true;
                s[i] = obstacle[temp];
                i++;
            }

        }

        return s;
    }

}