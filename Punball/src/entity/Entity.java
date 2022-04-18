package entity;

import java.awt.Rectangle;

public abstract class Entity {
    public int x, y, height, width;
    protected int hpLevel;

    public abstract Rectangle getBound();

    public void showHP(){

    }

    public void setHP(int hpLevel){
        this.hpLevel =  hpLevel;
    }

    public int getHP(){
        return this.getHP();
    }

    public  void increaseHP(){

    }

    public void decreaseHP(int attack){
        this.hpLevel -= attack;
    }
}
