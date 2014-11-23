/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodesenho;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/**
 *
 * @author lhries
 */
class DesenhoFrame extends JFrame{
    TelaDesenho telaDesenho;
    JToolBar barraFerramentas;
    JButton ferramentaCirculo, ferramentaQuadrado, ferramentaLimpar;
    
    public DesenhoFrame() {
        super("Tela de Desenho");
        iniciaComponentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);    
    }

    private void iniciaComponentes() {
        telaDesenho = new TelaDesenho();
        getContentPane().add(telaDesenho);
        
        TratadorBotoes tratadorBotoes = new TratadorBotoes();
        
        barraFerramentas = new JToolBar();
        ferramentaCirculo = new JButton("Circulo");
        ferramentaCirculo.addActionListener(tratadorBotoes);
        barraFerramentas.add(ferramentaCirculo);
        barraFerramentas.add(Box.createHorizontalStrut(10));
        
        ferramentaQuadrado = new JButton("Quadrado");
        ferramentaQuadrado.addActionListener(tratadorBotoes);
        barraFerramentas.add(ferramentaQuadrado);
        barraFerramentas.add(Box.createHorizontalStrut(10));
        
        ferramentaLimpar = new JButton("Limpar");
        ferramentaLimpar.addActionListener(tratadorBotoes);
        barraFerramentas.add(ferramentaLimpar);
        barraFerramentas.add(Box.createHorizontalStrut(10));
        
        getContentPane().add(barraFerramentas,BorderLayout.NORTH);
        
        
    }
    
    class TratadorBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(ferramentaCirculo))
            {
                int x = Integer.parseInt(JOptionPane.showInputDialog("X: "));
                int y = Integer.parseInt(JOptionPane.showInputDialog("Y: "));
                Circulo circ = new Circulo(x, y);
                
                telaDesenho.addFigura(circ);
                telaDesenho.repaint();
            }
            else if(e.getSource().equals(ferramentaQuadrado))
            {
                int x = Integer.parseInt(JOptionPane.showInputDialog("X: "));
                int y = Integer.parseInt(JOptionPane.showInputDialog("Y: "));
                int tam = Integer.parseInt(JOptionPane.showInputDialog("Tamanho: "));
                Quadrado quad = new Quadrado(x, y, tam);
                
                telaDesenho.addFigura(quad);
                telaDesenho.repaint();
                
            }
            else if(e.getSource().equals(ferramentaLimpar))
            {
                telaDesenho.limpar();
                telaDesenho.repaint();
            }
        }
        
    }
    
    
    
}
