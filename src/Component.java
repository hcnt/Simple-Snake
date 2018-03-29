public class Component {
    protected int x;
    protected int y;
    int size = 50;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getSize() {
        return size;
    }

    public Component(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Component(){}

    public static boolean doComponentsColide(Component a, Component b){
        return (a.x + a.size > b.x &&
                b.x + b.size > a.x &&
                a.y + a.size > b.y &&
                b.y + b.size > a.y );

    }
}
