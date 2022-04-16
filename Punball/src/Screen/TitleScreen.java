package Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleScreen extends JPanel implements ActionListener {
    private final int PANEL_WIDTH = 960;
    private final int PANEL_HEIGHT = 780;
    JButton buttonStart;
    JButton buttonUpgrade;

    private CardLayout cardLayout;
    private JPanel mainPanel;

    // CardLayout cardLayout;

    public TitleScreen(CardLayout cardLayout, JPanel mainPanel) {

        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        this.setLayout(null);

        JLabel screenImage = new JLabel();
        screenImage.setIcon(new ImageIcon("imgs/punballscreen.png"));
        screenImage.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        Icon iconStart = new ImageIcon("imgs/StartButton.png");
        buttonStart = new JButton(iconStart);
        buttonStart.setBounds(328, 395, 300, 95);
        buttonStart.addActionListener(this);

        Icon iconUpgrade = new ImageIcon("imgs/UpgradeButton.png");
        buttonUpgrade = new JButton(iconUpgrade);
        buttonUpgrade.setBounds(328, 500, 300, 95);
        buttonUpgrade.addActionListener(this);

        // mainPanel = new JPanel();
        // mainPanel.setLayout(cardLayout);
        // mainPanel.setBounds(0,0,PANEL_WIDTH,PANEL_HEIGHT);
        // mainPanel.add(Game,"game");
        // mainPanel.add(UpgradeScreen,"upgradeScreen");

        this.add(buttonStart);
        this.add(buttonUpgrade);
        this.add(screenImage);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonStart) {
            cardLayout.show(mainPanel, "gameScreen");
            System.out.println("Clicked start yay");

        }

        if (e.getSource() == buttonUpgrade) {
            cardLayout.show(mainPanel, "upgradeScreen");
            System.out.println("Clicked upgrade yay");
        }

    }

}