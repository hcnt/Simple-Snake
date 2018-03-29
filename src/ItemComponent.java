import java.util.ArrayList;

public class ItemComponent extends Component {

    public ItemComponent() {
        this.size = 50;
        this.x =(int)(Math.random()*(Game.WIDTH-this.size));
        this.y= (int)(Math.random()*(Game.HEIGHT-this.size));

    }

    public static boolean canThisItemBeAdded(ItemComponent itemToAdd, ArrayList<ItemComponent> items){
        for(ItemComponent item : items){
            if(doComponentsColide(item,itemToAdd)){
                System.out.println("xD");
                return false;
            }
        }
        return true;
    }
    public static void addItemComponent(ArrayList<ItemComponent> items){
        while(true) {
            ItemComponent itemToAdd = new ItemComponent();
            if(canThisItemBeAdded(itemToAdd,items)){
                items.add(itemToAdd);
                break;
            }
        }
    }
}