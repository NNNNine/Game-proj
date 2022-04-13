package entity;

import java.awt.*;

import main.Game;
import main.KeyHandler;

public class Player {
    public int x, y;
    public final int playerSpeed;

    KeyHandler keyH;
    Game game;

    public Player(Game g, KeyHandler k) {
        x = 480;
        y = 690;
        playerSpeed = 6;
        game = g;
        keyH = k;
    }

    public void update() {
        if(keyH.leftPress == true) {
            x -= playerSpeed;
        }
        else if(keyH.rightPress == true) {
            x += playerSpeed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillOval(x, y, 20, 20);
    }
}