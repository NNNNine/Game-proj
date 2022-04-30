package main;

import Screen.LoseScreen;
import Screen.TitleScreen;
import Screen.UpgradeScreen;
import Screen.WinScreen;

import java.awt.*;
import javax.swing.*;

public class App {

    public static void main(String[] args) throws Exception {

        final int PANEL_WIDTH = 960;
        final int PANEL_HEIGHT = 780;
        JFrame screen = new JFrame();
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setTitle("Punball");

        KeyHandler KeyH = new KeyHandler();
        JPanel mainPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();

        mainPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        mainPanel.setLayout(cardLayout);

        Game game = new Game(cardLayout, mainPanel, KeyH);

        mainPanel.add(new TitleScreen(cardLayout, mainPanel, game, KeyH), "titleScreen");
        mainPanel.add(new UpgradeScreen(cardLayout, mainPanel, game.getPlayer(), game, KeyH), "upgradeScreen");
        mainPanel.add(game, "gameScreen");
        mainPanel.add(new WinScreen(cardLayout, mainPanel, game, KeyH), "winScreen");
        mainPanel.add(new LoseScreen(cardLayout, mainPanel, game, KeyH), "loseScreen");

        screen.add(mainPanel);
        screen.setVisible(true);
        screen.pack();
        screen.setLocationRelativeTo(null);

        game.startGameThread();
    }

}
