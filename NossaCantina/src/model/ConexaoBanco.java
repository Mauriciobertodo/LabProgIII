
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;

public class ConexaoBanco {
    
    public Connection startConexao;
    public Statement stm;
    public ResultSet rts;
    
    String url = "jdbc:postgresql://localhost:5432/NossaCantina";
    String user = "postgres";
    String pass = "109591m@";
    String querySeguranca = "SELECT * FROM seguranca_usuario";
    DefaultListModel<Usuario> listaUsuarios = new DefaultListModel<Usuario>();
    
    public void lerDados(){
        try {
            Class.forName("org.postgresql.Driver");
                                   
            startConexao = DriverManager.getConnection(url, user, pass);
            stm = startConexao.createStatement();
            
            //rts = stm.executeQuery(querySeguranca);            
            //while(rts.next()){             
            //    listaUsuarios.addElement(new Usuario(
            //                            rts.getString("nome").trim(),
            //                            rts.getString("email").trim(),
            //                            rts.getInt("matricula")));
            //}
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro2: " + ex.getMessage());
        }
    }
}
