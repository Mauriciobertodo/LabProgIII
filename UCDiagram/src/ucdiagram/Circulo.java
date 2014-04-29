
package ucdiagram;

import java.awt.Graphics;

public class Circulo extends Figura{
    int xIni, yIni;
    int tam=10;
   
    public Circulo(int x, int y) {
        this.xIni = x;
        this.yIni = y;
    }    
    @Override
    public void desenha(Graphics g) {
        g.fillOval(xIni, yIni, tam, tam);
    }
}
