package dbprogramming2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dbprogramming2 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Database Connected");
            Statement statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
