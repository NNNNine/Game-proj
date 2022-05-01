package map;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import main.Game;

public class ObstacleManager {

    Game g;
    Obstacle[] obs;
    private boolean are_random, second_rand;
    private int[] r_obs = { 1, 3, 1, 1, 5, 1 };
    private int row;

    public ObstacleManager(Game g, int r) {
        this.g = g;

        row = r;
        obs = new Obstacle[6];
        are_random = false;
        second_rand = false;
        // t_rand = new RandomObs();

        getObsImage();
    }

    public void getObsImage() {
        try {
            obs[0] = new Obstacle();

            obs[1] = new Obstacle();
            obs[1].image = ImageIO.read(getClass().getResourceAsStream("res/rock.png"));
            obs[1].collision = true;

            obs[2] = new Obstacle();
            obs[2].image = ImageIO.read(getClass().getResourceAsStream("res/ball+5.png"));
            obs[2].powerUp = true;

            obs[3] = new Obstacle();
            obs[3].image = ImageIO.read(getClass().getResourceAsStream("res/ball+15.png"));
            obs[2].powerUp = true;

            obs[4] = new Obstacle();
            obs[4].image = ImageIO.read(getClass().getResourceAsStream("res/ball-15.png"));
            obs[2].powerUp = true;

            obs[5] = new Obstacle();
            obs[5].image = ImageIO.read(getClass().getResourceAsStream("res/ballx10.png"));
            obs[2].powerUp = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {

        RandomObs t_rand = new RandomObs();

        int col = 5;
        int x = 60 * col;
        int y = 60 * row;

        if (!are_random) {
            are_random = true;
            r_obs = t_rand.rand_all_ob();
        }

        while (col < 11 && row < 10) {

            g.drawImage(obs[r_obs[col - 5]].image, x, y, 60, 60, null);
            col++;
            x += 60;
            /*
             * if (col == 11 && !second_rand) {
             * col = 5;
             * x = 60 * col;
             * row += 2;
             * y = 60 * row;
             * second_rand = true;
             * r_obs = t_rand.rand_all_ob();
             * }
             */
        }
    }
}
