import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public abstract class Scene {
    protected Window window;
    protected boolean running;

    public BufferedImage loadImage(String file) {
        try {
            URL url = getClass().getResource(file);
            return ImageIO.read(url);
        } catch (IOException ex) {
            System.out.println("Image "+ file + " not found");
            return null;
        }
    }

    public class GameStartedAgainListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == 32) {
            }
        }
        public void keyReleased(KeyEvent e){}
        public void keyTyped(KeyEvent e) { }
    }
}
