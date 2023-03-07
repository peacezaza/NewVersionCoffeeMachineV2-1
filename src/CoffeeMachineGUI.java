package src;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;

public class CoffeeMachineGUI extends JFrame {
    Container c = getContentPane();
    public CoffeeMachineGUI(){
        //GUI Setup
        super("CoffeeMachine");
        //main statement
        Color color = new Color(226,218,196,255);
        c.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        //Panel 2 Choose Coffee

        /* All Image */
        File latteFile = new File("lat.png");
        File CapuccinoFile = new File("cap.png");
        File espressoFile = new File("es.png");
        File turFile = new File("t.png");
        JLabel latte = new JLabel( new ImageIcon(((new ImageIcon(latteFile.getAbsolutePath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        JLabel capu = new JLabel( new ImageIcon(((new ImageIcon(CapuccinoFile.getAbsolutePath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        JLabel esp = new JLabel( new ImageIcon(((new ImageIcon(espressoFile.getAbsolutePath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        ImageIcon icon = new ImageIcon(((new ImageIcon(turFile.getAbsolutePath()).getImage()).getScaledInstance( 60, 60, java.awt.Image.SCALE_SMOOTH)));
        JLabel label = new JLabel(icon,JLabel.CENTER);
        JLabel label1 = new JLabel("TAOJOM");


        setSize(350, 370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {new CoffeeMachineGUI();}
}