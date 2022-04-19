package entity;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Enemy extends Entity {
    private int health;
    private Image image;
    public String chooseEnemy;

    public static String[] allEnemy = {
            "imgs/monsterYellows.png", "imgs/monsterReds.png", "imgs/monsterBlues.png", "imgs/monsterGreens.png",
            "imgs/monsterSkys.png"
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

    public int getHealth(){
        return health;
    }

    public void draw(Graphics2D g2) {
        image = new ImageIcon(chooseEnemy).getImage();
        g2.drawImage(image, x, y, null);

        g2.setPaint(Color.DARK_GRAY);
        g2.fillRect(440, 245, 120, 15);   
        g2.drawString("Monster's HP : "+String.valueOf(health),440 , 235);
        // g2.setColor(Color.red);
        // g2.fillRect(x, y, 120, 120);
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, 120, 120);
    }
}
