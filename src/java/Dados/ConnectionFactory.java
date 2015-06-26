/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
            Connection connection;
            String user, senha, banco, endereco;
            
            user     = "acesso";
            senha    = "123456";
            banco    = "Trabalho2";
            endereco = "localhost";
            
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                connection = null;
            }
            connection = DriverManager.getConnection(
                        "jdbc:postgresql://" + endereco + ":5432/" + banco, user,
                        senha);           
            
            return connection;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


