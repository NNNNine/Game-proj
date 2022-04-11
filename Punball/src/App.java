import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        Gameplay game = new Gameplay();

        frame.setBounds(500, 45, 460, 768);
        frame.setResizable(false);
        frame.setTitle("Punball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(game);
    }
}
