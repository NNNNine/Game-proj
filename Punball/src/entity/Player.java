package entity;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.Game;
import main.KeyHandler;
import main.MouseClick;

public class Player extends Entity{

    public final int playerSpeed;
    public BufferedImage left1, left2, right1, right2, stand;
    public String dir;
    public int animation = 1, ani_co = 0;

    KeyHandler keyH;
    Game game;
    MouseClick mC;

    public Player(Game g, KeyHandler k, MouseClick mC) {
        x = 480;
        y = 665;
        playerSpeed = 3;
        game = g;
        keyH = k;
        this.mC = mC;
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
            if(x < 300) {
                x = 300;
            }
        }
        else if(keyH.rightPress == true) {
            dir = "right";
            x += playerSpeed;
            if(x > 620) {
                x = 620;
            }
        }
        else if(keyH.notPress == true) {
            dir = "stand";
        }

        ani_co++;
        if(ani_co > 10) {
            if(animation == 1) {
                animation = 2;
            }
            else if(animation == 2) {
                animation = 1;
            }

            ani_co = 0;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (dir) {
            case "left":
                if(animation == 1 && !mC.clicked) {
                    image = left1;
                }
                if(animation == 2 && !mC.clicked) {
                    image = left2;
                }
                break;
            
            case "right":
                if(animation == 1 && !mC.clicked) {
                    image = right1;
                }
                if(animation == 2 && !mC.clicked) {
                    image = right2;
                }
                break;
            default:
                image = stand;
                break;
        }

        g2.drawImage(image, null, x, y);
        g2.setPaint(Color.red);
        g2.fillRect(300, 725, 360, 25);   
        g2.drawString(String.valueOf(super.getHP()), 350, 700);
    }

    @Override
    public void decreaseHP(int attack){
        this.hpLevel -= attack;
        
    }


    public float calculateBarHP(int attack){
        super.decreaseHP(attack);
        int hp = super.getHP();
        float ans = 360 - (((hp-attack)/ (float) maxHP)*360);
        return ans;
    }

    @Override
    public Rectangle getBound() {
        return new Rectangle(10, 1, 30, 47);
    }
}