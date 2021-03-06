
package ucdiagram;

import java.awt.Graphics;
import java.io.Serializable;

abstract class Figura implements Serializable{
    protected int posX, posY;
    protected boolean selecionado;
    
    public Figura(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        selecionado = false;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    public boolean estaSelecionado(){
        return(selecionado);
    }
    
    public void selecionar(){
        selecionado = true;
    }

    public void deselecionar(){
        selecionado = false;
    }
    
    public void moveTo(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;        
    }
    
    public abstract void desenha(Graphics g);
    public abstract boolean intersecta(int x, int y);

    void paintComponent(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
