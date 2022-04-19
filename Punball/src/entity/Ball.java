package entity;

public abstract class Ball {
    public int ball_ammo;
    private int attack;

    public Ball() {
        
    }

    public void setAttack(int attack){
        this.attack= attack;
    }

    public int getAttack(){
        if (this.attack == 0){
            return 200;
        }else{
            return this.attack;
        }
    }

}
