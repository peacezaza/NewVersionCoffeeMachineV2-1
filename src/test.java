import javax.swing.*;
import java.awt.*;

public class test {
    test(){
        JFrame frame = new JFrame("TEST");
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setSize(350,380);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new test();
    }
}


