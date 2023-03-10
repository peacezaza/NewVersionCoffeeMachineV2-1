
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame{
    private JFrame frame = new JFrame("CoffeeMachine");
    private Color color = new Color(226,218,196,255);
    private CoffeeMachine coffee = new CoffeeMachine();
    private JPanel panelForHoldEveryElementInFirstPage;
    private JPanel SizePageMain = new JPanel();
    private JPanel panelForHoldEveryElementInFillPage = new JPanel();
    private JLabel price = new JLabel("฿ " + coffee.getPrice());

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
        panelForButton.add(buttonStyle.fillButton(panelForHoldEveryElementInFillPage,panelForHoldEveryElementInFirstPage));

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
        priceMainPanel.setBackground(color);


//        Add Button to the Panel
        SizeSelectPanel.add(buttonStyle.SizeSButton(price));
        SizeSelectPanel.add(buttonStyle.SizeMButton(price));
        SizeSelectPanel.add(buttonStyle.SizeLButton(price));
        BackPanel.add(buttonStyle.backButton(panelForHoldEveryElementInFirstPage, SizePageMain, panelForHoldEveryElementInFillPage));
        priceShowPanel.add(priceText);
        priceShowPanel.add(Box.createRigidArea(new Dimension(0,15)));
        priceShowPanel.add(price);
        buyCoffeeButton.add(buttonStyle.finalBuyButton());
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
//        Create Object

        ButtonStyle button = new ButtonStyle(coffee);
        panelForHoldEveryElementInFillPage.setVisible(false);
//        Create panel
        JPanel panelForBackButton = new JPanel();

//        Add Object to panel
        panelForBackButton.add(button.backButton(panelForHoldEveryElementInFirstPage, SizePageMain, panelForHoldEveryElementInFillPage));
        panelForHoldEveryElementInFillPage.add(panelForBackButton);


//        Add panel to the frame
        frame.add(panelForHoldEveryElementInFillPage);

    }



    public static void main(String[] args){
        new MainFrame();
    }


}
