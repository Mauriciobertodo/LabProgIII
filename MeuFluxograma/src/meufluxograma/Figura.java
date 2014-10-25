
package meufluxograma;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Figura implements Serializable{
    
    protected int posX, posY;
    protected String tipo;
    protected boolean selecionado;
    int tam = 40;
    
    public Figura(String tipo, int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        this.tipo = tipo;
        selecionado = false;
    }
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
    
    public String getTipo() {
        return tipo;
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
    
    public void desenha(Graphics g){
        try { 
            BufferedImage img = ImageIO.read(Figura.class.getResource("/imagens/"+tipo+".png"));
            img.getHeight();
            g.drawImage(img, posX, posY, null);
            
        } catch (IOException ex) {
            Logger.getLogger(Figura.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public boolean intersecta(int x, int y){
        
        if (x < posX) return false;
        if (x > (posX + tam)) return false;
        if (y < posY) return false;
        if (y > (posY + tam)) return false;
        return true;
    }
}
