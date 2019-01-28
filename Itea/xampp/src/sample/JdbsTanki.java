package sample;

import java.sql.*;

public class JdbsTanki {

    private String userName="root";
    private String password="";
    private String connectionUrl="jdbc:mysql://localhost:3306/tanki";
    Connection connection;
    Statement statement;

    public JdbsTanki()  {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection =DriverManager.getConnection(connectionUrl,userName,password);
            statement =connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String userName, String password)  {
        try {
            statement.executeUpdate("INSERT INTO users (login, password,record)"+ " VALUES ('"+userName+"','"+password+"',"+"'0')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  int search(String userName, String password){
        int i=0;
        ResultSet resultSet= null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()){
                if ((resultSet.getString(2).equals(userName))&&(resultSet.getString(3).equals(password))){
                    i=resultSet.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public void changeRecord(int id,int changeRecord){
        try {
            System.out.println("UPDATE users SET record="+changeRecord+" WHERE id="+id);
            statement.executeUpdate("UPDATE users SET record="+changeRecord+" WHERE id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}
