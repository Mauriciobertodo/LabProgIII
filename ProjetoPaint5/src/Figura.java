/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author lhries
 */
public abstract class Figura implements Serializable{
    protected int posX, posY;
    protected boolean selecionado;
    
    public Figura(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        selecionado=false;
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
}
