
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ButtonStyle{
    private ImageFiles image = new ImageFiles();
    private Border emptyBorder = BorderFactory.createEmptyBorder();

    private Color color = new Color(226,218,196,255);

    public JButton backButton(JPanel panel){
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(true);

            }
        });
        return backButton;
    }

    public JButton buyButton(JPanel panel){
            JButton button = new JButton();
            button.setText("BUY");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setVisible(false);
                }
            });
            return button;
        }
    public JButton fillButton(JPanel panel){
        JButton fillbutton = new JButton();
        fillbutton.setText("Fill");
        fillbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("lulululul");
                panel.setVisible(false);
            }
        });
        return fillbutton;
    }
    public JButton SizeSButton(){
        JButton sizeSButton = new JButton();
        sizeSButton.setIcon(image.getSizeS());
        sizeSButton.setBorder(emptyBorder);
        sizeSButton.setBackground(color);

        return sizeSButton;
    }
    public JButton SizeMButton(){
        JButton sizeMButton = new JButton();
        sizeMButton.setIcon(image.getSizeM());
        sizeMButton.setBorder(emptyBorder);
        sizeMButton.setBackground(color);

        return sizeMButton;
    }
    public JButton SizeLButton(){
        JButton sizeLButton = new JButton();
        sizeLButton.setIcon(image.getSizeL());
        sizeLButton.setBorder(emptyBorder);
        sizeLButton.setBackground(color);
        return sizeLButton;
    }
    public JButton finalBuyButton(){
        JButton finalbuyButton = new JButton("BUY");

        return finalbuyButton;
    }




}
