package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;

import main.Game;
import main.ID;

public class Ball implements MouseListener{
    public int ball_ammo;
    public int x, y, width, height;
    public int xTarget, yTarget;

    public Ball(int x, int y, Game game) {
        this.x = x;
        this.y = y;
        width = 20;
        height = 20;
        game.addMouseListener(this);
    }

    public void update() {

    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x+15, y-20, width, height);
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, width, height);
    }

    

    @Override
    public void mouseClicked(MouseEvent e) {
        xTarget =e.getX();
        yTarget =e.getY();
        System.out.println(xTarget);
        System.out.println(yTarget);
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

}
