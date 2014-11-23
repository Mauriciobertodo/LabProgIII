
package prova1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {

    JList listaPessoas;
    JButton botaoAtualizar;
    JPanel painelBotoes;
    JPanel painelBotoes2;
    JPanel painelBotoes3;
    JTextField textoNome = new JTextField(15);
    JLabel lNome;
    JLabel lSaud;
    JLabel lMsg;
    JLabel lInfo;
    String nome;

    public TelaPrincipal() {
        super("CRUD de Pessoas");
        iniciaComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciaComponentes() {
      
        TratadorBotoes tratadorBotoes = new TratadorBotoes(this); 
        
        lMsg = new JLabel();
        lMsg.setText("Prova de Laboratorio de Programação 3:");
        
        lNome = new JLabel();
        lNome.setText("Nome:");
        
        lSaud = new JLabel();
        lSaud.setText("Boa tarde, ");
        
        lInfo = new JLabel();
        
        botaoAtualizar = new JButton("Atualizar");
        botaoAtualizar.addActionListener(tratadorBotoes);
        
        painelBotoes2 = new JPanel();
        painelBotoes2.add(lMsg);
        
        painelBotoes3 = new JPanel();
        painelBotoes3.add(lSaud);
        painelBotoes3.add(lInfo);
        
        painelBotoes = new JPanel();
        painelBotoes.add(lNome);
        painelBotoes.add(textoNome);
        painelBotoes.add(botaoAtualizar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(painelBotoes2, BorderLayout.NORTH);
        getContentPane().add(painelBotoes3, BorderLayout.WEST);
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);
    }    
    public class TratadorBotoes implements ActionListener {

        TelaPrincipal tela;

        public TratadorBotoes(TelaPrincipal tela) {
            this.tela = tela;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == botaoAtualizar) {
                if(textoNome.getText().equals("") ){
                   JOptionPane.showMessageDialog(null,"Informe o nome!");
                }
                else {
                    lInfo.setText(String.valueOf(textoNome.getText()));
                    tela.repaint();
                }
            }
        }
    }
}
