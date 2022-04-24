package main;

import java.awt.Graphics;
import java.util.LinkedList;

import entity.Enemy;
import entity.Player;

public class ObjectHandler {

    public LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void update() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.update();
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.draw(g);
        }
    }

    public void addObject(GameObject tempObject) {
        objects.add(tempObject);
    }

    public void removeObject(GameObject tempObject) {
        objects.remove(tempObject);
    }
    /*
     * public GameObject getObject(String s) {
     * for (int i = 0; i < objects.size(); i++) {
     * GameObject tempObject = objects.get(i);
     * 
     * if (s.equals("Player")) {
     * if (tempObject.getID() == ID.Player) {
     * return tempObject;
     * }
     * } else if (s.equals("Enemy")) {
     * if (tempObject.getID() == ID.Enemy) {
     * return tempObject;
     * }
     * }
     * }
     * }
     */

}
