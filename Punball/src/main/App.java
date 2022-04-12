package main;

import javax.swing.JFrame;
public class App {
    public static void main(String[] args) throws Exception {
        JFrame screen = new JFrame();
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setTitle("Punball");
        
        Game game = new Game();
        screen.add(game);

        screen.pack();

        screen.setLocationRelativeTo(null);
        screen.setVisible(true);

        game.startGameThread();
    }
}
