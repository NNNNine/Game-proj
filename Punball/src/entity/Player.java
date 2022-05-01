package entity;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.Game;
import main.KeyHandler;
import main.ID;

public class Player extends Entity {

    public int playerSpeed;
    private int x, y;
    public BufferedImage left1, left2, right1, right2, stand;
    public String dir;
    public int animation = 1, ani_co = 0;

    KeyHandler keyH;
    Game game;

    JProgressBar playerHealthBar;

    public Player(Game g, KeyHandler k) {
        // super(480, 665, ID.Player);
        setDefaultLocation();
        game = g;
        this.keyH = k;
        dir = "stand";

        playerHealthBar = new JProgressBar();
        playerHealthBar.setValue(100);
        playerHealthBar.setStringPainted(true);
        playerHealthBar.setBounds(300, 725, 360, 30);
        playerHealthBar.setForeground(Color.red);
        playerHealthBar.setBackground(Color.white);

        getPlayer();
    }

    // Overloaded constructor for upgrade screen
    public Player(Game g, KeyHandler k, int hpLevel, int attack) {
        // super(480, 665, ID.Player);
        setDefaultLocation();
        game = g;
        this.keyH = k;
        dir = "stand";

        setHP(hpLevel);
        setAttack(attack);

        playerHealthBar = new JProgressBar();
        playerHealthBar.setValue(100);
        playerHealthBar.setStringPainted(true);
        playerHealthBar.setBounds(300, 725, 360, 30);
        playerHealthBar.setForeground(Color.red);
        playerHealthBar.setBackground(Color.white);

        getPlayer();
    }

    public void setDefaultLocation() {
        this.x = 480;
        this.y = 665;
        playerSpeed = 3;
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

    // @Override
    public void update() {
        if (keyH.leftPress == true) {
            if (x > 300) {
                dir = "left";
                this.x -= playerSpeed;
            }
        } else if (keyH.rightPress == true) {
            if (x < 660 - 40) {
                dir = "right";
                this.x += playerSpeed;
            }
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

    public Rectangle getBound() {
        return new Rectangle(x, y, 30, 47);
    }

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