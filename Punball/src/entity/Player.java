package entity;

import main.KeyHandler;

public class Player {
    public int x, y;
    public final int playerSpeed;

    public Player() {
        x = 480;
        y = 690;
        playerSpeed = 10;
    }

    public void update(KeyHandler KeyH) {
        if(KeyH.leftPress == true) {
            x -= playerSpeed;
        }
        else if(KeyH.rightPress == true) {
            x += playerSpeed;
        }
    }
}