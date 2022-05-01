package entity;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import java.lang.Math;
import javax.swing.*;

import main.Game;
import main.ID;

public class Ball implements MouseListener,ActionListener{
    public int ball_ammo;
    public double x, y; 
    public int width, height;
    public int xTarget;
    public int yTarget;
    public double xVelocity, yVelocity;
    private Timer timer;
    private Player player;
    private boolean isBallOut;

    public Ball(int x, int y, Game game, Player player) {
        this.x = x;
        this.y = y;
        width = 20;
        height = 20;
        this.player = player;
        isBallOut = false;
        game.addMouseListener(this);
        timer = new Timer(10, this);  //หน่วย milliSec 1000=1sec
        
    }

    public void update() {

    }

    public void draw(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.RED);
        g2.fillOval((int) x+15, (int) y-20, width, height);
    }

    public Rectangle getBound() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public void ballMove(int x, int y){
        if(! isBallOut ){
            this.x = x;
            this.y = y;
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        xTarget = e.getX();
        yTarget = e.getY();
        double deltaX = xTarget - x;
        double deltaY = yTarget - y;
        double angle = Math.atan2(deltaY, deltaX);
        xVelocity = 10 * Math.cos(angle);
        yVelocity = 10 * Math.sin(angle);
        timer.start();
        isBallOut = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= 660 - 20 || x < 300) {
            xVelocity *= -1; //ทำให้บอลเด้งกลับในแกนx 
        }
        x += xVelocity;

       //draw(g2); 

        if (y >=  780-20 || y < 180) {
            yVelocity *= -1; //ทำให้บอลเด้งกลับในแกนy
        }
        y += yVelocity;

        if (y > 720){
            timer.stop();
            isBallOut = false;
            x = player.getX();
            y = player.getY();        
        }

        //draw(g2);
        
    }

}
