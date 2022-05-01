package map;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import main.Game;

public class ObstacleManager {

    Game g;
    Obstacle[] obs;

    public ObstacleManager(Game g) {
        this.g = g;

        obs = new Obstacle[6];

        getObsImage();
    }

    public void getObsImage() {
        try {
            obs[0] = new Obstacle();

            obs[1] = new Obstacle();
            obs[1].image = ImageIO.read(getClass().getResourceAsStream("res/rock.png"));

            obs[2] = new Obstacle();
            obs[2].image = ImageIO.read(getClass().getResourceAsStream("res/ball+5.png"));

            obs[3] = new Obstacle();
            obs[3].image = ImageIO.read(getClass().getResourceAsStream("res/ball+15.png"));

            obs[4] = new Obstacle();
            obs[4].image = ImageIO.read(getClass().getResourceAsStream("res/ball-15.png"));

            obs[5] = new Obstacle();
            obs[5].image = ImageIO.read(getClass().getResourceAsStream("res/ballx10.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        RandomObs t_rand = new RandomObs();

        int col = 5;
        int row = 7;
        int x = 60 * col;
        int y = 60 * row;
        int[] r_obs = t_rand.rand_all_ob();

        while (col < 11 && row < 10) {

            g.drawImage(obs[r_obs[col - 5]].image, x, y, 60, 60, null);
            col++;
            x += 60;

            if (col == 11) {
                col = 5;
                x = 60 * col;
                row += 2;
                y = 60 * row;
                r_obs = t_rand.rand_all_ob();
            }
        }
    }
}
