
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;

public class MainFrame{
    private JFrame frame = new JFrame("CoffeeMachine");
    private Color color = new Color(226,218,196,255);
    public MainFrame(){
        setFirstPage();
        createJFrame();

    }
    private void createJFrame(){
        frame.setSize(350,400);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setTitleCenter();
            }
        });
    }
    private void setTitleCenter(){
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
    private void showTurtle(){
        ImageFiles image = new ImageFiles();
        JPanel panelShowIcon = new JPanel();
        JLabel turtle = new JLabel(image.getTurtle());
        JLabel label1 = new JLabel("TAOJOM");
        panelShowIcon.setLayout(new BoxLayout(panelShowIcon,BoxLayout.Y_AXIS));
        panelShowIcon.add(turtle);
        panelShowIcon.add(label1);
        frame.add(panelShowIcon);
    }

    private void setFirstPage(){
        ButtonStyle button = new ButtonStyle();
        CheckBoxes checkBoxes = new CheckBoxes();
        ImageFiles image = new ImageFiles();
        JPanel panel = new JPanel();
        JPanel checkBoxesPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        showTurtle();
        panel.add(image.getLatteLabel());
        panel.add(image.getCapuccino());
        panel.add(image.getEspresso());
        checkBoxesPanel.add(checkBoxes.createCheckBox1());
        checkBoxesPanel.add(checkBoxes.createCheckBox2());
        checkBoxesPanel.add(checkBoxes.createCheckBox3());
        buttonPanel.add(button.buyButton());
        buttonPanel.add(button.fillButton());
        frame.add(panel);
        frame.add(checkBoxesPanel);
        frame.add(buttonPanel);
    }
    private void setSizePage(){
        
    }



    public static void main(String[] args){
        new MainFrame();
    }


}
