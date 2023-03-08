
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxes {
    protected JCheckBox checkBox1 = new JCheckBox();
    protected JCheckBox checkBox2 = new JCheckBox();
    protected JCheckBox checkBox3 = new JCheckBox();
    protected CoffeeMachine coffee = new CoffeeMachine();

    private Color color = new Color(226,218,196,255);

    public JCheckBox createCheckBox1(){
        this.checkBox1.setText("LATTE");
        this.checkBox1.setBackground(color);
        this.checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
                coffee.setCoffee("LATTE");
                coffee.setPrice(coffee.getLATTE_PRICE());
            }
        });
        return this.checkBox1;
    }

    public JCheckBox createCheckBox2(){
        this.checkBox2.setText("CAPPUCCINO");
        this.checkBox2.setBackground(color);
        this.checkBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setSelected(false);
                checkBox3.setSelected(false);
                coffee.setCoffee("CAPPUCCINO");
                coffee.setPrice(coffee.getCAPPUCCINO_PRICE());
            }
        });
        return this.checkBox2;
    }

    public JCheckBox createCheckBox3(){
        this.checkBox3.setText("ESPRESSO");
        this.checkBox3.setBackground(color);
        this.checkBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                coffee.setCoffee("ESPRESSO");
                coffee.setPrice(coffee.getESPRESSO_PRICE());
            }
        });
        return this.checkBox3;
    }


}