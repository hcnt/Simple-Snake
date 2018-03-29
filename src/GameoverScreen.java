import javax.swing.*;

public class GameoverScreen extends Scene {
    private JLabel text = new JLabel("you have lost, press space to start again");
    private GameStartedListener gameListener = new GameStartedListener();

    @Override
    public void runScene() {
        super.runScene();
        Game.window.frame.getContentPane().add(text);
        Game.window.frame.addKeyListener(gameListener);
        Game.window.frame.setVisible(true);
        while (running) {
            Game.window.frame.repaint();
        }
    }
}
