package entity;

import java.awt.Rectangle;

public abstract class Entity {
    public int x, y, height, width;
    protected int hpLevel;
    protected int maxHP;

    public abstract Rectangle getBound();

    public void setHP(int hpLevel){
        this.hpLevel =  hpLevel;
        this.maxHP =  hpLevel;
    }

    public int getMaxHP(){
        return maxHP;
    }

    public int getHP(){
        return hpLevel;
    }

    public  void increaseHP(int heal){
        this.hpLevel += heal;
    }

    public void decreaseHP(int attack){
        this.hpLevel -= attack;
    }
}
