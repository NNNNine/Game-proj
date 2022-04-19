package Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoseScreen extends JPanel implements ActionListener {
    private final int PANEL_WIDTH = 960;
    private final int PANEL_HEIGHT = 780;
    JButton buttonTryAgain;
    JButton buttonQuit;

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public LoseScreen(CardLayout cardLayout, JPanel mainPanel) {

        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        this.setLayout(null);

        JLabel screenImage = new JLabel();
        screenImage.setIcon(new ImageIcon("imgs/LoseScreen.gif"));
        screenImage.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        Icon iconTryAgain = new ImageIcon("imgs/TryAgainButton.png");
        buttonTryAgain = new JButton(iconTryAgain);
        buttonTryAgain.setBounds(328, 395, 300, 95);
        buttonTryAgain.addActionListener(this);

        Icon iconQuit = new ImageIcon("imgs/QuitButton.png");
        buttonQuit = new JButton(iconQuit);
        buttonQuit.setBounds(328, 500, 300, 95);
        buttonQuit.addActionListener(this);
        
        this.add(buttonTryAgain);
        this.add(buttonQuit);
        this.add(screenImage);
        
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonTryAgain) {
            cardLayout.show(mainPanel, "gameScreen");
        }

        if (e.getSource() == buttonQuit) {
            cardLayout.show(mainPanel, "titleScreen");
        }
    }

}