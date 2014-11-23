/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;

/**
 *
 * @author lhries
 */
public class Circulo extends Figura {

    private int tam;

    public Circulo(int x, int y, int tam) {
        super(x, y);
        this.tam = tam;
    }

    public boolean intersecta(int x, int y) {
        if (x < posX) return false;
        if (x > (posX + tam)) return false;
        if (y < posY) return false;
        if (y > (posY + tam)) return false;
        return true;

    }

    public void desenha(Graphics g) {
        g.fillOval(posX, posY, tam, tam);
        if (this.estaSelecionado()) {
            g.drawOval(posX-2,posY-2,4,4);
            g.drawOval(posX-2,posY+tam-2,4,4);
            g.drawOval(posX+tam-2,posY-2,4,4);
            g.drawOval(posX+tam-2,posY+tam-2,4,4);

        }
    }

}
//            Graphics2D g2 = (Graphics2D) g;
//            float dash1[] = {20.0f};
//            BasicStroke dashed
//                    = new BasicStroke(1.0f,
//                            BasicStroke.CAP_BUTT,
//                            BasicStroke.JOIN_MITER,
//                            30.0f, dash1, 0.0f);
//            g2.setStroke(dashed);
//            g2.draw(new Rectangle2D.Double(posX, posY, tam, tam));
//            g2.setStroke(new BasicStroke());