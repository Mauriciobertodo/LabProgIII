
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        return (getConnectionPostgre());            
    }
    public static Connection getConnectionPostgre() throws ClassNotFoundException, SQLException {
        
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/NossaCantina";
        String user = "postgres";
        String pass = "109591m@"; 
        Connection conexao = DriverManager.getConnection(url, user, pass);
        return conexao;             
    }    
    
    /*
    public DefaultListModel<Usuario> listaUsuarios = new DefaultListModel<Usuario>();
    public void lerDados(){
        try {
            Class.forName("org.postgresql.Driver");
                                   
            startConexao = DriverManager.getConnection(url, user, pass);
            stm = startConexao.createStatement();            
            rts = stm.executeQuery(querySeguranca);            
            
            while(rts.next()){             
                listaUsuarios.addElement(new Usuario(
                                        rts.getInt("id"),
                                        rts.getString("nome").trim(),
                                        rts.getInt("matricula"),
                                        rts.getString("email").trim(),
                                        rts.getString("tipo_usuario").trim(),
                                        rts.getInt("conta_usuario"),
                                        rts.getInt("senha")));
            }
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro2: " + ex.getMessage());
        }
    }
    */
}
