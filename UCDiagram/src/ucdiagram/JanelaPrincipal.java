
package ucdiagram;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class JanelaPrincipal extends JFrame {
    
    private JTextArea textoArea;
    private JToolBar barraFerramentas;
    
    public JanelaPrincipal(){
        
       setTitle("UCDiagram - Sistema de Cadastro");            // nome inicial
       setSize(600,400);               // tamanho da tela
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       menuOpcoes();                   // inclui componentes na janela principal
       setLocationRelativeTo(null);    // localiza no centro da tela
       setVisible(true);               // seta como visivel
    }
    public void menuOpcoes(){

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
        
        // mostra subMenu FILE SAVE
        JMenuItem menuFileSave = new JMenuItem("Save");// aqui insere o icone tambem
        menuFile.add(menuFileSave);
        menuFileSave.setMnemonic(KeyEvent.VK_S);
        menuFileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menuFileSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                menuFileSave();
            }
        });
        
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
        menuEditClean.setMnemonic(KeyEvent.VK_C);        
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
        JOptionPane.showMessageDialog(null,"Menu  Novo");
    }
    void menuFileSave(){
        JOptionPane.showMessageDialog(null,"Menu Salvar");
    }
    void menuEditClean(){
        JOptionPane.showMessageDialog(null,"Menu Limpa tela");
    }
    void menuHelpEnglish(){
        JOptionPane.showMessageDialog(null,"Menu Help INGLES");
    }
    void menuHelpPortuguese(){
        JOptionPane.showMessageDialog(null,"Menu Help PORTUGUES");
    }
}
