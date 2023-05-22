package dbprogramming2;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab15 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "select * from student";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = resultSet.getMetaData();

            System.out.println(rsMetaData.getColumnCount());

            for (int i = 1; i <= rsMetaData.getColumnCount(); i++){
                System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i= 1; i<= rsMetaData.getColumnCount(); i++)
                    System.out.printf("%-12s\t", resultSet.getString(i));
                System.out.println();
            }
            connection.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
