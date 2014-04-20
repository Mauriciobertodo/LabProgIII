package crudpessoa;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame {
    
    private JFrame janela = new JFrame();
    private JPanel painel = new JPanel();
    
    private JList listaPessoas;
    
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
        
        TrataBotoes confereBotoes = new TrataBotoes(this);
        listaPessoas = new JList<>();
        
        DefaultListModel<Pessoa> pessoas = new DefaultListModel<Pessoa>();
        pessoas.addElement(new Pessoa("Fulano", 30));
        listaPessoas.setModel(pessoas);
        
        painel.setLayout(new FlowLayout());
        painel.add(botaoNovo);
        botaoNovo.addActionListener(confereBotoes);
        painel.add(botaoEditar);
        botaoEditar.addActionListener(confereBotoes);
        painel.add(botaoRemover);
        botaoRemover.addActionListener(confereBotoes);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(listaPessoas,BorderLayout.CENTER);
        getContentPane().add(painel,BorderLayout.SOUTH);
        
    }
    
    void cadastra(String nome, String idade) {
        Pessoa listpessoa = new Pessoa(nome, Integer.parseInt(idade));
        DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();
        model.addElement(listpessoa);
        JOptionPane.showMessageDialog(this, nome +" - "+ idade +" anos"+"\n\nCadastrado realizado!");
    }
    void edita(int indexEdicao, String nome, String idade) {
        Pessoa listpessoa = new Pessoa(nome, Integer.parseInt(idade));
        DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();
        model.set(indexEdicao,listpessoa);
        JOptionPane.showMessageDialog(this, nome +" - "+ idade +" anos"+"\n\nEdição Realizada!");
    }    
    public class TrataBotoes implements ActionListener {

        JanelaPrincipal mostratela;

        public TrataBotoes(JanelaPrincipal tela) {
            this.mostratela = tela;
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botaoNovo) {
                FormularioCadastrar cadastro = new FormularioCadastrar(mostratela);
                mostratela.setVisible(false);
            }
            else if (e.getSource() == botaoEditar) {
             
            } 
            else if (e.getSource() == botaoRemover) {
                
            }
        }
    }
    
    
    
    
    
}
