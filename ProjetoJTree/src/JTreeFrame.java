
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
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
class JTreeFrame extends JFrame {

    public JTreeFrame() {
        super("Exemplo JTree");

        iniciaComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }

    private void iniciaComponentes() {
        DefaultMutableTreeNode nodoRaiz = new DefaultMutableTreeNode("Brasil");

        DefaultMutableTreeNode nodoEstadoRS = new DefaultMutableTreeNode("Rio Grande do Sul");

        DefaultMutableTreeNode nodoCidadePOA = new DefaultMutableTreeNode("Porto Alegre");
        nodoEstadoRS.add(nodoCidadePOA);
        DefaultMutableTreeNode nodoCidadeEldorado = new DefaultMutableTreeNode("Eldorado");
        nodoEstadoRS.add(nodoCidadeEldorado);

        nodoRaiz.add(nodoEstadoRS);

        DefaultMutableTreeNode nodoEstadoSC = new DefaultMutableTreeNode("Santa Catarina");

        nodoRaiz.add(nodoEstadoSC);

        DefaultMutableTreeNode nodoCidadeFloripa = new DefaultMutableTreeNode("Florianopolis");
        nodoEstadoSC.add(nodoCidadeFloripa);
        DefaultMutableTreeNode nodoCidadeCriciuma = new DefaultMutableTreeNode("Criciuma");
        nodoEstadoSC.add(nodoCidadeCriciuma);

        //DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        //renderer.setLeafIcon(createImageIcon("/imagem/tree.png","tree"));
        final JTree tree = new JTree(nodoRaiz);
        tree.setCellRenderer(new MyTreeCellCenderer());
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
        
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //System.out.println(e.getPath().toString());
                DefaultMutableTreeNode nodoSelected = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
                System.out.println(nodoSelected.toString());
            }
        });

        getContentPane().add(new JScrollPane(tree));
        //System.out.println(nodoRaiz.getChildAt(1).getChildAt(0));

        for (int i = 0; i < nodoRaiz.getChildCount(); i++) {
            System.out.println(nodoRaiz.getChildAt(i));
        }

    }

    protected static ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = JTreeFrame.class.getResource(path);

        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
