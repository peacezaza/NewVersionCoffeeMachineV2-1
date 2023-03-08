
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxes {
    protected JCheckBox checkBox1 = new JCheckBox();
    protected JCheckBox checkBox2 = new JCheckBox();
    protected JCheckBox checkBox3 = new JCheckBox();
    public JCheckBox createCheckBox1(){
//        this.checkBox1.addActionListener(new CheckBoxListener());
        this.checkBox1.setText("LATTE");
        this.checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);

            }
        });
        return this.checkBox1;
    }

    public JCheckBox createCheckBox2(){
//        this.checkBox2.addActionListener(new CheckBoxListener());
        this.checkBox2.setText("CAPPUCHINO");
        this.checkBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setSelected(false);
                checkBox3.setSelected(false);

            }
        });
        return this.checkBox2;
    }

    public JCheckBox createCheckBox3(){
//        this.checkBox3.addActionListener(new CheckBoxListener());
        this.checkBox3.setText("ESPRESSO");
        this.checkBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);

            }
        });
        return this.checkBox3;
    }


}