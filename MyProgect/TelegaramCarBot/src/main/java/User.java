import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String name;
    long chatId;
    Map<String, ArrayList<String>>  linkMass = new HashMap<String, ArrayList<String>>();


    public  Map<String, ArrayList<String>> getLinkMass() {
        return linkMass;
    }

    public void setName(String name) {

        this.name = name;

    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getName() {

        return name;
    }

    public long getChatId() {
        return chatId;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", chatId=" + chatId +
                '}';
    }


}
