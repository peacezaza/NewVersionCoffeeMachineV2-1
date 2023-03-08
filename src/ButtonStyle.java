
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonStyle{

    public JButton buyButton(){
        JButton button = new JButton();
        button.setText("BUY");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("fafafafafa");
            }
        });
        return button;
    }
    public JButton fillButton() {
        JButton fillbutton = new JButton();
        fillbutton.setText("Fill");
        fillbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("lulululul");
            }
        });
        return fillbutton;
    }


}
