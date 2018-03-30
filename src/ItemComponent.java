import java.util.ArrayList;

public class ItemComponent extends Component {

    public ItemComponent() {
        this.size = 50;
        this.x =(int)(Math.random()*(Game.WIDTH-this.size));
        this.y= (int)(Math.random()*(Game.HEIGHT-this.size));

    }


}