import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public abstract class Scene {
    protected boolean running;
    public static int activeScene = 0;

    public void runScene(){
        Game.window.frame.getContentPane().removeAll();
        running = true;
    }

    public abstract class DrawScene extends JPanel{
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
        }

    }
    public class GameStartedListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == 32) {
                Scene.activeScene = 1;
                running = false;
            }
        }
        public void keyReleased (KeyEvent e){}
        public void keyTyped (KeyEvent e){}
    }
    public BufferedImage loadImage(String file) {
        try {
            URL url = getClass().getResource(file);
            return ImageIO.read(url);
        } catch (IOException ex) {
            System.out.println("Image "+ file + " not found");
            return null;
        }
    }
}
