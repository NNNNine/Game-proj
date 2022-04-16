package main;


import Screen.TitleScreen;
import Screen.UpgradeScreen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame screen = new JFrame();
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setTitle("Punball");

        Game game = new Game();
        screen.add(game);

        // TitleScreen titleScreen = new TitleScreen();
        // screen.add(titleScreen);

        UpgradeScreen upgradeScreen = new UpgradeScreen();
        screen.add(upgradeScreen);
        screen.pack();

        screen.setLocationRelativeTo(null);
        screen.setVisible(true);

        game.startGameThread();
    }
}
