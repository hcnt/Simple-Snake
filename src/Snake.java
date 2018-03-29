import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Snake {
    private ArrayList<SnakeComponent> snakeComponents = new ArrayList<>();
    private SnakeComponent snakeHead;
    private int xDirection = 1;
    private int yDirection = 0;
    private int framesSinceLastTurn = 0;
    private final int NUMBER_OF_COMPONENTS_ADDED_AFTER_COLISION_WITH_ITEM = 20;
    public static final int MOVING_FORWARD_FRACTION = 15;
    private final int X_POSITION_OF_FIRST_COMPONENT = 100;
    private final int Y_POSITION_OF_FIRST_COMPONENT = 50;

    DirectionChangedListener directionListener = new DirectionChangedListener();

    public ArrayList<SnakeComponent> getSnakeComponents() {
        return snakeComponents;
    }

    public SnakeComponent getSnakeHead() {
        return snakeHead;
    }

    public void IncrementFramesSinceLastTurn() {
        framesSinceLastTurn++;
    }

    public Snake() {
        snakeComponents.add(new SnakeComponent(X_POSITION_OF_FIRST_COMPONENT,Y_POSITION_OF_FIRST_COMPONENT));
        snakeComponents.add(new SnakeComponent(X_POSITION_OF_FIRST_COMPONENT-30,Y_POSITION_OF_FIRST_COMPONENT));
        snakeHead = snakeComponents.get(0);
    }


    public void addComponent(int amount) {
        for (int i = 1; i <= amount; i++) {
            int newX = snakeComponents.get(snakeComponents.size()-1).getX();
            int newY = snakeComponents.get(snakeComponents.size()-1).getY();
            snakeComponents.add(new SnakeComponent(newX,newY));
        }
    }

    public void removeComponent(int amount) {
        for (int i = 0; i < amount; i++) {
            snakeComponents.remove(snakeComponents.size() - 1);
        }
    }

    public void update() {
        for (int i = snakeComponents.size()-1; i > 0; i--) {
            snakeComponents.get(i).setX(snakeComponents.get(i-1).getX());
            snakeComponents.get(i).setY(snakeComponents.get(i-1).getY());
        }
        snakeHead.incrementX((snakeHead.getSize()/MOVING_FORWARD_FRACTION) * xDirection);
        snakeHead.incrementY((snakeHead.getSize()/MOVING_FORWARD_FRACTION) * yDirection);
    }

    public boolean selfColisionCheckUpdate(){
        for(int i = 60; i< snakeComponents.size(); i++){
            if(SnakeComponent.doComponentsColide(snakeHead, snakeComponents.get(i))){
               return true;
            }
        }
        return false;
    }
    public void itemColisionCheckUpdate(ArrayList<ItemComponent> items){
        for(int i = 0; i<items.size();i++){
            if(SnakeComponent.doComponentsColide(snakeHead, items.get(i))){
                items.remove(i);
                ItemComponent.addItemComponent(items);
                addComponent(NUMBER_OF_COMPONENTS_ADDED_AFTER_COLISION_WITH_ITEM);
                Level1.points++;
                Level1.pointsLabel.setText("Punkty: "+ Level1.points);

            }
        }
    }
    public boolean wallColisionCheckUpdate(){
        return (snakeHead.x >= Game.WIDTH - snakeHead.getSize() ||
                snakeHead.y >= Game.HEIGHT - snakeHead.getSize() ||
                snakeHead.x <= 0 ||
                snakeHead.y <= 0 );
    }

    class DirectionChangedListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            //if (framesSinceLastTurn > 10) {
                switch (key) {
                    case 37: if (xDirection == 0) { xDirection = -1; yDirection = 0; } break;
                    case 38: if (yDirection == 0) { yDirection = -1;xDirection = 0; }break;
                    case 39: if (xDirection == 0) { xDirection = 1;yDirection = 0; }break;
                    case 40: if (yDirection == 0) { yDirection = 1;xDirection = 0; }break;
                }
                //framesSinceLastTurn = 0;
           // }
        }
        public void keyReleased(KeyEvent e){}
        public void keyTyped(KeyEvent e) { }
    }


}