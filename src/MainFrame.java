import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileReader;

public class MainFrame{
    private JFrame frame = new JFrame("CoffeeMachine");
    private Color color = new Color(226,218,196,255);
    private JPanel panelForHoldEveryElementInFirstPage,SizePageMain;
    public MainFrame(){
//        setFirstPage();
//        setSelectSizePage();
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
        JLabel label1 = new JLabel("TAOJOM");
        panelShowIcon.setLayout(new BoxLayout(panelShowIcon,BoxLayout.Y_AXIS));
        panelShowIcon.add(turtle);
        panelShowIcon.add(label1);
        panelShowIcon.setBackground(color);
        frame.add(panelShowIcon);
    }

    private void setFirstPage(){
        setshowTurtle();
//        Create Object of Images, checkboxs, buttons
        ImageFiles coffeeCupImage = new ImageFiles();
        ButtonStyle buttonStyle = new ButtonStyle();
        CheckBoxes checkBoxes = new CheckBoxes();
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
        panelForCheckBoxes.add(checkBoxes.createCheckBox1());
        panelForCheckBoxes.add(checkBoxes.createCheckBox2());
        panelForCheckBoxes.add(checkBoxes.createCheckBox3());
        panelForCheckBoxes.add(Box.createRigidArea(new Dimension(0,60)));
        panelForButton.add(buttonStyle.buyButton(panelForHoldEveryElementInFirstPage));
        panelForButton.add(buttonStyle.fillButton(panelForHoldEveryElementInFirstPage));
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
        CoffeeMachine coffee = new CoffeeMachine();
        ButtonStyle buttonStyle = new ButtonStyle();
        SizePageMain = new JPanel();
        JPanel SizeSelectPanel = new JPanel();
        JPanel BackPanel = new JPanel();
        JPanel priceMainPanel = new JPanel();
        JPanel priceShowPanel = new JPanel();
        JPanel buyCoffeeButton = new JPanel();
        JLabel priceText = new JLabel("Price");
        JLabel price = new JLabel("฿ " + coffee.getPrice());
        SizeSelectPanel.setLayout(new FlowLayout());
        SizePageMain.setLayout(new BoxLayout(SizePageMain,BoxLayout.Y_AXIS));
        priceShowPanel.setLayout(new BoxLayout(priceShowPanel ,BoxLayout.Y_AXIS));
        priceMainPanel.setLayout(new BoxLayout(priceMainPanel ,BoxLayout.X_AXIS));
        priceMainPanel.setBackground(color);
        buyCoffeeButton.setBackground(color);
        priceMainPanel.setBackground(color);
        SizeSelectPanel.add(buttonStyle.SizeSButton());
        SizeSelectPanel.add(buttonStyle.SizeSButton());
        SizeSelectPanel.add(buttonStyle.SizeSButton());
        BackPanel.add(buttonStyle.backButton(panelForHoldEveryElementInFirstPage));
        priceShowPanel.add(priceText);
        priceShowPanel.add(Box.createRigidArea(new Dimension(0,15)));
        priceShowPanel.add(price);
        buyCoffeeButton.add(buttonStyle.finalBuyButton());
        priceMainPanel.add(priceShowPanel);
        priceMainPanel.add(Box.createRigidArea(new Dimension(210,0)));
        priceMainPanel.add(buyCoffeeButton);
        SizePageMain.add(SizeSelectPanel);
        SizePageMain.add(BackPanel);
        SizePageMain.add(priceMainPanel);
        frame.add(SizePageMain);
    }



    public static void main(String[] args){
        new MainFrame();
    }


}
