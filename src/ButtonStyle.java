
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonStyle extends Buttons{
    @Override
    public JButton buyButton(){
        JButton button = new JButton();
        button.setText("BUY");
        return button;
    }


    @Override
    public JButton fillButton() {
        return null;
    }


}
