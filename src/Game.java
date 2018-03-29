
public class Game {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    public static final long DELTA_T_IN_MILLISECONDS = 9;
    public static final int NUMBER_OF_ITEMS = 3;
    public static Window window = new Window(Game.WIDTH,Game.HEIGHT);



    private void runGame(){
        Scene menu = new Menu();
        Scene level1 = new Level1();
        Scene gameoverScreen = new GameoverScreen();

        while (true){
            switch (Scene.activeScene) {
                case 1: level1.runScene();break;
                case 0: menu.runScene();break;
                case 2: gameoverScreen.runScene();break;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.runGame();

    }
}