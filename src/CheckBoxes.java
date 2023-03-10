import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CheckBoxes {
    protected JCheckBox checkBox1 = new JCheckBox();
    protected JCheckBox checkBox2 = new JCheckBox();
    protected JCheckBox checkBox3 = new JCheckBox();
    protected CoffeeMachine coffee;

    public CheckBoxes(CoffeeMachine coffee){
        this.coffee = coffee;
    }
    private Color color = new Color(226,218,196,255);

    public JCheckBox createCheckBox1(JLabel price){
        this.checkBox1.setText("LATTE");
        this.checkBox1.setBackground(color);
        this.checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
                coffee.setCoffee("LATTE");
                coffee.setPrice(coffee.getLATTE_PRICE());
                price.setText("฿ " + coffee.getPrice());
            }
        });
        return this.checkBox1;
    }

    public JCheckBox createCheckBox2(JLabel price){
        this.checkBox2.setText("CAPPUCCINO");
        this.checkBox2.setBackground(color);
        this.checkBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setSelected(false);
                checkBox3.setSelected(false);
                coffee.setCoffee("CAPPUCCINO");
                coffee.setPrice(coffee.getCAPPUCCINO_PRICE());
                price.setText("฿ " + coffee.getPrice());
            }
        });
        return this.checkBox2;
    }

    public JCheckBox createCheckBox3(JLabel price){
        this.checkBox3.setText("ESPRESSO");
        this.checkBox3.setBackground(color);
        this.checkBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                coffee.setCoffee("ESPRESSO");
                coffee.setPrice(coffee.getESPRESSO_PRICE());
                price.setText("฿ " + coffee.getPrice());
            }
        });
        return this.checkBox3;
    }


}