
package crudpessoa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormularioCadastrar extends JFrame {

    private JLabel labelNome = new JLabel("Nome:");
    private JLabel labelIdade = new JLabel("Idade:");
    
    private JPanel painelNome = new JPanel();
    private JPanel painelIdade = new JPanel();
    private JPanel painelBotoes = new JPanel();
    
    private JTextField textoNome = new JTextField(20);
    private JTextField textoIdade = new JTextField(20);
    
    private JButton botaoConfirmar = new JButton("Confirmar");
    private JButton botaoCancelar = new JButton("Cancelar");
    
    private int indexEdit;
    private JanelaPrincipal janelaPrincipal;

    public FormularioCadastrar(JanelaPrincipal janelaPrincipal) {
        setTitle("Cadastro");
        setSize(300,140);
        setLocationRelativeTo(null);
        this.janelaPrincipal = janelaPrincipal;
        montaJanela();
        indexEdit = -1;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new TrataJanela());
        setVisible(true);
    }
    public FormularioCadastrar(JanelaPrincipal principal, String nome, String idade, int index) {
        this(principal);
        index = index;
        textoNome.setText(nome);
        textoIdade.setText(idade);
    }
    private void montaJanela() {

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 
        //Nome    
        painelNome.add(labelNome);
        painelNome.add(textoNome);
        
        //Idade      
        painelIdade.add(labelIdade);
        painelIdade.add(textoIdade);
        
        //insere no painel
        getContentPane().add(painelNome);
        getContentPane().add(painelIdade);

        //insere botão confirmar cadastro
        botaoConfirmar = new JButton("Confirmar");
        painelBotoes.add(botaoConfirmar);
        botaoConfirmar.addActionListener(new TrataBotoes());
        
        //insere botão cancelar cadastro
        botaoCancelar = new JButton("Cancelar");
        painelBotoes.add(botaoCancelar);
        botaoCancelar.addActionListener(new TrataBotoes());
        

        getContentPane().add(painelBotoes);
    }
    private class TrataBotoes implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(botaoConfirmar)) {
                if (indexEdit < 0)
                    janelaPrincipal.cadastra(textoNome.getText(),textoIdade.getText());
                else 
                    janelaPrincipal.edita(indexEdit, textoNome.getText(),textoIdade.getText());
            }
            janelaPrincipal.setVisible(true);
            Cadastro().dispose();
        }
    }
    private class TrataJanela extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            janelaPrincipal.setVisible(true);
            Cadastro().dispose();
        }
    }
    private FormularioCadastrar Cadastro() {
        return this;
    }
}
