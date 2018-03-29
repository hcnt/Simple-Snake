import javax.swing.*;
import java.awt.*;

public class GameoverScreen extends Scene {
    private JLabel text = new JLabel("you have lost, press space to start again");
    private GameStartedListener gameListener = new GameStartedListener();

    @Override
    public void runScene() {
        super.runScene();
        Game.window.frame.addKeyListener(gameListener);
        Game.window.frame.setVisible(true);
        Game.window.frame.repaint();
        while (running) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
