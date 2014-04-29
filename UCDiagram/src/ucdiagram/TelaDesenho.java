package ucdiagram;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class TelaDesenho extends JPanel{
    List<Figura> listaFiguras;
    
    public TelaDesenho(){     
        listaFiguras = new ArrayList<Figura>();
    }
    
    public void addFigura(Figura figura){
        listaFiguras.add(figura);
    }
    
    public void clearTela(){
        listaFiguras.clear();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, 584,298);
        //g.setColor(Color.WHITE);
        for(Figura f:listaFiguras)
            f.desenha(g);
    }
}
