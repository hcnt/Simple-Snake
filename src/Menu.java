import javax.swing.*;
import java.awt.*;

public class Menu extends Scene {
    private JPanel panel = new JPanel();
    private JLabel text = new JLabel("<html><center>welcome to Simple Snake, press space to start</html></center>");
    private GameStartedListener gameListener = new GameStartedListener();

    @Override
    public void runScene() {
        super.runScene();

        Game.window.frame.addKeyListener(gameListener);
        Game.window.frame.getContentPane().add(panel);
        panel.setLayout(new GridBagLayout());
        panel.add(text);
        panel.setBackground(Color.PINK);
        Game.window.frame.setVisible(true);
        while (running) {
            Game.window.frame.repaint();
        }
    }
}
