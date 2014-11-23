/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 *
 * @author lhries
 */
public class DesenhoFrame extends JFrame {

    TelaDesenho desenho;
    JToggleButton botaoSelecionar, botaoCirculo, botaoQuadrado, botaoTexto;
    JButton botaoLimpar;
    JToolBar barraFerramentas;

    public DesenhoFrame() {
        super("Desenho Frame");

        iniciaComponentes();
        iniciaMenu();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    private void iniciaComponentes() {

        ButtonGroup botaoGrupo = new ButtonGroup();

        barraFerramentas = new JToolBar();
        botaoSelecionar = new JToggleButton("Selecionar", false);        
        botaoGrupo.add(botaoSelecionar);
        barraFerramentas.add(botaoSelecionar);

        botaoCirculo = new JToggleButton("Circulo", true);
        botaoCirculo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.deselecionarFiguras();
            }
        });
        botaoGrupo.add(botaoCirculo);
        barraFerramentas.add(botaoCirculo);

        botaoQuadrado = new JToggleButton("Quadrado");
        botaoQuadrado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.deselecionarFiguras();
            }
        });
        botaoGrupo.add(botaoQuadrado);
        barraFerramentas.add(botaoQuadrado);

        botaoTexto = new JToggleButton("Texto");
        botaoTexto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.deselecionarFiguras();
            }
        });
        botaoGrupo.add(botaoTexto);
        barraFerramentas.add(botaoTexto);

        barraFerramentas.add(Box.createHorizontalGlue());

        botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                desenho.limpar();
                desenho.repaint();
            }

        });
        barraFerramentas.add(botaoLimpar);

        getContentPane().add(barraFerramentas, BorderLayout.NORTH);

        desenho = new TelaDesenho();
        desenho.addMouseListener(new TrataMouse());
        desenho.addMouseMotionListener(new TrataMouse());
        getContentPane().add(desenho);

    }
    
    private void iniciaMenu(){
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuArquivo = new JMenu("Arquivo");
        
        JMenuItem menuItemNovo = new JMenuItem(TrataMenu.NOVO);
        menuItemNovo.setName(TrataMenu.NOVO);
        menuItemNovo.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemNovo);
        
        JMenuItem menuItemAbrir = new JMenuItem(TrataMenu.ABRIR);
        menuItemAbrir.setName(TrataMenu.ABRIR);
        menuItemAbrir.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemAbrir);
        
        JMenuItem menuItemSalvar = new JMenuItem(TrataMenu.SALVAR);
        menuItemSalvar.setName(TrataMenu.SALVAR);
        menuItemSalvar.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemSalvar);
        
        JMenuItem menuItemSair = new JMenuItem(TrataMenu.SAIR);
        menuItemSair.setName(TrataMenu.SAIR);
        menuItemSair.addActionListener(new TrataMenu());
        menuArquivo.add(menuItemSair);
        
        menuBar.add(menuArquivo);
        setJMenuBar(menuBar);
        
    }

    private class TrataMouse extends MouseAdapter {

        public final static int TAMANHO = 30;

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            int tam = TAMANHO;            
            
            if(botaoSelecionar.isSelected()){
                desenho.verificaSelecao(x, y);
            }
            else if (botaoCirculo.isSelected()) {
                Circulo c = new Circulo(x, y, tam);
                desenho.addFigura(c);
            } else if (botaoQuadrado.isSelected()) {
                Quadrado q = new Quadrado(x, y, tam);
                desenho.addFigura(q);
            } else if (botaoTexto.isSelected()) {
                String texto = JOptionPane.showInputDialog("Texto:");
                Texto t = new Texto(x, y, texto);
                desenho.addFigura(t);

            }

            desenho.repaint();

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if(botaoSelecionar.isSelected()){
                
                Figura figura = desenho.getSelecionado();
                if(figura!=null)
                    figura.moveTo(x, y);
            }            
            desenho.repaint();
        }
    }
    
    private class TrataMenu implements ActionListener{
        public static final String NOVO="Novo";
        public static final String ABRIR="Abrir";
        public static final String SALVAR="Salvar";
        public static final String SAIR="Sair";
        @Override
        public void actionPerformed(ActionEvent e) {
            JComponent componente = (JComponent) e.getSource();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            switch(componente.getName()){
                case NOVO:
                    desenho.limpar();
                    break;
                case ABRIR:
                    
                    int returnVa = fileChooser.showOpenDialog(DesenhoFrame.this);

                    if (returnVa == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try {
                            desenho.carregaDados(file);
                            desenho.repaint();
                            JOptionPane.showMessageDialog(DesenhoFrame.this, "Arquivo carregado com sucesso!");
                        } catch (Exception exc) {
                            JOptionPane.showMessageDialog(DesenhoFrame.this, "Erro ao ler do arquivo");
                        }
                    }
                    break;
                case SALVAR:
                    int returnVal = fileChooser.showSaveDialog(DesenhoFrame.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try {
                            desenho.salvarDados(file);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(DesenhoFrame.this, "Erro ao salvar no arquivo");
                        }
                    }
                    break;
                case SAIR:
                    System.exit(0);
                    break;
            }
        }        
    }
}
