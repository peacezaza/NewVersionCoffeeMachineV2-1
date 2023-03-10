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
    public JButton fillButton(JPanel showPanel, JPanel hidePanel1, JLabel getWater, JLabel getMilk, JLabel getBeans, JLabel getCups, JLabel getCash){
        JButton fillbutton = new JButton();
        fillbutton.setText("Fill");
        fillbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel.setVisible(true);
                hidePanel1.setVisible(false);
                getWater.setText(Integer.toString(coffee.getWater()));
                getMilk.setText(Integer.toString(coffee.getMilk()));
                getBeans.setText(Integer.toString(coffee.getBeans()));
                getCups.setText(Integer.toString(coffee.getCups()));
                getCash.setText(Integer.toString(coffee.getMachineMoney()));
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
                coffee.setSizeCoffee("Size S");
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
                coffee.setSizeCoffee("Size M");
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
                coffee.setSizeCoffee("Size L");
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
    public JButton finalBuyButton(JFrame message){
        JButton finalbuyButton = new JButton("BUY");
//        JFrame message = new JFrame();
        finalbuyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkClicked == 0){
                    JOptionPane.showMessageDialog(message,"Please Select Size","Alert",JOptionPane.WARNING_MESSAGE);
                }else{
                    switch (coffee.getCoffee()) {
                        case ESPRESSO :
                            if(coffee.EspressoNeed()){
                                JOptionPane.showMessageDialog(message, "I have enough resources, making you a coffee!", "Complete!", JOptionPane.INFORMATION_MESSAGE);
                                try {
                                    String userPriceText = JOptionPane.showInputDialog(message,"Enter Money");
                                    coffee.setUserMoney(Integer.parseInt(userPriceText));
                                    if(coffee.getUserMoney() - coffee.getFinalprice() < 0){
                                        JOptionPane.showMessageDialog(message,"Not Enough Money!","Alert",JOptionPane.WARNING_MESSAGE);
                                    }else{
                                        JOptionPane.showMessageDialog(message, "Change : " + (coffee.getUserMoney() - coffee.getFinalprice()) , "Complete!", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(message, "Buy " + coffee.getCoffee() + " " + coffee.getSizeCoffee() + " Successful!" , "Complete!", JOptionPane.INFORMATION_MESSAGE);
                                        coffee.makeEspresso();
                                    }
                                }catch (NumberFormatException exception){
                                    JOptionPane.showMessageDialog(message, "Invalid Input!", "Complete!", JOptionPane.ERROR_MESSAGE);
                                }

                            }else{
                                StringBuilder need  = coffee.notEnough(coffee.getESPRESSO_WATER_ML_PER_CUP(),coffee.getESPRESSO_MILK_ML_PER_CUP(),coffee.getESPRESSO_BEANS_G_PER_CUP());
                                JOptionPane.showMessageDialog(message, "Sorry, not enough " + need.toString(), "WARNING", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        case LATTE :
                            if(coffee.LatteNeed()){
                                JOptionPane.showMessageDialog(message, "I have enough resources, making you a coffee!", "Complete!", JOptionPane.INFORMATION_MESSAGE);
                                try {
                                    String userPriceText = JOptionPane.showInputDialog(message,"Enter Money");
                                    coffee.setUserMoney(Integer.parseInt(userPriceText));
                                    if(coffee.getUserMoney() - coffee.getFinalprice() < 0){
                                        JOptionPane.showMessageDialog(message,"Not Enough Money!","Alert",JOptionPane.WARNING_MESSAGE);
                                    }else{
                                        JOptionPane.showMessageDialog(message, "Change : " + (coffee.getUserMoney() - coffee.getFinalprice()) , "Complete!", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(message, "Buy " + coffee.getCoffee() + " " + coffee.getSizeCoffee() + " Successful!" , "Complete!", JOptionPane.INFORMATION_MESSAGE);
                                        coffee.makeLatte();
                                    }
                                }catch (NumberFormatException exception){
                                    JOptionPane.showMessageDialog(message, "Invalid Input!", "Complete!", JOptionPane.ERROR_MESSAGE);
                                }
                            }else{
                                StringBuilder need  = coffee.notEnough(coffee.getLATTE_WATER_ML_PER_CUP(),coffee.getLATTE_MILK_ML_PER_CUP(),coffee.getLATTE_BEANS_G_PER_CUP());
                                JOptionPane.showMessageDialog(message, "Sorry, not enough " + need.toString(), "WARNING", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        case CAPPUCCINO:
                            if(coffee.CappuccinoNeed()){
                                JOptionPane.showMessageDialog(message, "I have enough resources, making you a coffee!", "Complete!", JOptionPane.INFORMATION_MESSAGE);
                                try {
                                    String userPriceText = JOptionPane.showInputDialog(message,"Enter Money");
                                    coffee.setUserMoney(Integer.parseInt(userPriceText));
                                    if(coffee.getUserMoney() - coffee.getFinalprice() < 0){
                                        JOptionPane.showMessageDialog(message,"Not Enough Money!","Alert",JOptionPane.WARNING_MESSAGE);
                                    }else{
                                        JOptionPane.showMessageDialog(message, "Change : " + (coffee.getUserMoney() - coffee.getFinalprice()) , "Complete!", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(message, "Buy " + coffee.getCoffee() + " " + coffee.getSizeCoffee() + " Successful!" , "Complete!", JOptionPane.INFORMATION_MESSAGE);
                                        coffee.makeCappuccino();
                                    }
                                }catch (NumberFormatException exception){
                                    JOptionPane.showMessageDialog(message, "Invalid Input!", "Complete!", JOptionPane.ERROR_MESSAGE);
                                }
                            }else{
                                StringBuilder need  = coffee.notEnough(coffee.getCAPPUCCINO_WATER_ML_PER_CUP(),coffee.getCAPPUCCINO_MILK_ML_PER_CUP(),coffee.getCAPPUCCINO_BEANS_G_PER_CUP());
                                JOptionPane.showMessageDialog(message, "Sorry, not enough " + need.toString(), "WARNING", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        default:{}
                    }
                }
            }
        });
        return finalbuyButton;
    }

    public JButton withdrawButton(JLabel getCash){
        JButton withdraw = new JButton();
        withdraw.setText("WITHDRAW");
        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coffee.setWithdrawMoney();
                getCash.setText(Integer.toString(coffee.getMachineMoney()));

            }
        });
        return withdraw;
    }

    public JButton fillStock(JLabel getWater, JLabel getMilk, JLabel getBeans, JLabel getCups){
        JButton fill = new JButton();
        fill.setText("FILL");
        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coffee.setWater(1500);
                coffee.setMilk(500);
                coffee.setBeans(200);
                coffee.setCups(20);
                getWater.setText(Integer.toString(coffee.getWater()));
                getMilk.setText(Integer.toString(coffee.getMilk()));
                getBeans.setText(Integer.toString(coffee.getBeans()));
                getCups.setText(Integer.toString(coffee.getCups()));
            }
        });
        return fill;
    }
}
