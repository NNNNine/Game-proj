package entity;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;

public class Enemy extends Entity{
    public int health;
    private Image image;
    public String chooseEnemy;

    public static String[] allEnemy = {
        "imgs/monsterYellow.png", "imgs/monsterPurple.png", "imgs/monsterBlue.png","imgs/monsterGreen.png","imgs/monsterPink.png"
    };

    public Enemy() {
        Random r = new Random();
        int temp_h = r.nextInt(10);
        health = temp_h * 1000;

        int temp_enemy = r.nextInt(5);
        chooseEnemy = allEnemy[temp_enemy];

        x = 440;
        y = 270;
    }

    public void update() {

    }

    // public void loadImage(){
    //     image = new ImageIcon("imgs/monsterYellow.png").getImage();
    //     JPanel panel = new JPanel();
    //     panel.setPreferredSize(new DimensionUIResource(100, 100));
    // }

    public void draw(Graphics2D g2) {
        image = new ImageIcon(chooseEnemy).getImage();
        g2.drawImage(image, x, y, null);
        // g2.setColor(Color.red);
        // g2.fillRect(x, y, 120, 120);
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, 120, 120);
    }
}
