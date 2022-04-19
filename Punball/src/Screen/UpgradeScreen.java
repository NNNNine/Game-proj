package Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import entity.Player;

public class UpgradeScreen extends JPanel implements ActionListener {
    private final int PANEL_WIDTH = 960;
    private final int PANEL_HEIGHT = 780;
    JButton buttonStartUp;
    JButton damage200button;
    JButton damage400button;
    JButton damage600button;
    JButton damage800button;
    JButton damage1000button;
    JButton hp1000button;
    JButton hp4000button;
    JButton hp6000button;
    JButton hp8000button;
    JButton hp10000button;

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Player player;


    public UpgradeScreen(CardLayout cardLayout, JPanel mainPanel,Player player) {

        this.player = player;

        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        this.setLayout(null);

        JLabel screenImage = new JLabel();
        screenImage.setIcon(new ImageIcon("imgs/upgradescreenmoving.gif"));
        screenImage.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        Icon iconStart = new ImageIcon("imgs/StartButton.png");
        buttonStartUp = new JButton(iconStart);
        buttonStartUp.setBounds(328, 660, 300, 95);
        buttonStartUp.setOpaque(false);
        buttonStartUp.setBorderPainted(false);
        buttonStartUp.setContentAreaFilled(false);
        buttonStartUp.addActionListener(this);

        Icon iconDamage200 = new ImageIcon("imgs/damage200button.png");
        damage200button = new JButton(iconDamage200);
        damage200button.setBounds(50, 215, 150, 140);
        damage200button.addActionListener(this);

        Icon iconDamage400 = new ImageIcon("imgs/damage400button.png");
        damage400button = new JButton(iconDamage400);
        damage400button.setBounds(230, 215, 150, 140);
        damage400button.addActionListener(this);

        Icon iconDamage600 = new ImageIcon("imgs/damage600button.png");
        damage600button = new JButton(iconDamage600);
        damage600button.setBounds(410, 215, 150, 140);
        damage600button.addActionListener(this);

        Icon iconDamage800 = new ImageIcon("imgs/damage800button.png");
        damage800button = new JButton(iconDamage800);
        damage800button.setBounds(585, 215, 150, 140);
        damage800button.addActionListener(this);

        Icon iconDamage1000 = new ImageIcon("imgs/damage1000button.png");
        damage1000button = new JButton(iconDamage1000);
        damage1000button.setBounds(765, 215, 150, 140);
        damage1000button.addActionListener(this);

        Icon iconHp1000 = new ImageIcon("imgs/hp1000button.png");
        hp1000button = new JButton(iconHp1000);
        hp1000button.setBounds(50, 480, 150, 140);
        hp1000button.addActionListener(this);

        Icon iconHp4000 = new ImageIcon("imgs/hp4000button.png");
        hp4000button = new JButton(iconHp4000);
        hp4000button.setBounds(230, 480, 150, 140);
        hp4000button.addActionListener(this);

        Icon iconHp6000 = new ImageIcon("imgs/hp6000button.png");
        hp6000button = new JButton(iconHp6000);
        hp6000button.setBounds(410, 480, 150, 140);
        hp6000button.addActionListener(this);

        Icon iconHp8000 = new ImageIcon("imgs/hp8000button.png");
        hp8000button = new JButton(iconHp8000);
        hp8000button.setBounds(585, 480, 150, 140);
        hp8000button.addActionListener(this);

        Icon iconHp10000 = new ImageIcon("imgs/hp10000button.png");
        hp10000button = new JButton(iconHp10000);
        hp10000button.setBounds(765, 480, 150, 140);
        hp10000button.addActionListener(this);

        this.add(buttonStartUp);
        this.add(damage200button);
        this.add(damage400button);
        this.add(damage600button);
        this.add(damage800button);
        this.add(damage1000button);
        this.add(hp1000button);
        this.add(hp4000button);
        this.add(hp6000button);
        this.add(hp8000button);
        this.add(hp10000button);

        this.add(screenImage);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

    }

    public void resetDamageButton() {
        damage200button.setIcon(new ImageIcon("imgs/damage200button.png"));
        damage400button.setIcon(new ImageIcon("imgs/damage400button.png"));
        damage600button.setIcon(new ImageIcon("imgs/damage600button.png"));
        damage800button.setIcon(new ImageIcon("imgs/damage800button.png"));
        damage1000button.setIcon(new ImageIcon("imgs/damage1000button.png"));
    }

    public void resetHpButton() {
        hp1000button.setIcon(new ImageIcon("imgs/hp1000button.png"));
        hp4000button.setIcon(new ImageIcon("imgs/hp4000button.png"));
        hp6000button.setIcon(new ImageIcon("imgs/hp6000button.png"));
        hp8000button.setIcon(new ImageIcon("imgs/hp8000button.png"));
        hp10000button.setIcon(new ImageIcon("imgs/hp10000button.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonStartUp) {
            cardLayout.show(mainPanel,"gameScreen");

        }

        else if (e.getSource() == hp1000button || e.getSource() == hp4000button || e.getSource() == hp6000button
                || e.getSource() == hp8000button || e.getSource() == hp10000button) {
            resetHpButton();
            if (e.getSource() == hp1000button) {
                hp1000button.setIcon(new ImageIcon("imgs/usedHp1000button.png"));
                player.setHP(1000);
            } else if (e.getSource() == hp4000button) {
                hp4000button.setIcon(new ImageIcon("imgs/usedHp4000button.png"));
                player.setHP(4000);

            } else if (e.getSource() == hp6000button) {
                hp6000button.setIcon(new ImageIcon("imgs/usedHp6000button.png"));
                player.setHP(6000);

            } else if (e.getSource() == hp8000button) {
                hp8000button.setIcon(new ImageIcon("imgs/usedHp8000button.png"));
                player.setHP(8000);

            } else if (e.getSource() == hp10000button) {
                hp10000button.setIcon(new ImageIcon("imgs/usedHp10000button.png"));
                player.setHP(10000);

            }
        } else if (e.getSource() == damage200button || e.getSource() == damage400button
                || e.getSource() == damage600button || e.getSource() == damage800button
                || e.getSource() == damage1000button) {

            resetDamageButton();

            if (e.getSource() == damage200button) {
                damage200button.setIcon(new ImageIcon("imgs/usedDamage200button.png"));
                
            } else if (e.getSource() == damage400button) {
                damage400button.setIcon(new ImageIcon("imgs/usedDamage400button.png"));

            } else if (e.getSource() == damage600button) {
                damage600button.setIcon(new ImageIcon("imgs/usedDamage600button.png"));

            } else if (e.getSource() == damage800button) {
                damage800button.setIcon(new ImageIcon("imgs/usedDamage800button.png"));

            } else if (e.getSource() == damage1000button) {
                damage1000button.setIcon(new ImageIcon("imgs/usedDamage1000button.png"));

            }
        }

    }

}
