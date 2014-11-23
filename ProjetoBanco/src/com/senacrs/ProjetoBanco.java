/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.senacrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lhries
 */
public class ProjetoBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/crud";
            String user = "root";
            String senha = "";                    
            Connection conexao = DriverManager.getConnection(url, user, senha);
            if(conexao!=null)
                System.out.println("Conectado ao banco!!");
            
//            Statement comando = conexao.createStatement();
//            String exec = "INSERT INTO PESSOA (NOME,EMAIL) VALUES ('Ciclano','ciclano@gmail.com')";
//            int numLinhasAfetadas = comando.executeUpdate(exec);
//            String exec1 = "UPDATE PESSOA SET NOME='Fulano de Tal' WHERE NOME='Fulano'";
//            int numLinhasAfetadas1 = comando.executeUpdate(exec1);
//            String exec2 = "DELETE FROM PESSOA WHERE NOME='Fulano de Tal'";
//            int numLinhasAfetadas2 = comando.executeUpdate(exec2);
//            System.out.println(numLinhasAfetadas2);
            
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(("SELECT * FROM PESSOA"));
            while(resultado.next())
            {
                System.out.println(resultado.getInt("ID"));
                System.out.println(resultado.getString("NOME"));
                System.out.println(resultado.getString("EMAIL"));
                System.out.println("**********");
            }
            
            comando.close();
            conexao.close();
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
