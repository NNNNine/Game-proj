package entity;

import java.awt.Rectangle;

public abstract class Entity {
    public int x, y, height, width;
    protected int hpLevel = 1000;
    protected int maxHP = 1000;
    private int attack;

    public abstract Rectangle getBound();

    public void setHP(int hpLevel){
        // if (hpLevel>0 ){
            this.hpLevel =  hpLevel;
            this.maxHP =  hpLevel;
        // }else{
            
        //     System.out.println("Dead end??? must reset new game");

        // }
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

    public double calculateBarHP(int attack){
        int hp = getHP();
        double ans = (((hp)/ (double) getMaxHP())*100);
        return ans;
    }

    public void setAttack(int attack){
        this.attack= attack;
    }

    public int getAttack(){
            return this.attack;
        
    }
    
}
