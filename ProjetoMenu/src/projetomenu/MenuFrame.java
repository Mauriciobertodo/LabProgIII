/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetomenu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author lhries
 */
class MenuFrame extends JFrame{

    private JTextArea textoArea;
    private JToolBar barraFerramentas;
    private JPopupMenu menuPopup;    
//    private JPopupMenu menuPopup2;    
    public MenuFrame() {
        super("Trabalhando com menus");
        
        iniciaComponentes();
        iniciaMenu();
        iniciaPopupMenu();
//        iniciaPopupMenu2();
        
        addMouseListener(new TratadorMouse());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200,200);
        setSize(300,300);
        setVisible(true);
        
    }

    private void iniciaMenu() {
        JMenuBar menubar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic(KeyEvent.VK_A);
        
        JMenu menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic(KeyEvent.VK_J);
        
        ImageIcon icone = createImageIcon("/imagem/sair.png","Sair");
        
        JMenuItem menuItemSair = new JMenuItem("s",icone);
        menuArquivo.add(menuItemSair);
        menuItemSair.setMnemonic(KeyEvent.VK_S);
        menuItemSair.setAccelerator(
            KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK)
        );
        menuItemSair.setToolTipText("Sair da aplicação");
        menuItemSair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
                
        menubar.add(menuArquivo);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(menuAjuda);
        

        setJMenuBar(menubar);
    }

    protected static ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = MenuFrame.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }    

    private void iniciaComponentes() {
        textoArea = new JTextArea();
        textoArea.setEditable(false);
        textoArea.addMouseListener(new TratadorMouse());
        getContentPane().add(textoArea);
        
        barraFerramentas = new JToolBar();
        barraFerramentas.add(new JButton("Novo"));
        barraFerramentas.add(new JButton("Editar"));
        barraFerramentas.add(new JButton("Remover"));
        barraFerramentas.add(Box.createHorizontalGlue());
        barraFerramentas.add(new JButton(createImageIcon("/imagem/sair.png","Sair")));
        barraFerramentas.setRollover(true);
        getContentPane().add(barraFerramentas,BorderLayout.NORTH);
        
        
        
    }

    private void iniciaPopupMenu() {
        menuPopup = new JPopupMenu();
        JMenu menuItemTexto = new JMenu("Adicionar");
        menuItemTexto.add("Texto");
        menuPopup.add(menuItemTexto);
        JMenuItem menuItemSair = new JMenuItem("Sair");
        menuPopup.add(menuItemSair);
        
    }
//
//    private void iniciaPopupMenu2() {
//        menuPopup2 = new JPopupMenu();
//        JMenuItem menuItemSair = new JMenuItem("Sair");
//        menuItemSair.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//        menuPopup2.add(menuItemSair);
//        
//    }
//    
    private class TratadorMouse extends MouseAdapter{

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) 
            { 
                if(e.getComponent() instanceof JTextArea)
                    menuPopup.show(e.getComponent(), e.getX(), e.getY()); 
                else{}
                    //menuPopup2.show(e.getComponent(), e.getX(), e.getY()); 
            } 

        }
        
    }


    
}
