import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class ButtonStyle{
    private ImageFiles image = new ImageFiles();
    private Border emptyBorder = BorderFactory.createEmptyBorder();
    private Color color = new Color(226,218,196,255);
    private JButton sizeSButton = new JButton();
    private JButton sizeMButton = new JButton();
    private JButton sizeLButton = new JButton();
    private CoffeeMachine coffee;
    private int checkClicked=0;
    public ButtonStyle(CoffeeMachine coffee){
        this.coffee = coffee;
    }

    public JButton backButton(JPanel showPanel, JPanel hidePanel1, JPanel hidePanel2){
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel.setVisible(true);
                hidePanel1.setVisible(false);
                hidePanel2.setVisible(false);
                coffee.setPrice(0);
            }
        });
        return backButton;
    }
    public JButton buyButton(JPanel panel, JPanel panelForSelectionSizePage,CheckBoxes checkBoxes){
            JButton button = new JButton();
            button.setText("BUY");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkBoxes.checkBox1.isSelected() || checkBoxes.checkBox2.isSelected() || checkBoxes.checkBox3.isSelected()){
                        panel.setVisible(false);
                        panelForSelectionSizePage.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(panel, "Please, Select one of the option", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }
            });
            return button;
        }
    public JButton fillButton(JPanel showPanel, JPanel hidePanel1){
        JButton fillbutton = new JButton();
        fillbutton.setText("Fill");
        fillbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel.setVisible(true);
                hidePanel1.setVisible(false);
            }
        });
        return fillbutton;
    }
    public JButton SizeSButton(JLabel price){
        sizeSButton.setIcon(image.getSizeS());
        sizeSButton.setBorder(emptyBorder);
        sizeSButton.setBackground(color);
        sizeSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coffee.setFinalPrice(coffee.getPrice()+coffee.getPresentSize());
                price.setText("฿ " + (coffee.getPrice()+coffee.getPresentSize()));
            }
        });
        //Add MouseListenner
        sizeSButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                checkClicked = 1;
                coffee.setPresentSize(coffee.getSizeS());
                sizeSButton.setContentAreaFilled(false);
                sizeSButton.setOpaque(true);
                sizeSButton.setBackground(new Color(255, 189, 7, 255));
                sizeMButton.setBackground(color);
                sizeLButton.setBackground(color);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if(checkClicked == 0)
                {sizeSButton.setBackground(new Color(244, 208, 109, 255));}
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(checkClicked == 0){
                    sizeSButton.setBackground(color);
                }

            }
        });
        return sizeSButton;
    }
    public JButton SizeMButton(JLabel price){
        sizeMButton.setIcon(image.getSizeM());
        sizeMButton.setBorder(emptyBorder);
        sizeMButton.setBackground(color);
        sizeMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coffee.setFinalPrice(coffee.getPrice()+coffee.getPresentSize());
                price.setText("฿ " + (coffee.getPrice()+coffee.getPresentSize()));
            }
        });
        sizeMButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                checkClicked = 1;
                coffee.setPresentSize(coffee.getSizeM());
                sizeMButton.setContentAreaFilled(false);
                sizeMButton.setOpaque(true);
                sizeMButton.setBackground(new Color(255, 189, 7, 255));
                coffee.setPresentSize(coffee.getSizeM());
//                Change other button to normal color when this button has been clicked
                sizeSButton.setBackground(color);
                sizeLButton.setBackground(color);
            }


            @Override
            public void mouseEntered(MouseEvent e) {
                if(checkClicked == 0){
                    sizeMButton.setBackground(new Color(244, 208, 109, 255));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(checkClicked == 0){
                    sizeMButton.setBackground(color);
                }

            }
        });
        return sizeMButton;
    }
    public JButton SizeLButton(JLabel price){
        sizeLButton.setIcon(image.getSizeL());
        sizeLButton.setBorder(emptyBorder);
        sizeLButton.setBackground(color);
        sizeLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coffee.setFinalPrice(coffee.getPrice()+coffee.getPresentSize());
                price.setText("฿ " + (coffee.getPrice()+coffee.getPresentSize()));
            }
        });
        sizeLButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                use this to check when user hover back at the button again and we will not allowed the button to change back to defalut color
                checkClicked = 1;
                coffee.setPresentSize(coffee.getSizeL());
                sizeLButton.setContentAreaFilled(false);
                sizeLButton.setOpaque(true);
                sizeLButton.setBackground(new Color(255, 189, 7, 255));
                sizeMButton.setBackground(color);
                sizeSButton.setBackground(color);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if(checkClicked == 0)
                {sizeLButton.setBackground(new Color(244, 208, 109, 255));}
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if(checkClicked == 0){
                    sizeLButton.setBackground(color);
                }
            }
        });
        return sizeLButton;
    }
    public JButton finalBuyButton(){
        JButton finalbuyButton = new JButton("BUY");
        JFrame message = new JFrame();
        finalbuyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (coffee.getCoffee()) {
                    case ESPRESSO :
                        coffee.makeEspresso();
                        break;
                    case LATTE :
                        coffee.makeLatte();
                        break;
                    case CAPPUCCINO:
                        coffee.makeCappuccino();
                        break;
                    default:{}
                }
                //Please Fix
//                if(coffee.canMakeCoffee(coffee.getWater(),coffee.getMilk(),coffee.getBeans())){
//                    JOptionPane.showMessageDialog(message, "I have enough resources, making you a coffee!", "Complete!", JOptionPane.INFORMATION_MESSAGE);
//
//                }else{
//                    StringBuilder need  = coffee.notEnough(coffee.getWater(),coffee.getMilk(),coffee.getBeans());
//                    JOptionPane.showMessageDialog(message, "Sorry, not enough " + need.toString(), "WARNING", JOptionPane.WARNING_MESSAGE);
//                }
            }
        });
        return finalbuyButton;
    }
}
