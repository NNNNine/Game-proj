package entity;

import java.awt.Rectangle;

public abstract class Entity {
    public int x, y, height, width;
    protected int hpLevel = 1000;
    protected int maxHP = 1000;

    public abstract Rectangle getBound();

    public void setHP(int hpLevel){
        this.hpLevel =  hpLevel;
        this.maxHP =  hpLevel;
    }

    public int getMaxHP(){
        return maxHP;
    }

    public int getHP(){
        return this.hpLevel;
    }

    public  void increaseHP(int heal){
        this.hpLevel += heal;
    }

    public boolean decreaseHP(int attack){
        this.hpLevel -= attack;
        return true;
    }
}
