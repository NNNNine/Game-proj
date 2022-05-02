package entity;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import java.lang.Math;
import javax.swing.*;

import main.Game;
import main.ID;

public class Ball implements MouseListener, ActionListener {
    public int ball_ammo;
    public double x, y;
    public int width, height;
    public int xTarget;
    public int yTarget;
    public double xVelocity, yVelocity;
    private Timer timer;
    private Player player;
    private Enemy enemy;
    private boolean isBallOut;
    Game g;

    public Ball(int x, int y, Game game, Player player, Enemy enemy) {
        this.x = x;
        this.y = y;
        width = 20;
        height = 20;
        this.player = player;
        this.enemy = enemy;
        isBallOut = false;
        this.g = game;
        game.addMouseListener(this);
        timer = new Timer(10, this); // หน่วย milliSec 1000=1sec
        ball_ammo = 5;
    }

    public void update() {

    }

    public void draw(Graphics g) {
        if (ball_ammo > 0) {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.RED);
            g2.fillOval((int) x + 15, (int) y - 20, width, height);
        }
    }

    public Rectangle getBound() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public void ballMove(int x, int y) {
        if (!isBallOut) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (ball_ammo != 0) {
            xTarget = e.getX();
            yTarget = e.getY();
            double deltaX = xTarget - x;
            double deltaY = yTarget - y;
            double angle = Math.atan2(deltaY, deltaX);
            xVelocity = 10 * Math.cos(angle);
            yVelocity = 10 * Math.sin(angle);
            timer.start();
            isBallOut = true;
            ball_ammo--;
        }

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

        // X
        if (x >= 660 - 20 || x < 300) {
            xVelocity *= -1; // ทำให้บอลเด้งกลับในแกนx
        }

        // Y
        if (y >= 780 - 20 || y < 180) {
            yVelocity *= -1; // ทำให้บอลเด้งกลับในแกนy
        }

        if (y > 720) {
            timer.stop();
            isBallOut = false;
            x = player.getX();
            y = player.getY();
            ball_ammo++;
        }

        if (getBound().intersects(enemy.getBound())) {
            if (!enemy.decreaseHP(player.getAttack())) {
                g.getCardLayout().show(g.getMainPanel(), "winScreen");
            }
            timer.stop();
            isBallOut = false;
            x = player.getX();
            y = player.getY();
        }

        for (int i = 0; i < 6; i++) {
            if (getBound().intersects(g.getObsdown().obs_bound.get(i).getBound())) {
                if (g.getObsdown().obs_bound.get(i).powerUp == true) {
                    if (g.getObsdown().obs_bound.get(i).power == 10) {
                        if (ball_ammo >= 0) {
                            ball_ammo *= 10;
                        } else
                            ball_ammo += 10;
                    } else
                        ball_ammo += g.getObsdown().obs_bound.get(i).power;
                }

                if (g.getObsdown().obs_bound.get(i).collision == true) {
                    if (g.getObsdown().obs_bound.get(i).getBound().y < this.y
                            || g.getObsdown().obs_bound.get(i).getBound().y > this.y) {
                        yVelocity *= -1;
                    }

                    if (g.getObsdown().obs_bound.get(i).getBound().x + 60 < this.x
                            || g.getObsdown().obs_bound.get(i).getBound().x > this.x) {
                        xVelocity *= -1;
                    }
                }
                break;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (getBound().intersects(g.getObsup().obs_bound.get(i).getBound())) {
                if (g.getObsup().obs_bound.get(i).powerUp == true) {
                    if (g.getObsup().obs_bound.get(i).power == 10) {
                        if (ball_ammo >= 0) {
                            ball_ammo *= 10;
                        } else
                            ball_ammo += 10;
                    } else
                        ball_ammo += g.getObsup().obs_bound.get(i).power;
                }

                if (g.getObsup().obs_bound.get(i).collision == true) {
                    if (g.getObsup().obs_bound.get(i).getBound().y < this.y
                            || g.getObsup().obs_bound.get(i).getBound().y > this.y) {
                        yVelocity *= -1;
                    }

                    if (g.getObsup().obs_bound.get(i).getBound().x + 60 < this.x
                            || g.getObsup().obs_bound.get(i).getBound().x > this.x) {
                        xVelocity *= -1;
                    }
                }
                break;
            }
        }
        x += xVelocity;
        y += yVelocity;
    }

}
