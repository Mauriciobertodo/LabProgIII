
package meufluxograma;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class JanelaPrincipal extends JFrame{
    
    private JToolBar barraFerramentas;
    private JToggleButton setaDireita, setaEsquerda, setaCima, setaBaixo,del;
    private JToggleButton Selecionar, Conector, Decisao, Terminacao, Processo, ProcessoAlt, ProcessoPred, Seta, Text;
    TelaDesenho telaDesenho;
    
    public JanelaPrincipal(){
        
       setTitle("Meu Fluxograma");             
       setSize(900,650);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       menuOpcoes();     
       setLocationRelativeTo(null);
       setVisible(true);
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
    
    void menuEditClean(){
        telaDesenho.limpar();
        getContentPane().repaint();
    }
    
    public void toolbarMenu(){
    
        ButtonGroup botaoGrupo = new ButtonGroup();
        barraFerramentas = new JToolBar();
        barraFerramentas.setOrientation(JToolBar.VERTICAL);
        
        Selecionar = new JToggleButton(createImageIcon("/imagens/Select.png","Selecionar"), true);
        botaoGrupo.add(Selecionar);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(Selecionar);
        
        Terminacao = new JToggleButton(createImageIcon("/imagens/terminacao.png","Terminacao"), false);
        botaoGrupo.add(Terminacao);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(Terminacao);
        
        Conector = new JToggleButton(createImageIcon("/imagens/conector.png","Conector"), false);
        botaoGrupo.add(Conector);
        barraFerramentas.add(Box.createVerticalStrut(5));
        
        barraFerramentas.add(Conector);
        
        Decisao = new JToggleButton(createImageIcon("/imagens/decisao.png","Decisao"), false);
        botaoGrupo.add(Decisao);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(Decisao);
        
        Processo = new JToggleButton(createImageIcon("/imagens/processo.png","Processo"), false);
        botaoGrupo.add(Processo);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(Processo);
        
        ProcessoAlt = new JToggleButton(createImageIcon("/imagens/processoAlternativo.png","ProcessoAlt"), false);
        botaoGrupo.add(ProcessoAlt);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(ProcessoAlt);
        
        ProcessoPred = new JToggleButton(createImageIcon("/imagens/processoPredefinido.png","ProcessoAlt"), false);
        botaoGrupo.add(ProcessoPred);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(ProcessoPred);
                
        setaCima = new JToggleButton(createImageIcon("/imagens/setaCima.png","setaCima"), false);
        botaoGrupo.add(setaCima);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(setaCima);
        
        setaDireita = new JToggleButton(createImageIcon("/imagens/setaDireita.png","setaDireita"), false);
        botaoGrupo.add(setaDireita);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(setaDireita);
        
        setaEsquerda = new JToggleButton(createImageIcon("/imagens/setaEsquerda.png","setaEsquerda"), false);
        botaoGrupo.add(setaEsquerda);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(setaEsquerda);
        
        setaBaixo = new JToggleButton(createImageIcon("/imagens/setaBaixo.png","setaBaixo"), false);
        botaoGrupo.add(setaBaixo);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(setaBaixo);
        
        del = new JToggleButton(createImageIcon("/imagens/limpar.png","del"), false);
        botaoGrupo.add(del);
        barraFerramentas.add(Box.createVerticalStrut(5));
        barraFerramentas.add(del);
        
        barraFerramentas.setFloatable(false); // deixa o toolbar fixo na tela
        getContentPane().add(barraFerramentas,BorderLayout.WEST);
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
                    Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                    break;
            }
        }
   }
    
    private class TratadorMouse extends MouseAdapter{
        
        public final static int TAMANHO = 50;
        
        public void mousePressed(MouseEvent e) {
            
            int x = e.getX();
            int y = e.getY();
            int tam = TAMANHO;
            
            super.mouseReleased(e);
            if(Selecionar != null && Selecionar.isSelected()){
                
                telaDesenho.verificaSelecao(x, y);                
            }            
            else if(Terminacao != null && Terminacao.isSelected()){
                
                Figura imagem = new Figura("terminacao", x, y);
                telaDesenho.addFigura(imagem);                
            }
            else if(Decisao != null && Decisao.isSelected()){
                
                Figura imagem = new Figura("decisao", x, y);
                telaDesenho.addFigura(imagem);
                
                String texto = JOptionPane.showInputDialog("Decisão: ");
                Texto t = new Texto(x, y, texto);
                telaDesenho.addFigura(t);
            }
            else if(Conector != null && Conector.isSelected()){
                
                Figura imagem = new Figura("conector", x, y);
                telaDesenho.addFigura(imagem);
            }
            else if(Processo != null && Processo.isSelected()){
                
                Figura imagem = new Figura("processo", x, y);
                telaDesenho.addFigura(imagem);
                
                String texto = JOptionPane.showInputDialog("Decisão: ");
                Texto t = new Texto(x, y, texto);
                telaDesenho.addFigura(t);
            }
            else if(ProcessoAlt != null && ProcessoAlt.isSelected()){
                
                Figura imagem = new Figura("processoAlternativo", x, y);
                telaDesenho.addFigura(imagem);
                
                String texto = JOptionPane.showInputDialog("Decisão: ");
                Texto t = new Texto(x, y, texto);
                telaDesenho.addFigura(t);
            }
            else if(ProcessoPred != null && ProcessoPred.isSelected()){
                
                Figura imagem = new Figura("processoPredefinido", x, y);
                telaDesenho.addFigura(imagem);
                
                String texto = JOptionPane.showInputDialog("Decisão: ");
                Texto t = new Texto(x, y, texto);
                telaDesenho.addFigura(t);
            }
            else if(setaCima != null && setaCima.isSelected()){
                
                Figura imagem = new Figura("setaCima", x, y);
                telaDesenho.addFigura(imagem);
            }
            else if(setaDireita != null && setaDireita.isSelected()){
                
                Figura imagem = new Figura("setaDireita", x, y);
                telaDesenho.addFigura(imagem);
            }
            else if(setaEsquerda != null && setaEsquerda.isSelected()){
                
                Figura imagem = new Figura("setaEsquerda", x, y);
                telaDesenho.addFigura(imagem);
            }
            else if(setaBaixo != null && setaBaixo.isSelected()){
                
                Figura imagem = new Figura("setaBaixo", x, y);
                telaDesenho.addFigura(imagem);
            }
            else if(del != null && del.isSelected()){
                menuEditClean();
            }
            telaDesenho.repaint();
        }
        
        public void mouseDragged(MouseEvent e){
            
            int x = e.getX();
            int y = e.getY();
            
            if(Selecionar != null && Selecionar.isSelected()){
                
                Figura figura = telaDesenho.getSelecionado();
                if(figura!=null){
                    figura.moveTo(x, y);
                }
            }
            telaDesenho.repaint();
        }
    }
}
