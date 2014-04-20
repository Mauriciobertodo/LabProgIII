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
    
    private JPanel painel = new JPanel();
    
    private JList listaPessoas;
    
    private JButton botaoNovo = new JButton("Novo");
    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoRemover = new JButton("Remover");
    
    public JanelaPrincipal(){
        
        setTitle("Pessoas");            // nome inicial
        setSize(250,400);               // tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        montaJanela();                  // inclui componentes na janela principal
        setLocationRelativeTo(null);    // localiza no centro da tela
        setVisible(true);               // seta como visivel
    }
    public void montaJanela(){
        
        TrataBotoes confereBotoes = new TrataBotoes(this);
        listaPessoas = new JList<>();
        
        DefaultListModel<Pessoa> pessoas = new DefaultListModel<Pessoa>();
        listaPessoas.setModel(pessoas); 
        
        painel.setLayout(new FlowLayout());
        // insere botão novo e executa função
        botaoNovo.addActionListener(confereBotoes);
        painel.add(botaoNovo);
        // insere botão editar e executa função
        botaoEditar.addActionListener(confereBotoes);
        painel.add(botaoEditar);
        // insere botão remover e executa função
        botaoRemover.addActionListener(confereBotoes);
        painel.add(botaoRemover);
        // define layout da tela
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(listaPessoas,BorderLayout.CENTER);
        getContentPane().add(painel,BorderLayout.SOUTH);
    }
    
    void cadastra(String nome, String idade) {
        Pessoa listpessoa = new Pessoa(nome, Integer.parseInt(idade));
        DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();
        model.addElement(listpessoa);       // adiciona pessoa a lista existente
        JOptionPane.showMessageDialog(this, nome +" - "+ idade +" anos"+"\n\nCadastrado realizado!");
    }
    void edita(int indexEdit, String nome, String idade) {
        Pessoa listpessoa = new Pessoa(nome, Integer.parseInt(idade));
        DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();
        model.set(indexEdit,listpessoa);    // edita pessoa de acordo com o index a lista existente
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
                int index = listaPessoas.getSelectedIndex();
                if (index >= 0) {
                    DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();
                    FormularioCadastrar cadastro = new FormularioCadastrar(mostratela,
                            model.getElementAt(index).getNome(),                   
                            String.valueOf(model.getElementAt(index).getIdade()),   
                            index);
                    mostratela.setVisible(false);
                } 
                else
                    JOptionPane.showMessageDialog(mostratela, "Selecione um elemento para editá-lo");
            } 
            else if (e.getSource() == botaoRemover) {
                if (listaPessoas.getSelectedIndex() >= 0) {
                    DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();
                    model.remove(listaPessoas.getSelectedIndex());
                    JOptionPane.showMessageDialog(mostratela, "Elemento removido com sucesso!");
                }
                else
                    JOptionPane.showMessageDialog(mostratela, "Selecione um elemento para editá-lo");
            }
        }
    }
}
