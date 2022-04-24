package entity;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Handler;

import main.Game;
import main.KeyHandler;
import main.ObjectHandler;
import main.GameObject;
import main.ID;

public class Player extends Entity {

    public final int playerSpeed;
    public BufferedImage left1, left2, right1, right2, stand;
    public String dir;
    public int animation = 1, ani_co = 0;

    ObjectHandler handler;
    KeyHandler keyH;
    Game game;
    // MouseClick mC;

    JProgressBar playerHealthBar;

    public Player(Game g, KeyHandler k, ObjectHandler handler) {
        super(480, 665, ID.Player);
        x = 480;
        y = 665;
        this.handler = handler;
        playerSpeed = 3;
        game = g;
        keyH = k;
        // this.mC = mC;
        dir = "stand";

        playerHealthBar = new JProgressBar();
        playerHealthBar.setValue(100);
        playerHealthBar.setStringPainted(true);
        // playerHealthBar.setString(String.valueOf(super.getHP()));
        playerHealthBar.setBounds(300, 725, 360, 30);
        playerHealthBar.setForeground(Color.red);
        playerHealthBar.setBackground(Color.white);

        getPlayer();
    }

    // Overloaded constructor for upgrade screen
    public Player(Game g, KeyHandler k, ObjectHandler handler, int hpLevel, int attack) {
        super(480, 665, ID.Player);
        x = 480;
        y = 665;
        this.handler = handler;
        playerSpeed = 3;
        game = g;
        keyH = k;
        // this.mC = mC;
        dir = "stand";

        setHP(hpLevel);
        setAttack(attack);

        playerHealthBar = new JProgressBar();
        playerHealthBar.setValue(100);
        playerHealthBar.setStringPainted(true);
        // playerHealthBar.setString(String.valueOf(super.getHP()));
        playerHealthBar.setBounds(300, 725, 360, 30);
        playerHealthBar.setForeground(Color.red);
        playerHealthBar.setBackground(Color.white);

        getPlayer();
    }

    public JProgressBar getPlayerHealthBar() {
        return playerHealthBar;
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

    @Override
    public void update() {

        // collision();

        if (keyH.leftPress == true) {
            dir = "left";
            x -= playerSpeed;
            /*
             * if (x < 300) {
             * x = 300;
             * }
             */
        } else if (keyH.rightPress == true) {
            dir = "right";
            x += playerSpeed;
            /*
             * if (x > 620) {
             * x = 620;
             * }
             */
        } else if (keyH.notPress == true) {
            dir = "stand";
        }

        ani_co++;
        if (ani_co > 10) {
            if (animation == 1) {
                animation = 2;
            } else if (animation == 2) {
                animation = 1;
            }

            ani_co = 0;
        }
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getID() == ID.Map) {
                if (getBound().intersects(tempObject.getBound())) {
                    x += playerSpeed * -1;
                    y += playerSpeed * -1;
                }
            }
        }
    }

    @Override
    public boolean decreaseHP(int attack) {
        hpLevel -= attack;
        playerHealthBar.setValue((int) super.calculateBarHP(attack));
        playerHealthBar.setString(String.valueOf(super.getHP()));
        if (super.getHP() <= 0) {
            // this.hpLevel=super.maxHP;
            return false;
        }
        return true;
    }

    @Override
    public Rectangle getBound() {
        return new Rectangle(x, y, 30, 47);
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        BufferedImage image = null;

        switch (dir) {
            case "left":
                if (animation == 1) {
                    image = left1;
                }
                if (animation == 2) {
                    image = left2;
                }
                break;

            case "right":
                if (animation == 1) {
                    image = right1;
                }
                if (animation == 2) {
                    image = right2;
                }
                break;
            default:
                image = stand;
                break;
        }

        g2.drawImage(image, null, x, y);

    }
}