import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Game {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    public static final long DELTA_T_IN_MINISECONDS = 9;
    public static final int NUMBER_OF_ITEMS = 3;

    public static void main(String[] args) {
        Level1 level1 = new Level1();
        level1.runGame();
    }
}