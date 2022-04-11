import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
    private boolean play = false;
    private int score = 0;

    private int totalBrick = 18;
    private Timer timer;
    private int delay = 8;

    private int playerX = 170;

    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    public Gameplay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){
        //background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 452, 760);

        //borders
        g.setColor(Color.white);
        g.fillRect(0, 0, 3, 760);
        g.fillRect(0, 0, 452, 3);
        g.fillRect(443, 0, 3, 760);

        //the paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 700, 100, 8);

        //the ball
        g.setColor(Color.yellow);
        g.fillRect(ballPosX, ballPosY, 20, 20);
    
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        repaint();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(playerX >= 352) {
                playerX = 352;
            }
            else {
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(playerX <= 0) {
                playerX = 0;
            }
            else {
                moveLeft();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void moveRight() {
        timer.start();
        playerX += 20;
    }
    public void moveLeft() {
        timer.start();
        playerX -= 20;
    }
}