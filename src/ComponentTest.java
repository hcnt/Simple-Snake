public class ComponentTest {
    public static void main(String[] args){
//        Snake snake = new Snake();
//        snake.addComponent(3);
//        System.out.println(snake.getSnakeComponents());
//        snake.removeComponent(1);
//        System.out.println(snake.getSnakeComponents());

        System.out.println(SnakeComponent.doComponentsColide(new SnakeComponent(40,40),new SnakeComponent(40,40))); //true
        System.out.println(SnakeComponent.doComponentsColide(new SnakeComponent(40,40),new SnakeComponent(10,40))); //false
        System.out.println(SnakeComponent.doComponentsColide(new SnakeComponent(40,40),new SnakeComponent(30,40))); //true
        System.out.println(SnakeComponent.doComponentsColide(new SnakeComponent(40,40),new SnakeComponent(40,70))); //false
        System.out.println(SnakeComponent.doComponentsColide(new SnakeComponent(40,30),new SnakeComponent(40,40))); //true
        System.out.println(SnakeComponent.doComponentsColide(new SnakeComponent(70,40),new SnakeComponent(40,40))); //false
    }

}
