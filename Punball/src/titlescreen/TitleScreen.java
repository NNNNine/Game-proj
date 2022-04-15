package titlescreen;

import java.awt.*;

import javax.swing.*;

public class TitleScreen extends JPanel{
    private final int PANEL_WIDTH = 960;
    private final int PANEL_HEIGHT = 780;

    public TitleScreen(){

        this.setLayout(null);

        JLabel screenImage = new JLabel();
        screenImage.setIcon(new ImageIcon("imgs/punballscreen.png"));
        screenImage.setBounds(0,0,PANEL_WIDTH,PANEL_HEIGHT);

        Icon iconStart = new ImageIcon("imgs/StartButton.png");
        JButton buttonStart = new JButton(iconStart);
        buttonStart.setBounds(328, 395, 300, 95);

        Icon iconUpgrade = new ImageIcon("imgs/UpgradeButton.png");
        JButton buttonUpgrade = new JButton(iconUpgrade);
        buttonUpgrade.setBounds(328, 510, 300, 95);


        


        
        this.add(buttonStart);
        this.add(buttonUpgrade);
        this.add(screenImage);
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));


    }
    
}