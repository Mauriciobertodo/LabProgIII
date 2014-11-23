
package projetocrudpessoas;

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

public class TelaPrincipal extends JFrame {

    JList listaPessoas;
    JButton botaoNovo, botaoEditar, botaoRemover;
    JPanel painelBotoes;

    public TelaPrincipal() {
        super("CRUD de Pessoas");
        iniciaComponentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);

    }

    private void iniciaComponentes() {
        listaPessoas = new JList();
        DefaultListModel<Pessoa> pessoas = new DefaultListModel<Pessoa>();
        pessoas.addElement(new Pessoa("Fulano", 30));
        listaPessoas.setModel(pessoas);

        botaoNovo = new JButton("Novo");
        TratadorBotoes tratadorBotoes = new TratadorBotoes(this);
        botaoNovo.addActionListener(tratadorBotoes);
        botaoEditar = new JButton("Editar");
        botaoEditar.addActionListener(tratadorBotoes);
        botaoRemover = new JButton("Remover");
        botaoRemover.addActionListener(tratadorBotoes);

        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoNovo);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoRemover);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(listaPessoas, BorderLayout.CENTER);
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
    }

    //Cria uma referência para os listeners internos poderem fazer referência ao outerclass.
//    private TelaPrincipal telaPrincipal() {
//        return this;
//    }

    void cadastrar(String nome, String idade) {
        Pessoa pessoa = new Pessoa(nome, Integer.parseInt(idade));
        DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();
        model.addElement(pessoa);
        JOptionPane.showMessageDialog(this, nome+" cadastrado com sucesso!",
                "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE);

    }

    void editar(int indexEdicao, String nome, String idade) {
        Pessoa pessoa = new Pessoa(nome, Integer.parseInt(idade));
        DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();
        model.set(indexEdicao,pessoa);
        JOptionPane.showMessageDialog(this, nome+" editado com sucesso!",
                "Edição Realizada", JOptionPane.INFORMATION_MESSAGE);
    }

    public class TratadorBotoes implements ActionListener {

        TelaPrincipal tela;

        public TratadorBotoes(TelaPrincipal tela) {
            this.tela = tela;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botaoNovo) {
                FormularioCadastro formulario = new FormularioCadastro(tela);
                tela.setVisible(false);
            } else if (e.getSource() == botaoEditar) {
                int index = listaPessoas.getSelectedIndex();
                if (index >= 0) {
                    DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();

                    FormularioCadastro formulario = new FormularioCadastro(tela,
                            model.getElementAt(index).getNome(),
                            String.valueOf(model.getElementAt(index).getIdade()),
                            index);
                    tela.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(tela, "Selecione um elemento para editá-lo",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == botaoRemover) {
                if (listaPessoas.getSelectedIndex() >= 0) {
                    DefaultListModel<Pessoa> model = (DefaultListModel<Pessoa>) listaPessoas.getModel();
                    model.remove(listaPessoas.getSelectedIndex());
                    JOptionPane.showMessageDialog(tela, "Elemento removido com sucesso!",
                            "Elemento Removido", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(tela, "Selecione um elemento para removê-lo",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

    }

}
