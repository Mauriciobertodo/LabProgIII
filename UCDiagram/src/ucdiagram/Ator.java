
package ucdiagram;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import sun.awt.RepaintArea;

public class Ator extends Figura {

    public Ator(int posX, int posY) {
        super(posX, posY);
    }
    
    private int tam;
    //Image image1;
    //ImageIcon i1 = new ImageIcon("/imagens/Actor.png","ActorCreate");

    //public Ator(){
    //}
        
    @Override
    public boolean intersecta(int x, int y) {
        if (x < posX) return false;
        if (x > (posX + tam)) return false;
        if (y < posY) return false;
        if (y > (posY + tam)) return false;
        return true;
    }
    
    @Override
    public void desenha(Graphics g) {
        
        Image myImage = new ImageIcon("/imagens/ActorCreate.gif").getImage();
        BufferedImage bufferedImage = new BufferedImage(myImage.getHeight((ImageObserver) this), myImage.getWidth((ImageObserver) this), BufferedImage.TYPE_BYTE_GRAY);

        Graphics gi = bufferedImage.getGraphics();
        gi.drawImage(myImage, 0, 0, null);
        gi.dispose();

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bufferedImage, null, 0, 0);
        //image1 = i1.getImage();
        //g.drawImage(image1, 20, 30, null);
    }
}
