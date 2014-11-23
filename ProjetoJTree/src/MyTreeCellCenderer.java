
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lhries
 */
public class MyTreeCellCenderer extends DefaultTreeCellRenderer{

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus); //To change body of generated methods, choose Tools | Templates.
        if(leaf)
            setIcon(createImageIcon("/imagem/city.png","city"));
        else{
            DefaultMutableTreeNode node =
                (DefaultMutableTreeNode)value;
             if(node.equals(tree.getModel().getRoot()))   
                 setIcon(createImageIcon("/imagem/brasil.png","brasil"));
             else{
                 setIcon(createImageIcon("/imagem/state.png","state"));
             }
        }
        
        return this;
    }
    protected static ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = MyTreeCellCenderer.class.getResource(path);
        
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }    

    
}
