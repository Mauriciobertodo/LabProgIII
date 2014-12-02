
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
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
      
    public JList listaHistorico;
    public JList listaProdutos;
        
    Usuario usuarioLogado = null;
    Usuario usuarioTransf = null;
    
    private TelaCompraAluno telaCompraAluno;
    private TelaFuncionarioAdmin telaFuncionarioAdmin;
    private TelaConsultaTransferencia telaConsultaTransferencia;
    private TelaTransferencia telaTransferencia;
    private TelaTransferir telaTransferir;
    private TelaProdutos telaProdutos;
    private TelaFormularioCadastro telaFormularioCadastro;
        
    String data = "dd/MM/yy";
    java.util.Date agora = new java.util.Date();
    SimpleDateFormat formata = new SimpleDateFormat(data);
    
    String sql;
    
    public void controlaAplicacao(){
        telaLogin();
    }    
    
    public Usuario getUsuarioLogado(){
        return usuarioLogado;
    }
    
    public Usuario getUsuarioTransf(){
        return usuarioTransf;
    }
    
    public void conctarBanco(){
        conexaoStart = new ConexaoBanco();
    }
    
    public Usuario consultar(int matricula, int senha){
        
        Usuario novoUsuario = null;     
                
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
                                        
                    //System.out.println(novoUsuario);
                    
                    comando.close();
                    return novoUsuario;
                }
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
    
    public Usuario consultarConta(int conta_usuario){
        
        Usuario novoUsuario2 = null;     
                
        try {
                Connection conn = ConexaoBanco.getConnection();  
                sql = "SELECT nome,tipo_usuario,saldo_conta_usuario,conta_usuario FROM dadosusuario WHERE conta_usuario=?";
                               
                comando = conn.prepareStatement(sql);
                comando.setInt(1,conta_usuario);
                
                ResultSet rs;
                rs = comando.executeQuery();
                
                if(rs.next()){
                    
                    int conta = rs.getInt("conta_usuario");
                    String nome = rs.getString("nome");
                    String tipo_usuario = rs.getString("tipo_usuario");                    
                    int saldo_conta_usuario = rs.getInt("saldo_conta_usuario");
                    
                    novoUsuario2 = 
                        new Usuario(nome, tipo_usuario, conta_usuario, saldo_conta_usuario);
                    comando.close();
                    return novoUsuario2;
                }
        } 
        catch (ClassNotFoundException | SQLException e) {
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
        if(usuarioLogado != null){
            if(usuarioLogado.getTipo_usuario().equalsIgnoreCase("aluno")){
                validaSaldoUsuario();
            }
            if(usuarioLogado.getTipo_usuario().equalsIgnoreCase("funcionario")){
                telaFuncionarioAdmin = new TelaFuncionarioAdmin(this);
                telaFuncionarioAdmin.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(null, "ACESSO NEGADO");
            controlaAplicacao();
        } 
    }
    
    public void buscaContaUsuario(int conta_usuario){
        usuarioTransf = consultarConta(conta_usuario);  
        if(usuarioTransf != null){
            System.out.println(usuarioTransf);
            telaTransferir = new TelaTransferir(this);
            telaTransferir.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Conta invalida!");
            retornaTelaTransferencia();
        }
    }
    
    public void retornaTipoAcesso(){
        if(getUsuarioLogado().getTipo_usuario().equalsIgnoreCase("aluno")){
            retornaTelaCompraAluno();
        }
        else if(getUsuarioLogado().getTipo_usuario().equalsIgnoreCase("funcionario")){
            retornaTelaFuncionarioAdmin();
        }
    }
    
    public void retornaTelaConsultaTransferencia(){
        telaConsultaTransferencia = new TelaConsultaTransferencia(this);
        telaConsultaTransferencia.setVisible(true);
    }
    
    public void retornaTelaFuncionarioAdmin(){
        telaFuncionarioAdmin = new TelaFuncionarioAdmin(this);
        telaFuncionarioAdmin.setVisible(true);
    }
    
    public void retornaTelaTransferencia(){
        telaTransferencia = new TelaTransferencia(this);
        telaTransferencia.setVisible(true);
    }
    
    public void retornaTelaTransferir(){
        telaTransferir = new TelaTransferir(this);
        telaTransferir.setVisible(true);
    }    
    
    public void retornaTelaCompraAluno(){
        telaCompraAluno = new TelaCompraAluno(this);
        telaCompraAluno.setVisible(true);
    }
    
    public void atualizaContaUsuarioTransf(){
        try {
            Connection conn = ConexaoBanco.getConnection();
            
            sql = "UPDATE dadosusuario SET saldo_conta_usuario=?" 
                    + "WHERE conta_usuario=? ";
            
            comando = conn.prepareStatement(sql);
            comando.setInt(1, getUsuarioTransf().getSaldo_conta_usuario() + Integer.parseInt(telaTransferir.valorContaTransf.getText()));
            comando.setInt(2, getUsuarioTransf().getConta_usuario());
            comando.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                comando.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    public void atualizaContaUsuarioLogado(){
        try {
            Connection conn = ConexaoBanco.getConnection();
            
            sql = "UPDATE dadosusuario SET saldo_conta_usuario=?" 
                    + "WHERE conta_usuario=? ";
            
            comando = conn.prepareStatement(sql);
            comando.setInt(1, getUsuarioLogado().getSaldo_conta_usuario() - Integer.parseInt(telaTransferir.valorContaTransf.getText()));
            comando.setInt(2, getUsuarioLogado().getConta_usuario());
            comando.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                comando.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    public void confirmaTransf(){
        if (getUsuarioLogado().getSaldo_conta_usuario() 
                < Integer.parseInt(telaTransferir.valorContaTransf.getText())){
            JOptionPane.showMessageDialog(null, getUsuarioLogado().getNome() + ",\nvocê não tem saldo para esta transferência!");
            retornaTelaTransferir();
        }
        else if(getUsuarioLogado().getSaldo_conta_usuario() <= 0 ){
            JOptionPane.showMessageDialog(null, getUsuarioLogado().getNome() + ",\nvocê não tem saldo para esta transferência!");
            retornaTelaTransferir();
        }        
        else if (getUsuarioLogado().getSaldo_conta_usuario() >= 0 ){
            atualizaContaUsuarioLogado();
            atualizaContaUsuarioTransf();
            JOptionPane.showMessageDialog(null, "Transferencia realizada com SUCESSO para\n" + getUsuarioTransf().getNome());
            atualizaRelatorio();
            retornaTelaTransferencia();
        }        
    }  
    
    public void validaSaldoUsuario(){
        if(usuarioLogado.getSaldo_conta_usuario() > 0 ){
            telaCompraAluno = new TelaCompraAluno(this);
            telaCompraAluno.setVisible(true);
        }            
        else{
            JOptionPane.showMessageDialog(null, usuarioLogado.getNome() + ",\nvoce não tem saldo em banco!");
            controlaAplicacao();
        }
    }
    
    public void atualizaRelatorio(){
        try {
            Connection conn = ConexaoBanco.getConnection();
            
            sql = "INSERT INTO relatoriotrans(nomeUsaurioLogado,contaUsuarioLogado,valorDepositado,dataDeposito,nomeUsuarioTransferencia,contaUsuarioTransferencia)" 
                    + "VALUES (?,?,?,?,?,?)";
            
            comando = conn.prepareStatement(sql);
            comando.setString(1, getUsuarioLogado().getNome());
            comando.setInt(2, getUsuarioLogado().getConta_usuario());
            comando.setInt(3, Integer.parseInt(telaTransferir.valorContaTransf.getText()));
            comando.setString(4, formata.format(agora));
            comando.setString(5, getUsuarioTransf().getNome());
            comando.setInt(6, getUsuarioTransf().getConta_usuario());
            comando.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                comando.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
     
    public void retornaHistoricoTransf(){
        
        listaHistorico = new JList<>();
        DefaultListModel<HistoricoTransf> historico = new DefaultListModel<HistoricoTransf>();
        listaHistorico.setModel(historico);
        
        sql = "SELECT * FROM relatoriotrans ";
        ResultSet rs;
        try {
            Connection conn = ConexaoBanco.getConnection();
            comando = conn.prepareStatement(sql);
            rs = comando.executeQuery();
            
            while(rs.next())
            {
                HistoricoTransf historicoTransf = new HistoricoTransf(rs.getString("nomeUsaurioLogado"),
                                        rs.getInt("contaUsuarioLogado"),
                                        rs.getString("valorDepositado"),
                                        rs.getString("dataDeposito"),
                                        rs.getString("nomeUsuarioTransferencia"),
                                        rs.getInt("contaUsuarioTransferencia"));
                DefaultListModel<HistoricoTransf> model = (DefaultListModel<HistoricoTransf>) listaHistorico.getModel();
                model.addElement(historicoTransf);
            }
            
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                comando.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }    
    }
   
    public void mostraHistorico(){
        retornaHistoricoTransf();
    }
    
    public void atualizaTelaProdutos(){
    
        listaProdutos = new JList<>();
        DefaultListModel<Produtos> prods = new DefaultListModel<Produtos>();
        listaProdutos.setModel(prods);
        
        sql = "SELECT * FROM produtos ";
        ResultSet rs;
        try {
            Connection conn = ConexaoBanco.getConnection();
            comando = conn.prepareStatement(sql);
            rs = comando.executeQuery();
            
            while(rs.next())
            {
                Produtos prod = new Produtos(rs.getString("tipoproduto"),
                                        rs.getString("nomeproduto"),
                                        rs.getString("valorproduto"));
                DefaultListModel<Produtos> model = (DefaultListModel<Produtos>) listaProdutos.getModel();
                model.addElement(prod);
            }
            
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                comando.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }        
    }
    
    public void atualizarDados(){
        atualizaTelaProdutos();
    }
    
    public void retornaTelaProdutos(){
        telaProdutos = new TelaProdutos(this);
        telaProdutos.setVisible(true);
    }
        
    public void cadastarProduto(Produtos produto){
       
        sql = "INSERT INTO produtos(nomeproduto,tipoproduto,valorproduto) "
                + "VALUES (?,?,?)";
        ResultSet rs;
        try {
            Connection conn = ConexaoBanco.getConnection();
            comando = conn.prepareStatement(sql);
            //rs = comando.executeQuery();
            
            comando.setString(1, produto.getNomeProduto());
            comando.setString(2, produto.getTipoProduto());
            comando.setString(3, produto.getValorProduto());
            comando.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                comando.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    public void retornaTelaFormularioCadastro(){
        telaFormularioCadastro = new TelaFormularioCadastro(this);
        telaFormularioCadastro.setVisible(true);
    }    
}
