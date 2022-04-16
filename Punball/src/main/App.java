package main;

import Screen.TitleScreen;
import Screen.UpgradeScreen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App {

    public static void main(String[] args) throws Exception {
        final int PANEL_WIDTH = 960;
        final int PANEL_HEIGHT = 780;

        JFrame screen = new JFrame();
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setTitle("Punball");
        screen.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        mainPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        mainPanel.setLayout(cardLayout);
        mainPanel.add(new TitleScreen(cardLayout, mainPanel), "titleScreen");
        mainPanel.add(new UpgradeScreen(cardLayout, mainPanel), "upgradeScreen");
        Game game = new Game(cardLayout, mainPanel);
        mainPanel.add(game, "gameScreen");

        screen.add(mainPanel);
        screen.setVisible(true);
        screen.pack();

        game.startGameThread();
    }
}
