
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame{
    private JFrame frame = new JFrame("CoffeeMachine");
    private Color color = new Color(226,218,196,255);
    private CoffeeMachine coffee = new CoffeeMachine(1500,500,200,20);
    private JPanel panelForHoldEveryElementInFirstPage;
    private JPanel SizePageMain = new JPanel();
    private JPanel panelForHoldEveryElementInFillPage = new JPanel();
    private JLabel price = new JLabel("฿ " + coffee.getPrice());
    private JLabel getWater = new JLabel();
    private JLabel getMilk = new JLabel();
    private JLabel getBeans = new JLabel();
    private JLabel getCups = new JLabel();
    private JLabel getCash = new JLabel();

    public MainFrame(){
        setFirstPage();
        setSelectSizePage();
        setFillPage();
        createJFrame();

    }
    private void createJFrame(){
        frame.setSize(350,380);
        frame.getContentPane().setBackground(color);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.frame.setBackground(color);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setTitleCenter();
            }
        });
    }
    private void setTitleCenter(){
        Font font = frame.getFont();
        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);
    }
    private void setshowTurtle(){
        ImageFiles image = new ImageFiles();
        JPanel panelShowIcon = new JPanel();
        JLabel turtle = new JLabel(image.getTurtle());
//        System.out.println(image.getTurtlePath());
        JLabel label1 = new JLabel("TAOJOM");
        panelShowIcon.setLayout(new BoxLayout(panelShowIcon,BoxLayout.Y_AXIS));
        panelShowIcon.add(turtle);
        panelShowIcon.add(label1);
        panelShowIcon.setBackground(color);
        frame.add(panelShowIcon);
    }

    private void setFirstPage(){
        setshowTurtle();
        SizePageMain.setVisible(false);


//        Create Object of Images, checkboxs, buttons
        ImageFiles coffeeCupImage = new ImageFiles();
        ButtonStyle buttonStyle = new ButtonStyle(coffee);
        CheckBoxes checkBoxes = new CheckBoxes(coffee);

//        Create Panels
        panelForHoldEveryElementInFirstPage = new JPanel();
        JPanel panelForcups = new JPanel();
        JPanel panelForCheckBoxes = new JPanel();
        JPanel panelForButton = new JPanel();


//        Set Panels Layout
        panelForcups.setLayout(new FlowLayout());
        panelForButton.setLayout(new FlowLayout());
        panelForCheckBoxes.setLayout(new BoxLayout(panelForCheckBoxes,BoxLayout.X_AXIS));
        panelForHoldEveryElementInFirstPage.setLayout(new BoxLayout(panelForHoldEveryElementInFirstPage,BoxLayout.Y_AXIS));


        //        Adding Component to Panel
        panelForcups.add(coffeeCupImage.getLatteLabel());
        panelForcups.add(coffeeCupImage.getCapuccino());
        panelForcups.add(coffeeCupImage.getEspresso());
        panelForCheckBoxes.add(checkBoxes.createCheckBox1(price));
        panelForCheckBoxes.add(checkBoxes.createCheckBox2(price));
        panelForCheckBoxes.add(checkBoxes.createCheckBox3(price));
        panelForCheckBoxes.add(Box.createRigidArea(new Dimension(0,60)));
        panelForButton.add(buttonStyle.buyButton(panelForHoldEveryElementInFirstPage, SizePageMain, checkBoxes));
        panelForButton.add(buttonStyle.fillButton(panelForHoldEveryElementInFillPage,panelForHoldEveryElementInFirstPage,getWater,getMilk,getBeans,getCups,getCash));


//        Adding Panels to Main Panel for holding Every Panels
        panelForHoldEveryElementInFirstPage.add(panelForcups);
        panelForHoldEveryElementInFirstPage.add(panelForCheckBoxes);
        panelForHoldEveryElementInFirstPage.add(panelForButton);
        panelForcups.setBackground(color);
        panelForCheckBoxes.setBackground(color);
        panelForButton.setBackground(color);
        panelForHoldEveryElementInFirstPage.setBackground(color);

//        Adding main panel to frame
        frame.add(panelForHoldEveryElementInFirstPage);
    }
    private void setSelectSizePage(){
        panelForHoldEveryElementInFillPage.setVisible(false);
//        Create Object
        ButtonStyle buttonStyle = new ButtonStyle(coffee);

//        Create Panel
        JPanel SizeSelectPanel = new JPanel();
        JPanel BackPanel = new JPanel();
        JPanel priceMainPanel = new JPanel();
        JPanel priceShowPanel = new JPanel();
        JPanel buyCoffeeButton = new JPanel();

//        Create Label
        JLabel priceText = new JLabel("Price");
//        Set Layout for panel
        SizeSelectPanel.setLayout(new FlowLayout());
        SizePageMain.setLayout(new BoxLayout(SizePageMain,BoxLayout.Y_AXIS));
        priceShowPanel.setLayout(new BoxLayout(priceShowPanel ,BoxLayout.Y_AXIS));
        priceMainPanel.setLayout(new BoxLayout(priceMainPanel ,BoxLayout.X_AXIS));


//        Set Background for panel
        priceMainPanel.setBackground(color);
        buyCoffeeButton.setBackground(color);
        priceShowPanel.setBackground(color);
        SizePageMain.setBackground(color);
        BackPanel.setBackground(color);
        SizeSelectPanel.setBackground(color);


//        Add Button to the Panel
        SizeSelectPanel.add(buttonStyle.SizeSButton(price));
        SizeSelectPanel.add(buttonStyle.SizeMButton(price));
        SizeSelectPanel.add(buttonStyle.SizeLButton(price));
        BackPanel.add(buttonStyle.backButton(panelForHoldEveryElementInFirstPage, SizePageMain, panelForHoldEveryElementInFillPage));
        priceShowPanel.add(priceText);
        priceShowPanel.add(Box.createRigidArea(new Dimension(0,15)));
        priceShowPanel.add(price);
        buyCoffeeButton.add(buttonStyle.finalBuyButton(frame));
        priceMainPanel.add(priceShowPanel);
        priceMainPanel.add(Box.createRigidArea(new Dimension(210,0)));
        priceMainPanel.add(buyCoffeeButton);


//        Add Panel to main panel
        SizePageMain.add(SizeSelectPanel);
        SizePageMain.add(BackPanel);
        SizePageMain.add(priceMainPanel);


//      Add panel to Frame
        frame.add(SizePageMain);
    }
    private void setFillPage(){
//        panelForHoldEveryElementInFillPage.setVisible(false);


//        Create Object
        ButtonStyle button = new ButtonStyle(coffee);

//        Create panel
        JPanel panelForBackButton = new JPanel();
        JPanel panelForHoldWaterText = new JPanel();
        JPanel panelForHoldMilkText = new JPanel();
        JPanel panelForHoldBeansText = new JPanel();
        JPanel panelForHoldCupsText = new JPanel();
        JPanel panelForHoldCashText = new JPanel();
        JPanel panelForButton = new JPanel();


//        Set layout for panel
//        panelForHoldWaterText.setLayout(new );
        panelForHoldEveryElementInFillPage.setLayout(new BoxLayout(panelForHoldEveryElementInFillPage,BoxLayout.Y_AXIS));

//        Create JLabel for water, mlik, beans, cups cash
        JLabel water = new JLabel("Water / ml : ");
        JLabel milk = new JLabel("milk / ml : ");
        JLabel beans = new JLabel("coffee /grams : ");
        JLabel cups = new JLabel("disposable cups : ");
        JLabel cash = new JLabel("Cash : ");


//        Add Object to panel
        panelForHoldWaterText.add(water);panelForHoldWaterText.add(getWater);
        panelForHoldMilkText.add(milk);panelForHoldMilkText.add(getMilk);
        panelForHoldBeansText.add(beans);panelForHoldBeansText.add(getBeans);
        panelForHoldCupsText.add(cups);panelForHoldCupsText.add(getCups);
        panelForHoldCashText.add(cash);panelForHoldCashText.add(getCash);
        panelForButton.add(button.withdrawButton(getCash));
        panelForButton.add(button.fillStock(getWater,getMilk,getBeans,getCups));
        panelForBackButton.add(button.backButton(panelForHoldEveryElementInFirstPage, SizePageMain, panelForHoldEveryElementInFillPage));


//        Add panel to main panel of fill page
        panelForHoldEveryElementInFillPage.add(panelForHoldWaterText);
        panelForHoldEveryElementInFillPage.add(panelForHoldMilkText);
        panelForHoldEveryElementInFillPage.add(panelForHoldBeansText);
        panelForHoldEveryElementInFillPage.add(panelForHoldCupsText);
        panelForHoldEveryElementInFillPage.add(panelForHoldCashText);
        panelForHoldEveryElementInFillPage.add(panelForButton);
        panelForHoldEveryElementInFillPage.add(panelForBackButton);


        //        Set color
        Color color2 = new Color(242, 220, 159, 255);
        panelForBackButton.setBackground(color);
        panelForHoldWaterText.setBackground(color2);
        panelForHoldMilkText.setBackground(color2);
        panelForHoldBeansText.setBackground(color2);
        panelForHoldCupsText.setBackground(color2);
        panelForHoldCashText.setBackground(color2);
        panelForButton.setBackground(color2);


//        Add panel to the frame
        frame.add(panelForHoldEveryElementInFillPage);

    }



    public static void main(String[] args){
        new MainFrame();
    }


}
