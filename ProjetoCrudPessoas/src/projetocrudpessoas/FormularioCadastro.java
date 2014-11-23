/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocrudpessoas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lhries
 */
public class FormularioCadastro extends JFrame {

    private JLabel labelNome, labelIdade;
    private JTextField textoNome, textoIdade;
    private JButton botaoOk, botaoCancelar;
    private JPanel painelNome, painelIdade, painelBotoes;
    private int indexEdicao;
    private TelaPrincipal telaPrincipal;

    public FormularioCadastro(TelaPrincipal telaPrincipal) {
        super("Formulário de Cadastro");
        this.telaPrincipal = telaPrincipal;
        iniciaComponentes();
        indexEdicao = -1;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new TratadorJanela());
        pack();
        setVisible(true);

    }

    public FormularioCadastro(TelaPrincipal telaPrincipal, String nome, String idade, int index) {
        this(telaPrincipal);
        indexEdicao = index;
        textoNome.setText(nome);
        textoIdade.setText(idade);
    }

    private void iniciaComponentes() {

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        painelNome = new JPanel();
        labelNome = new JLabel("Nome:");
        textoNome = new JTextField(20);
        painelNome.add(labelNome);
        painelNome.add(textoNome);

        painelIdade = new JPanel();
        labelIdade = new JLabel("Idade:");
        textoIdade = new JTextField(20);
        painelIdade.add(labelIdade);
        painelIdade.add(textoIdade);

        getContentPane().add(painelNome);
        getContentPane().add(painelIdade);

        painelBotoes = new JPanel();
        botaoOk = new JButton("OK");
        botaoOk.addActionListener(new TrataBotoes());
        painelBotoes.add(botaoOk);
        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new TrataBotoes());
        painelBotoes.add(botaoCancelar);

        getContentPane().add(painelBotoes);

    }

    //Cria uma referência para os listeners internos poderem fazer referência ao outerclass.
    private FormularioCadastro formularioCadastro() {
        return this;
    }

    private class TrataBotoes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(botaoOk)) {
                if (indexEdicao < 0) //Se for cadastrar
                {
                    telaPrincipal.cadastrar(textoNome.getText(),
                            textoIdade.getText());
                } else // Se for editar
                {
                    telaPrincipal.editar(indexEdicao, textoNome.getText(),
                            textoIdade.getText());
                }
            }

            telaPrincipal.setVisible(true);

            formularioCadastro().dispose();//Chama o método dispose() da outer class
        }
    }

    private class TratadorJanela extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
            telaPrincipal.setVisible(true);

            formularioCadastro().dispose();//Chama o método dispose() da outer class
        }

    }
}
