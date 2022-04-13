package entity;

import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.Game;
import main.KeyHandler;

public class Player {
    public int x, y;
    public final int playerSpeed;
    public BufferedImage left1, left2, right1, right2, stand;
    public String dir;

    KeyHandler keyH;
    Game game;

    public Player(Game g, KeyHandler k) {
        x = 480;
        y = 665;
        playerSpeed = 6;
        game = g;
        keyH = k;
        dir = "stand";

        getPlayer();
    }

    public void getPlayer() {
        try {
            left1 = ImageIO.read(getClass().getResourceAsStream("res/player_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("res/player_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("res/player_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("res/player_right_2.png"));
            stand = ImageIO.read(getClass().getResourceAsStream("res/player_stand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.leftPress == true) {
            dir = "left";
            x -= playerSpeed;
        }
        else if(keyH.rightPress == true) {
            dir = "right";
            x += playerSpeed;
        }
    }

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.black);
        //g2.fillOval(x, y, 50, 47);
        BufferedImage image = null;

        switch (dir) {
            case "left":
                image = left1;
                break;
            
            case "right":
                image = right1;
                break;
            default:
                image = stand;
                break;
        }

        g2.drawImage(image, null, x, y);
    }
}