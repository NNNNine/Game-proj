package entity;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Enemy extends Entity {
    private int health;
    // private int maxHealth;
    private Image image;
    public String chooseEnemy;

    private JProgressBar enemyHealthBar;

    public static String[] allEnemy = {
            "imgs/monsterYellows.png", "imgs/monsterReds.png", "imgs/monsterBlues.png", "imgs/monsterGreens.png",
            "imgs/monsterSkys.png"
    };

    public Enemy() {
        Random r = new Random();
        int temp_h = r.nextInt(10);
        health = temp_h * 5000;
        super.setHP(health);

        int temp_enemy = r.nextInt(5);
        chooseEnemy = allEnemy[temp_enemy];

        x = 440;
        y = 270;

        enemyHealthBar = new JProgressBar();
        enemyHealthBar.setValue(100);
        enemyHealthBar.setStringPainted(true);
        // enemyHealthBar.setString(String.valueOf(getHealth()));
        enemyHealthBar.setBounds(440, 245, 120, 15);
        enemyHealthBar.setForeground(Color.red);
        enemyHealthBar.setBackground(Color.white);
    }

    public JProgressBar getEnemyHealthBar(){
        return enemyHealthBar;
    }

    public void update() {

    }

    // public int getHealth(){
    //     return health;
    // }

    @Override
    public boolean decreaseHP(int attack){
        this.setHP(hpLevel-attack) ;
        enemyHealthBar.setValue((int) super.calculateBarHP(attack));
        enemyHealthBar.setString(String.valueOf(super.getHP()));
        if (super.getHP() <= 0){
            // this.hpLevel=super.maxHP;
            return false;
        }
        return true;
    }



    public void draw(Graphics2D g2) {
        image = new ImageIcon(chooseEnemy).getImage();
        g2.drawImage(image, x, y, null);

        // g2.setPaint(Color.DARK_GRAY);
        // g2.fillRect(440, 245, 120, 15);   
        // g2.drawString("Monster's HP : "+String.valueOf(health),440 , 235);
        // g2.setColor(Color.red);
        // g2.fillRect(x, y, 120, 120);
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, 120, 120);
    }
}
