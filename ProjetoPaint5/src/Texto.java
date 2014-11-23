
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lhries
 */
public class Texto extends Figura {

    protected String texto;
    protected Font fonte;

    public Texto(int x, int y, String texto) {
        super(x, y);
        this.texto = texto;
        this.fonte = new Font("Helvetica", Font.PLAIN, 12);
    }

    @Override
    public boolean intersecta(int x, int y) {
        if (x < posX) {
            return false;
        }
        if (x > (posX + getLargura())) {
            return false;
        }
        if (y < (posY-getAltura())) {
            return false;
        }
        if (y > posY) {
            return false;
        }
        return true;

    }

    public int getAltura() {
        FontMetrics metrics = new JLabel().getFontMetrics(fonte);
        return(metrics.getHeight() + 2);
    }

    public int getLargura() {
        FontMetrics metrics = new JLabel().getFontMetrics(fonte);
           return (metrics.stringWidth(texto) + 2);
    
    }

    @Override
    public void desenha(Graphics g) {
        g.setFont(fonte);
        g.drawString(texto, posX, posY);
        if (selecionado) {
            int altura = this.getAltura();
            int largura = this.getLargura();

            g.drawOval(posX - 2, posY - altura, 4, 4);
            g.drawOval(posX - 2, posY, 4, 4);
            g.drawOval(posX + largura - 2, posY - altura, 4, 4);
            g.drawOval(posX + largura - 2, posY, 4, 4);

        }

    }

}

//// get metrics from the graphics
//FontMetrics metrics = graphics.getFontMetrics(font);
//// get the height of a line of text in this
//// font and render context
//int hgt = metrics.getHeight();
//// get the advance of my text in this font
//// and render context
//int adv = metrics.stringWidth(text);
//// calculate the size of a box to hold the
//// text with some padding.
//Dimension size = new Dimension(adv+2, hgt+2);
