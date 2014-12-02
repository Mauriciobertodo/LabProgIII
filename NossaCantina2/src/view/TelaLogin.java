package view;

import controller.TelasController;
import javax.swing.JOptionPane;
/**
 ** @author MauricioBertodo
 */
public class TelaLogin extends javax.swing.JFrame {
    
    TelasController telaConectaBanco = new TelasController();
    
    public TelaLogin() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        UsuarioLabel = new javax.swing.JLabel();
        UsuarioText = new javax.swing.JTextField();
        SenhaLabel = new javax.swing.JLabel();
        SenhaText = new javax.swing.JPasswordField();
        ConfirmaLogin = new javax.swing.JButton();
        CancelaLogin = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setResizable(false);

        jLabel1.setText("Insira a senha para acessar!");

        UsuarioLabel.setText("Usuario:");

        SenhaLabel.setText("Senha:");

        ConfirmaLogin.setText("Confirmar");
        ConfirmaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmaLoginActionPerformed(evt);
            }
        });

        CancelaLogin.setText("Cancelar");
        CancelaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelaLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(ConfirmaLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                            .addComponent(CancelaLogin))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(UsuarioLabel)
                                .addComponent(SenhaLabel))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(UsuarioText)
                                .addComponent(SenhaText, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuarioLabel)
                    .addComponent(UsuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SenhaLabel)
                    .addComponent(SenhaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmaLogin)
                    .addComponent(CancelaLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmaLoginActionPerformed
        if(UsuarioText.getText().trim().isEmpty() && SenhaText.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe usuario e senha!");
        }
        else{
            telaConectaBanco.telaValidaLogin(Integer.parseInt(UsuarioText.getText()),Integer.parseInt(SenhaText.getText()));
            dispose();
        }
    }//GEN-LAST:event_ConfirmaLoginActionPerformed

    private void CancelaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelaLoginActionPerformed
       System.exit(0);
    }//GEN-LAST:event_CancelaLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelaLogin;
    private javax.swing.JButton ConfirmaLogin;
    private javax.swing.JLabel SenhaLabel;
    public javax.swing.JPasswordField SenhaText;
    private javax.swing.JLabel UsuarioLabel;
    public javax.swing.JTextField UsuarioText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}