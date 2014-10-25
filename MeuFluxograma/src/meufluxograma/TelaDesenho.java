package meufluxograma;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class TelaDesenho extends JPanel{
    
    List<Figura> listaFiguras;
    
    public TelaDesenho(){     
        listaFiguras = new ArrayList<Figura>();
    }
    
    public void addFigura(Figura f){
        listaFiguras.add(f);
    }
    
    public void limpar(){
        listaFiguras.clear();
        repaint();
    }
    
    public void verificaSelecao(int x, int y){
        for(Figura f:listaFiguras){
            if(f.intersecta(x, y)){
                deselecionarFiguras();
                f.selecionar();
            }
        }
    }
    
    public Figura getSelecionado(){
        for(Figura f:listaFiguras){
            if(f.estaSelecionado())
                return f;
        }
        return null;
    }
    public void deselecionarFiguras() {
        for(Figura f:listaFiguras)
            f.deselecionar();
        repaint();
    }   

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        for(Figura f:listaFiguras)
            f.desenha(g);
    }    
    public void carregaDados(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        listaFiguras = (List<Figura>) ois.readObject();
        ois.close();
        fis.close();
    }
    public void salvarDados(File file) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.reset();
        oos.writeObject(listaFiguras);
        oos.close();
        fos.close();
    }    
}
