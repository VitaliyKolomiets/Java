import java.sql.*;
import java.util.ArrayList;

public class JDBS {
     String userName ="root";
     String password="50bivati";
     String connectionURL="jdbc:mysql://localhost:3306/Car?useSSL=false";
     Connection connection;


    public Connection connection(){

        try {
             connection = DriverManager.getConnection(connectionURL, userName, password);
            System.out.println("we are connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public ArrayList<Integer> getID(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        try {
            ResultSet resultSet = connection().createStatement().executeQuery("select *from users");
            while (resultSet.next()){
                    arrayList.add(resultSet.getInt(2));
                    }
            connection.close();
        }catch (SQLException e) {
            System.out.println("Connection close");
        }
        return arrayList;
    }



    public ArrayList<String> getLinkID(long chatId){
        ArrayList<String> arrayList  = new ArrayList<String>();
        try {
            ResultSet resultSet = connection().createStatement().executeQuery("select *from links");
            while (resultSet.next()){
                if (resultSet.getInt(2)==(int)chatId){
                    arrayList.add(resultSet.getString(3));
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }



    public void addUser(long chatId, String userName)  {
        try {
            connection().createStatement().executeUpdate("INSERT INTO users (chatID, name) "+"VALUES ('"+chatId+"', '"+userName+"')");
            connection.close();
        } catch (SQLException e) {
            System.out.println("user not add");
        }
    }


    public boolean seachChatId(long chatId){
        Boolean flag=false;

        try {
            ResultSet resultSet = connection().createStatement().executeQuery("select *from users");
            while (resultSet.next()){
                if (resultSet.getInt(2)==chatId){
                    flag=true;
                }

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return flag;
    }

    public boolean stan(long chatId){
        boolean flag=false;

        try {
            ResultSet resultSet = connection().createStatement().executeQuery("select *from users");
            while (resultSet.next()){
                if (resultSet.getInt(2)==chatId){
                    if (resultSet.getInt(4)==1){
                        flag=true;
                    }
                }

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }


    public void addLink(long chatId, String link){
        boolean flag=false;

        try {
            Statement statement= connection().createStatement();

            ResultSet resultSet = statement.executeQuery("select *from links");
               while (resultSet.next()){
                    if (link.equals(resultSet.getString(3))&&(chatId==resultSet.getInt(2))){
                        flag=true;
                    }
               }
             if (flag==false){
                 statement.executeUpdate("INSERT INTO links (userId, link) "+"VALUES ('"+chatId+"', '"+link+"')");
             }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLink(long chatId){
        try {
            connection().createStatement().executeUpdate("DELETE FROM links WHERE userId = '"+chatId+"' ");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
