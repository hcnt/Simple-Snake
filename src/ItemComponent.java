import javax.swing.*;
import java.awt.*;

public class ItemComponent extends Component {

    public ItemComponent() {
        this.size = 130;
        this.x =(int)(Math.random()*(Game.WIDTH-this.size));
        this.y= (int)(Math.random()*(Game.HEIGHT-this.size));

    }
}