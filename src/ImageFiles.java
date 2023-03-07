
import javax.swing.*;
import java.io.File;

public class ImageFiles {
    private File latteFile = new File("lat.png");
    private File capuccinoFile = new File("cap.png");
    private File espressoFile = new File("es.png");
    private File turFile = new File("t.png");
    private JLabel latte,capuccino,espresso;

    private ImageIcon tur;


    public ImageFiles(){
        latte = new JLabel( new ImageIcon(((new ImageIcon(getLatteAbsolutePath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        capuccino = new JLabel( new ImageIcon(((new ImageIcon(getCapuccinoPath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        espresso = new JLabel( new ImageIcon(((new ImageIcon(getEspressoPath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        tur = new ImageIcon(((new ImageIcon(getTurtlePath()).getImage()).getScaledInstance( 60, 60, java.awt.Image.SCALE_SMOOTH)));
    }

    public JLabel getLatteLabel(){
        return this.latte;
    }
    public JLabel getCapuccino(){
        return this.capuccino;
    }
    public JLabel getEspresso(){
        return this.espresso;
    }
    public ImageIcon getTurtle(){
        return this.tur;
    }

    public String getLatteAbsolutePath(){
        return this.latteFile.getAbsolutePath();
    }
    public String getCapuccinoPath(){
        return this.capuccinoFile.getAbsolutePath();
    }
    public String getEspressoPath(){
        return this.espressoFile.getAbsolutePath();
    }

    public String getTurtlePath(){
        return  this.turFile.getAbsolutePath();
    }

}
