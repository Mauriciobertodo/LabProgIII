package crudpessoa;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame {
    
    private JFrame janela = new JFrame();
    JList<String> listaPessoas;
    private JPanel painel = new JPanel();
    private JButton botaoNovo = new JButton("Novo");
    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoRemover = new JButton("Remover");
    
    public JanelaPrincipal(){
        
        setTitle("Pessoas");
        setSize(250,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        montaJanela(); // inclui componentes na janela principal
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void montaJanela(){
        
        listaPessoas = new JList<>();
        
        painel.setLayout(new FlowLayout());
        painel.add(botaoNovo);
        painel.add(botaoEditar);
        painel.add(botaoRemover);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(listaPessoas,BorderLayout.CENTER);
        getContentPane().add(painel,BorderLayout.SOUTH);
        
    }
    
    
}
