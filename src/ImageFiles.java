

import javax.swing.*;
import java.io.File;
public class ImageFiles {
    private File latteFile = new File("lat.png");
    private File capuccinoFile = new File("cap.png");
    private File espressoFile = new File("es.png");
    private File turFile = new File("t.png");
    private File SizeSFile = new File("S.png");
    private File SizeMFile = new File("M.png");
    private File SizeLFile = new File("L.png");
    private JLabel latte,capuccino,espresso;
    private ImageIcon tur,S,M,L;
    public ImageFiles(){
        latte = new JLabel( new ImageIcon(((new ImageIcon(getLatteAbsolutePath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        capuccino = new JLabel( new ImageIcon(((new ImageIcon(getCapuccinoPath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        espresso = new JLabel( new ImageIcon(((new ImageIcon(getEspressoPath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        S = new ImageIcon(((new ImageIcon(getSizeSPath()).getImage()).getScaledInstance( 100, 100, java.awt.Image.SCALE_SMOOTH)));
        M = new ImageIcon(((new ImageIcon(getSizeMPath()).getImage()).getScaledInstance( 100, 100, java.awt.Image.SCALE_SMOOTH)));
        L = new ImageIcon(((new ImageIcon(getSizeLPath()).getImage()).getScaledInstance( 100, 100, java.awt.Image.SCALE_SMOOTH)));
        tur = new ImageIcon(((new ImageIcon(getTurtlePath()).getImage()).getScaledInstance( 60, 60, java.awt.Image.SCALE_SMOOTH)));
    }
    public JLabel getLatteLabel(){
        return this.latte;}
    public JLabel getCapuccino(){
        return this.capuccino;
    }
    public JLabel getEspresso(){
        return this.espresso;
    }
    public ImageIcon getTurtle(){
        return this.tur;
    }

    public ImageIcon getSizeS(){
        return this.S;
    }

    public ImageIcon getSizeM(){
        return this.M;
    }

    public ImageIcon getSizeL(){
        return this.L;
    }

    public String getLatteAbsolutePath(){return this.latteFile.getAbsolutePath();}
    public String getCapuccinoPath(){
        return this.capuccinoFile.getAbsolutePath();
    }
    public String getEspressoPath(){
        return this.espressoFile.getAbsolutePath();
    }
    public String getTurtlePath(){
        return  this.turFile.getAbsolutePath();
    }

    public String getSizeSPath(){
        return  this.SizeSFile.getAbsolutePath();
    }
    public String getSizeMPath(){
        return  this.SizeMFile.getAbsolutePath();
    }
    public String getSizeLPath(){
        return  this.SizeLFile.getAbsolutePath();
    }

}
