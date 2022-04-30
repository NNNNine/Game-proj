package entity;

import java.awt.Rectangle;
import main.ID;

public class Entity {
    public int x, y, height, width;
    protected int hpLevel = 1000;
    protected int maxHP = 1000;
    private int attack = 200;
    private ID id;

    public Entity() {

    }

    public Entity(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public void setHP(int hpLevel) {
        this.hpLevel = hpLevel;
        this.maxHP = hpLevel;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHP() {
        return this.hpLevel;
    }

    public void increaseHP(int heal) {
        this.hpLevel += heal;
    }

    public boolean decreaseHP(int attack) {
        this.hpLevel -= attack;
        return true;
    }

    public double calculateBarHP(int attack) {
        int hp = getHP();
        double ans = (((hp) / (double) getMaxHP()) * 100);
        return ans;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return this.attack;

    }
}
