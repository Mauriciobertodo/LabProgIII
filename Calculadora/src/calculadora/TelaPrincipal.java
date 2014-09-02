
package calculadora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame{
    
    private JPanel numeros = new JPanel();
    
    private JTextField mostraNumeros = new JTextField(20);
    
    private JButton numero1 = new JButton("1");
    private JButton numero2 = new JButton("2");
    private JButton numero3 = new JButton("3");
    private JButton numero4 = new JButton("4");
    private JButton numero5 = new JButton("5");
    private JButton numero6 = new JButton("6");
    private JButton numero7 = new JButton("7");
    private JButton numero8 = new JButton("8");
    private JButton numero9 = new JButton("9");
    private JButton numero0 = new JButton("0");
    private JButton numeroCE = new JButton("CE");
    
    private JButton opMais = new JButton("+");
    private JButton opMenos = new JButton("-");
    private JButton opMultipicar = new JButton("*");
    private JButton opDividir = new JButton("/");
    private JButton opIgual = new JButton("=");
    
    public TelaPrincipal(){
    
        setTitle("Calculadora");
        setSize(250,200);               // tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciaComponentes();
        setLocationRelativeTo(null);    // localiza no centro da tela
        setVisible(true);
    }
    
    public void iniciaComponentes(){
        
        TrataBotoes confereBotoes = new TrataBotoes(this);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mostraNumeros);
        mostraNumeros.setHorizontalAlignment(JTextField.RIGHT);
        
        numeros.setLayout(new GridLayout(4,6,10,10));
        
        numero1.addActionListener(confereBotoes);
        numeros.add(numero1);
        numero2.addActionListener(confereBotoes);
        numeros.add(numero2);
        numero3.addActionListener(confereBotoes);
        numeros.add(numero3);
        opMais.addActionListener(confereBotoes);
        numeros.add(opMais);
        
        numero4.addActionListener(confereBotoes);
        numeros.add(numero4);
        numero5.addActionListener(confereBotoes);
        numeros.add(numero5);
        numero6.addActionListener(confereBotoes);
        numeros.add(numero6);
        opMenos.addActionListener(confereBotoes);
        numeros.add(opMenos);
        
        numero7.addActionListener(confereBotoes);
        numeros.add(numero7);
        numero8.addActionListener(confereBotoes);
        numeros.add(numero8);
        numero9.addActionListener(confereBotoes);
        numeros.add(numero9);
        opMultipicar.addActionListener(confereBotoes);
        numeros.add(opMultipicar);
        
        numeroCE.addActionListener(confereBotoes);
        numeros.add(numeroCE); 
        numero0.addActionListener(confereBotoes);
        numeros.add(numero0);          
        opIgual.addActionListener(confereBotoes);
        numeros.add(opIgual);
        opDividir.addActionListener(confereBotoes);
        numeros.add(opDividir);
        
        getContentPane().add(mostraNumeros,BorderLayout.NORTH);
        getContentPane().add(numeros);
    }
    
    public class TrataBotoes implements ActionListener {

        TelaPrincipal mostra;
        String op = null;
        int ID = 0;
        
        private TrataBotoes(TelaPrincipal tela) {
            this.mostra = tela;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           
            if (e.getSource() == numero1){
                mostraNumeros.setText(mostraNumeros.getText()+"1");
            }
            else if (e.getSource() == numero2){
                mostraNumeros.setText(mostraNumeros.getText()+"2");                
            }
            else if (e.getSource() == numero3){
                mostraNumeros.setText(mostraNumeros.getText()+"3");
            }
            else if (e.getSource() == numero4){
                mostraNumeros.setText(mostraNumeros.getText()+"4");
            }
            else if (e.getSource() == numero5){
                mostraNumeros.setText(mostraNumeros.getText()+"5");
            }
            else if (e.getSource() == numero6){
                mostraNumeros.setText(mostraNumeros.getText()+"6");
            }
            else if (e.getSource() == numero7){
                mostraNumeros.setText(mostraNumeros.getText()+"7");
            }
            else if (e.getSource() == numero8){
                mostraNumeros.setText(mostraNumeros.getText()+"8");
            }
            else if (e.getSource() == numero9){
                mostraNumeros.setText(mostraNumeros.getText()+"9");
            }
            else if (e.getSource() == numero0){
                mostraNumeros.setText(mostraNumeros.getText()+"0");
            }
            else if (e.getSource() == numeroCE){
                mostraNumeros.setText(null);
            }
            if(e.getSource() == opMais){
                ID = 1;
                op = mostraNumeros.getText();
                mostraNumeros.setText(null);
            }
            if(e.getSource() == opMenos){
                ID = 2;
                op = mostraNumeros.getText();
                mostraNumeros.setText(null);
            }
            if(e.getSource() == opMultipicar){
                ID = 3;
                op = mostraNumeros.getText();
                mostraNumeros.setText(null);
            }
            if(e.getSource() == opDividir){
                ID = 4;
                op = mostraNumeros.getText();
                mostraNumeros.setText(null);
            }
            else  if(e.getSource() == opIgual){
                if(ID == 1){
                    int resultado = Integer.parseInt(op) + Integer.parseInt(mostraNumeros.getText());
                    mostraNumeros.setText(String.valueOf(resultado));
                    ID = 0;
                }
                if(ID == 2){
                    int resultado = Integer.parseInt(op) - Integer.parseInt(mostraNumeros.getText());
                    mostraNumeros.setText(String.valueOf(resultado));
                    ID = 0;
                }
                if(ID == 3){
                    int resultado = (Integer.parseInt(op) * Integer.parseInt(mostraNumeros.getText()));
                    mostraNumeros.setText(String.valueOf(resultado));
                    ID = 0;
                }
                if(ID == 4){
                    
                    if(Integer.parseInt(mostraNumeros.getText()) != 0){
                        int resultado = (Integer.parseInt(op) / Integer.parseInt(mostraNumeros.getText()));
                        mostraNumeros.setText(String.valueOf(resultado));
                        ID = 0;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não pode dividir por '0' !");
                        mostraNumeros.setText(null);
                        //ID = 0;
                    }
                }
            }
        }    
    }    
}