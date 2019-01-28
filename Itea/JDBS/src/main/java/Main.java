
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName ="root";
        String password="50bivati";
        String connectionURL="jdbc:mysql://localhost:3306/Car?useSSL=false";

        try {
            Connection connection = DriverManager.getConnection(connectionURL, userName, password);
            System.out.println("we are connection");
            Statement statement= connection.createStatement();

            {
               // statement.executeUpdate("insert into users set name ='sss'");
                ResultSet resultSet= statement.executeQuery("select *from users");
                while (resultSet.next()){
                    System.out.println(resultSet.getString(2));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
