
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
}
