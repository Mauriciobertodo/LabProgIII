
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.*;
import model.*;

/**
 *
 * @author MauricioBertodo
 */
public class TelasController {
    
    TelaLogin startLogin;
    ConexaoBanco conexaoStart;
    
    private Connection conexao;
    private PreparedStatement comando;
      
    Usuario usuarioLogado = null;
    TelaCompraAluno telaCompraAluno;
    
    public void controlaAplicacao(){
        telaLogin();
    }    
    
    public Usuario getUsuarioLogado(){
        return usuarioLogado;
    }
    
    public void conctarBanco(){
        conexaoStart = new ConexaoBanco();
    }
    
    public Usuario consultar(int matricula, int senha){
        
        Usuario novoUsuario = null;     
        String sql;
        
        try {
                Connection conn = ConexaoBanco.getConnection();  
                sql = "SELECT nome,matricula,email,senha,tipo_usuario,saldo_conta_usuario,conta_usuario FROM dadosusuario WHERE matricula=? and senha=?";
                               
                comando = conn.prepareStatement(sql);
                comando.setInt(1,matricula);
                comando.setInt(2,senha);
                
                ResultSet rs;
                rs = comando.executeQuery();
                
                if(rs.next()){
                    int user = rs.getInt("matricula");
                    int pass = rs.getInt("senha");
                    
                    String nome = rs.getString("nome");
                    String tipo_usuario = rs.getString("tipo_usuario");
                    String email = rs.getString("email");
                    int conta_usuario = rs.getInt("conta_usuario");
                    int saldo_conta_usuario = rs.getInt("saldo_conta_usuario");
                                       
                    novoUsuario = 
                    new Usuario(nome, matricula,email, tipo_usuario, conta_usuario, saldo_conta_usuario);
                                        
                    System.out.println(novoUsuario);
                    
                    comando.close();
                    return novoUsuario;
                }
        } 
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
    
    public void telaLogin(){
        startLogin = new TelaLogin();
        startLogin.setVisible(true);
    }
    
    public void telaValidaLogin(int matricula, int senha){
        
        usuarioLogado = consultar(matricula, senha);
        if(usuarioLogado != null)
        {
            if(usuarioLogado.getTipo_usuario().equalsIgnoreCase("aluno")){
                telaCompraAluno = new TelaCompraAluno(this);
                telaCompraAluno.setVisible(true);
            }
            if(usuarioLogado.getTipo_usuario().equalsIgnoreCase("funcionario")){
                JOptionPane.showMessageDialog(null, "ACESSO FUNCIONARIO");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "ACESSO NEGADO");
            telaLogin();           
        } 
    }    
    
    

}
