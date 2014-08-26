
package ucdiagram;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class JanelaPrincipal extends JFrame {
    
    private JToolBar barraFerramentas;
    private JToggleButton Select, Actor, UseCase, Association, Dependecy, Line, Text;
    TelaDesenho telaDesenho;
    
    public JanelaPrincipal(){
        
       setTitle("UCDiagram - Sistema de Cadastro");             // nome inicial
       setSize(600,400);                                        // tamanho da tela
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       menuOpcoes();                                            // inclui componentes na janela principal
       setLocationRelativeTo(null);                             // localiza no centro da tela
       setVisible(true);                                        // seta como visivel
    }
    
    public void menuOpcoes(){

        telaDesenho = new TelaDesenho();
        getContentPane().add(telaDesenho);
        telaDesenho.addMouseListener(new TratadorMouse());
        telaDesenho.addMouseMotionListener(new TratadorMouse());
        getContentPane().add(new JScrollPane(telaDesenho));
        
        JMenuBar menubar = new JMenuBar();

        // mostra menu FILE  
        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);

        // mostra menu EDIT
        JMenu menuEdit = new JMenu("Edit");
        menuEdit.setMnemonic(KeyEvent.VK_E);

        // mostra menu HELP
        JMenu menuHelp = new JMenu("Help");
        menuHelp.setMnemonic(KeyEvent.VK_H);
      
        // mostra subMenu FILE NEW
        JMenuItem menuFileNew = new JMenuItem("New");// aqui insere o icone tambem
        menuFile.add(menuFileNew);
        menuFileNew.setMnemonic(KeyEvent.VK_N);        
        menuFileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        menuFileNew.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                menuFileNew();
            }
        });
        // mostra subMenu FILE OPEN
        JMenuItem menuFileOpen = new JMenuItem(TrataMenu.Open);// aqui insere o icone tambem
        menuFile.add(menuFileOpen);
        menuFileOpen.setName("Open");
        menuFileOpen.setMnemonic(KeyEvent.VK_O);        
        menuFileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menuFileOpen.addActionListener(new TrataMenu());
        
        // mostra subMenu FILE SAVE
        JMenuItem menuFileSave = new JMenuItem(TrataMenu.Save);// aqui insere o icone tambem
        menuFile.add(menuFileSave);
        menuFileSave.setName("Save");
        menuFileSave.setMnemonic(KeyEvent.VK_S);
        menuFileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        menuFileSave.addActionListener(new TrataMenu());
        
        // mostra subMenu FILE EXIT
        JMenuItem menuFileExit = new JMenuItem("Exit");// aqui insere o icone tambem
        menuFile.add(menuFileExit);
        menuFileExit.setMnemonic(KeyEvent.VK_E);        
        menuFileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        menuFileExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        // mostra subMenu EDIT CLEAN
        JMenuItem menuEditClean = new JMenuItem("Clean");// aqui insere o icone tambem
        menuEdit.add(menuEditClean);
        menuEditClean.setMnemonic(KeyEvent.VK_X);        
        menuEditClean.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        menuEditClean.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                menuEditClean();
            }
        });
        
        // mostra subMenu HELP INGLES
        JMenuItem menuHelpEnglish = new JMenuItem("English");// aqui insere o icone tambem
        menuHelp.add(menuHelpEnglish);
        menuHelpEnglish.setMnemonic(KeyEvent.VK_E);
        menuHelpEnglish.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.SHIFT_MASK));
        menuHelpEnglish.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                menuHelpEnglish();
            }
        });
        
        // mostra subMenu HELP INGLES
        JMenuItem menuHelpPortuguese = new JMenuItem("Portuguese");// aqui insere o icone tambem
        menuHelp.add(menuHelpPortuguese);
        menuHelpPortuguese.setMnemonic(KeyEvent.VK_P);        
        menuHelpPortuguese.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.SHIFT_MASK));
        menuHelpPortuguese.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                menuHelpPortuguese();
            }
        });
        
        // insere na janela principal os elementos criados
        menubar.add(menuFile);
        menubar.add(menuEdit);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(menuHelp);
        
        // monta toda a janela
        setJMenuBar(menubar);
    }
    
    void menuFileNew(){
        toolbarMenu();
    }
    
    private class TrataMenu implements ActionListener{ 
        
        public static final String Open="Open";
        public static final String Save="Save";
       
        @Override
        public void actionPerformed(ActionEvent e) {
            
            JComponent componente = (JComponent) e.getSource();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            
            switch(componente.getName()){
                case Open:
                    int returnVa = fileChooser.showOpenDialog(JanelaPrincipal.this);
                    if (returnVa == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try {
                            telaDesenho.carregaDados(file);
                            telaDesenho.repaint();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(JanelaPrincipal.this, "Erro ao ler do arquivo");
                        }
                    }
                    break;
                case Save:
                    int returnVal = fileChooser.showSaveDialog(JanelaPrincipal.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try {
                            telaDesenho.salvarDados(file);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(JanelaPrincipal.this, "Erro ao salvar no arquivo");
                        }
                    }
                    break;
            }
        }
   }
    
    void menuEditClean(){
        telaDesenho.limpar();
        getContentPane().repaint();
    }
    void menuHelpEnglish(){
        JOptionPane.showMessageDialog(null,"Menu Help INGLES");
    }
    void menuHelpPortuguese(){
        JOptionPane.showMessageDialog(null,"Menu Help PORTUGUES");
    }
    
    public void toolbarMenu(){
        
        ButtonGroup botaoGrupo = new ButtonGroup();
        barraFerramentas = new JToolBar();
        
        // cria botão select
        Select = new JToggleButton(createImageIcon("/imagens/Select.png","Select"), false);
        botaoGrupo.add(Select);
        barraFerramentas.add(Select);
        // cria botão actor
        Actor = new JToggleButton(createImageIcon("/imagens/Actor.png","Actor"), false);
        botaoGrupo.add(Actor);
        barraFerramentas.add(Actor);
        // cria botão usecase
        UseCase = new JToggleButton(createImageIcon("/imagens/UseCase.png","UseCase"), false);
        botaoGrupo.add(UseCase);
        barraFerramentas.add(UseCase);        
        // cria botão association
        Association = new JToggleButton(createImageIcon("/imagens/Association.png","Association"), false);
        botaoGrupo.add(Association);
        barraFerramentas.add(Association);
        // cria botão dependecy
        Dependecy = new JToggleButton(createImageIcon("/imagens/Dependecy.png","Dependecy"), false);
        botaoGrupo.add(Dependecy);
        barraFerramentas.add(Dependecy);
        // cria botão line
        Line = new JToggleButton(createImageIcon("/imagens/Line.png","Line"), false);
        botaoGrupo.add(Line);
        barraFerramentas.add(Line);
        // cria botão text
        Text = new JToggleButton(createImageIcon("/imagens/Text.png","Text"), false);
        botaoGrupo.add(Text);
        barraFerramentas.add(Text);
        
        barraFerramentas.setFloatable(false); // deixa o toolbar fixo na tela
        getContentPane().add(barraFerramentas,BorderLayout.SOUTH);
        getContentPane().revalidate();
    }
    
    protected static ImageIcon createImageIcon(String path,String description) {
        java.net.URL imgURL = JanelaPrincipal.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } 
        else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    private class TratadorMouse extends MouseAdapter{
        
        public final static int TAMANHO = 50;
        
        public void mousePressed(MouseEvent e) {
            
            int x = e.getX();
            int y = e.getY();
            int tam = TAMANHO;
            
            super.mouseReleased(e);
            if(Select != null && Select.isSelected()){
                
                telaDesenho.verificaSelecao(x, y);
            }            
            else if(Actor != null && Actor.isSelected()){
                
                //Ator a = new Ator(x, y, tam);
                //telaDesenho.add(new Ator(x, y, tam));
                //telaDesenho.addFigura();
                JOptionPane.showMessageDialog(null,"Actor");
            }            
            else if(UseCase != null && UseCase.isSelected()){
                
                Circulo c = new Circulo(x, y, tam);
                telaDesenho.addFigura(c);
                
            }
            else if(Association != null && Association.isSelected()){
                JOptionPane.showMessageDialog(null,"Association");
            }            
            else if(Dependecy != null && Dependecy.isSelected()){
                JOptionPane.showMessageDialog(null,"Dependecy");
            }            
            else if(Line != null && Line.isSelected()){
                JOptionPane.showMessageDialog(null,"Line");
            }
            else if(Text != null && Text.isSelected()){
                
                String texto = JOptionPane.showInputDialog("Texto: ");
                Texto t = new Texto(x, y, texto);
                telaDesenho.addFigura(t);
            }
            else
                JOptionPane.showMessageDialog(null,"Nenhum botão selecionado");
            
            telaDesenho.repaint();
        }
        public void mouseDragged(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            if(Select != null && Select.isSelected()){
                
                Figura figura = telaDesenho.getSelecionado();
                if(figura!=null)
                    figura.moveTo(x, y);
            }
            else if(Actor != null && Actor.isSelected()){
                
                Figura figura = telaDesenho.getSelecionado();
                if(figura!=null)
                    figura.moveTo(x, y);
            }
            telaDesenho.repaint();
        }
    }
}

