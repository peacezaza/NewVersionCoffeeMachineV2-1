package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;

public class MainFrame {
    private JFrame frame = new JFrame("CoffeeMachine");
    private Color color = new Color(226,218,196,255);
    public MainFrame(){
        setFirstPage(frame);
        createJFrame();


    }
    private void createJFrame(){
        frame.setSize(350,370);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setTitleCenter(frame);
            }
        });

    }
    private void setTitleCenter(JFrame frame){
        Font font = frame.getFont();
        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);

    }

    private void setFirstPage(JFrame frame){
        ButtonStyle button = new ButtonStyle();
        ImageFiles image = new ImageFiles();
        JPanel panel = new JPanel();
        JLabel label = new JLabel(image.getTurtle(),JLabel.CENTER);
        JLabel label1 = new JLabel("TAOJOM");
        panel.add(label1);
        panel.add(image.getLatteLabel());
        panel.add(image.getCapuccino());
        panel.add(image.getEspresso());
        frame.add(panel);
    }


    public static void main(String[] args){
        new MainFrame();
    }
}
