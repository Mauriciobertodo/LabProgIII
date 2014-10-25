
package meufluxograma;

import java.awt.Graphics;

public class Terminacao extends Figura{
    
    public Terminacao(int posX, int posY) {
        super(posX, posY);
    }
    
    private int tam;
        
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
        
        //Image myImage = new ImageIcon("/imagens/decisao.png").getImage();
        //BufferedImage bufferedImage = new BufferedImage(myImage.getHeight((ImageObserver) this), myImage.getWidth((ImageObserver) this), BufferedImage.TYPE_BYTE_GRAY);

        //Graphics gi = bufferedImage.getGraphics();
        //gi.drawImage(myImage, 0, 0, null);
        //gi.dispose();

        //Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(bufferedImage, null, 0, 0);
    }
    
}
