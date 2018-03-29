import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level1 extends Scene {
    private Snake snake;
    private ArrayList<ItemComponent> items;
    BufferedImage leszcz;
    BufferedImage wudeczka;
    GameStartedAgainListener gameStartedAgain = new GameStartedAgainListener();

    DrawLevel1 drawLevel = new DrawLevel1();

    private boolean isGameLost(Snake snake){
        return snake.wallColisionCheckUpdate();
    }
    public void runScene() {

        running = true;
        leszcz = loadImage("leszcz.png");
        wudeczka = loadImage("wudeczka.png");
        snake = new Snake();
        items = new ArrayList<>();
        drawLevel.setLayout(null);
        window.frame.setVisible(true);

        for (int i = 0; i < Game.NUMBER_OF_ITEMS; i++) {
            ItemComponent.addItemComponent(items);
        }
        window.frame.getContentPane().add(drawLevel);
        window.frame.addKeyListener(snake.directionListener);
        window.frame.addKeyListener(gameStartedAgain);

        snake.addComponent(20);

        while (running) {

            snake.update();
            snake.selfColisionCheckUpdate();
            snake.itemColisionCheckUpdate(items);
            snake.IncrementFramesSinceLastTurn();

            drawLevel.repaint();

            try {
                Thread.sleep(Game.DELTA_T_IN_MINISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (isGameLost(snake)) {
                running = false;
                JLabel gameLost = new JLabel();
                gameLost.setText("You have lost, press space to play again");
                gameLost.setLocation(Game.WIDTH / 2, Game.HEIGHT / 2);
                drawLevel.add(gameLost);
                drawLevel.repaint();
            }
        }
    }
    public class DrawLevel1 extends DrawScene{
        protected void paintComponent(Graphics g) {
           super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.PINK);
            g2d.fillRect(0, 0, 1000, 1000);

            g2d.setColor(Color.RED);
            for (ItemComponent c : items) {
                g2d.drawImage(wudeczka, c.x, c.y, c.size, c.size, this);
                //g2d.fillRect(c.getX(), c.getY(), c.getSize(), c.getSize());
            }
            g2d.setColor(Color.BLACK);
            for (SnakeComponent c : snake.getSnakeComponents()) {
                g2d.drawImage(leszcz, c.getX(), c.getY(), c.getSize() + 5, c.getSize() + 5, this);
                //g2d.fillRect(c.getX(), c.getY(), c.getSize(), c.getSize());
            }
            g.drawImage(leszcz, snake.getSnakeHead().getX(), snake.getSnakeHead().getY(), snake.getSnakeHead().getSize() + 5, snake.getSnakeHead().getSize() + 5, this);
        }
    }
}