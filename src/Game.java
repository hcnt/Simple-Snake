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
    public final long DELTA_T_IN_MINISECONDS = 9;
    public final int NUMBER_OF_ITEMS = 3;

    private Snake snake;
    private Window window;
    private ArrayList<ItemComponent> items;
    BufferedImage leszcz;
    BufferedImage wudeczka;
    GameStartedAgainListener gameStartedAgain = new GameStartedAgainListener();
    private boolean running = true;

    DrawGame drawGame = new DrawGame();

    public BufferedImage loadImage(String file) {
        try {
            URL url = getClass().getResource(file);
            return ImageIO.read(url);
        } catch (IOException ex) {
            System.out.println("Image "+ file + " not found");
            return null;
        }
    }
    class GameStartedAgainListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == 32){

            }
        }
        public void keyReleased(KeyEvent e){}
        public void keyTyped(KeyEvent e) { }

    }
    private boolean isGameLost(Snake snake){
        return snake.wallColisionCheckUpdate();
    }

    public void runGame() {

        leszcz = loadImage("leszcz.png");
        wudeczka = loadImage("wudeczka.png");
        window = new Window(HEIGHT, WIDTH);
        snake = new Snake();
        items = new ArrayList<>();
        drawGame.setLayout(null);

        for(int i =0; i<NUMBER_OF_ITEMS;i++) {
            ItemComponent.addItemComponent(items);
        }

        window.frame.getContentPane().add(drawGame);

        window.frame.addKeyListener(snake.directionListener);
        window.frame.addKeyListener(gameStartedAgain);

        snake.addComponent(20);

        while (running) {

            snake.update();
            snake.selfColisionCheckUpdate();
            snake.itemColisionCheckUpdate(items);
            snake.IncrementFramesSinceLastTurn();

            drawGame.repaint();

            try {
                Thread.sleep(DELTA_T_IN_MINISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (isGameLost(snake)){
                running = false;
                JLabel gameLost = new JLabel();
                gameLost.setText("You have lost, press space to play again");
                gameLost.setLocation(WIDTH/2,HEIGHT/2);
                drawGame.add(gameLost);
                drawGame.repaint();
            }
        }
    }

    class DrawGame extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.PINK);
            g2d.fillRect(0,0,1000,1000);

            g2d.setColor(Color.RED);
            for (ItemComponent c : items) {
                g2d.drawImage(wudeczka,c.x, c.y, c.size, c.size,this);
                //g2d.fillRect(c.getX(), c.getY(), c.getSize(), c.getSize());
            }
            g2d.setColor(Color.BLACK);
            for (SnakeComponent c : snake.getSnakeComponents()) {
                g2d.drawImage(leszcz,c.getX(), c.getY(), c.getSize()+5, c.getSize()+5,this);
                //g2d.fillRect(c.getX(), c.getY(), c.getSize(), c.getSize());
            }
            g.drawImage(leszcz, snake.getSnakeHead().getX(), snake.getSnakeHead().getY(), snake.getSnakeHead().getSize()+5, snake.getSnakeHead().getSize()+5, this);


        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.runGame();
    }
}