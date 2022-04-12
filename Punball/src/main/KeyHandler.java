package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean leftPress, rightPress;
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int temp = e.getKeyCode();

        if(temp == KeyEvent.VK_A) {
            leftPress = true;
        }
        if(temp == KeyEvent.VK_D) {
            rightPress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int temp = e.getKeyCode();
        
        if(temp == KeyEvent.VK_A) {
            leftPress = false;
        }
        if(temp == KeyEvent.VK_D) {
            rightPress = false;
        }
    }
    
}
