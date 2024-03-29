package Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import main.KeyHandler;
import main.Game;

public class WinScreen extends JPanel implements ActionListener {
    private final int PANEL_WIDTH = 960;
    private final int PANEL_HEIGHT = 780;

    JButton buttonNext;
    JButton buttonQuit;

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Game game;
    private KeyHandler keyH;

    public WinScreen(CardLayout cardLayout, JPanel mainPanel, Game game, KeyHandler keyH) {

        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.game = game;
        this.keyH = keyH;
        this.setLayout(null);

        JLabel screenImage = new JLabel();
        screenImage.setIcon(new ImageIcon("imgs/WinScreen.gif"));
        screenImage.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        Icon iconStart = new ImageIcon("imgs/NextButton.png");
        buttonNext = new JButton(iconStart);
        buttonNext.setBounds(328, 430, 300, 95);
        buttonNext.setOpaque(false);
        buttonNext.setBorderPainted(false);
        buttonNext.setContentAreaFilled(false);
        buttonNext.addActionListener(this);

        Icon iconQuit = new ImageIcon("imgs/QuitButton.png");
        buttonQuit = new JButton(iconQuit);
        buttonQuit.setBounds(328, 540, 300, 95);
        buttonQuit.setOpaque(false);
        buttonQuit.setBorderPainted(false);
        buttonQuit.setContentAreaFilled(false);
        buttonQuit.addActionListener(this);

        this.add(buttonNext);
        this.add(buttonQuit);
        this.add(screenImage);

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNext) {
            cardLayout.show(mainPanel, "gameScreen");
            int hpLevel = game.getPlayer().getMaxHP();
            int attack = game.getPlayer().getAttack();
            System.out.println(hpLevel);
            game.restartGame(cardLayout, mainPanel, keyH, hpLevel, attack);
        }

        if (e.getSource() == buttonQuit) {
            cardLayout.show(mainPanel, "titleScreen");
        }

    }

}