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

        JPanel mainPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        mainPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        mainPanel.setLayout(cardLayout);
        Game game = new Game(cardLayout, mainPanel);
        mainPanel.add(new TitleScreen(cardLayout, mainPanel), "titleScreen");
        mainPanel.add(new UpgradeScreen(cardLayout, mainPanel,game.getPlayer()), "upgradeScreen");
        mainPanel.add(game, "gameScreen");
        mainPanel.add(new WinScreen(cardLayout, mainPanel),"winScreen");
        mainPanel.add(new LoseScreen(cardLayout, mainPanel),"loseScreen");

        screen.add(mainPanel);
        screen.setVisible(true);
        screen.pack();
        screen.setLocationRelativeTo(null);

        game.startGameThread();
    }
}
