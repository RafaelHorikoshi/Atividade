package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco 
{

    public static Connection getConexao() {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5435/s", "postgres", "postgres");
        
        } catch (ClassNotFoundException | SQLException erro2) {
            //
        }
        return conexao;
    }

}
