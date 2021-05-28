import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TriangleDraw {

    public static void main(String[] args) {
       JFrame frame = new JFrame();
       frame.setSize(500, 500);
       frame.setTitle("Triangle Drawer");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Component component = new Component();
       frame.add(component);
       frame.setVisible(true);

    }
}
