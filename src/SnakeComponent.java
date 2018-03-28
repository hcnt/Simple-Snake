
public class SnakeComponent extends Component{
    public SnakeComponent(int x,int y){
        super(x,y);
    }

    public void incrementY(int amount) {
        this.y += amount;
    }
    public void incrementX(int amount) {
        this.x += amount;
    }

}
