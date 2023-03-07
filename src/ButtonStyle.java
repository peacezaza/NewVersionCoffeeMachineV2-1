package src;

import javax.swing.*;

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
