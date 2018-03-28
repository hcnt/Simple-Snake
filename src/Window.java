import javax.swing.*;

public class Window {
    JFrame frame;

    public Window(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public Window(int width, int height){
        this();
        frame.setSize(width,height);

    }

}
