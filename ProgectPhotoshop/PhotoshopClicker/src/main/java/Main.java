import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by Vetal_den on 30.01.2018.
 */
public class Main {
    //Account_1
    final static String email1 = "winnie.retoucher.pooh@gmail.com";
    static String Way_to_Folder1 = "src\\main\\resources\\link_tag_photographer.txt";


    //Account_2
    final static String email2 = "denisretoucher@gmail.com";
    static String Way_to_Folder2 = "src\\main\\resources\\link_tag_photographer1.txt";


    //Account_3
    final static String email3 = "vito.retoucher.scaletta@gmail.com";
    static String Way_to_Folder3 = "src\\main\\resources\\link_tag_photographer2.txt";

    //Account_4
    final static String email4 = "evaevansretouch@gmail.com";
    static String Way_to_Folder4="src\\main\\resources\\link_tag_photographer3.txt";



    public static void main(String[] args) throws IOException {


        Tabs tabs = new Tabs(Way_to_Folder1, Way_to_Folder2, Way_to_Folder3, Way_to_Folder4, email1, email2, email3, email4);
        tabs.addComponentToPane();

    }

    public synchronized static String[] Array_link(String Way_to_Folder) throws IOException {
        String[] a1 = new String[1000000];
        int number_line = 0;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Way_to_Folder), StandardCharsets.UTF_8));
        String line;

        while ((line = reader.readLine()) != null) {
            a1[number_line++] = line;
        }

        int number = 0;

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != null) number = i;
            else i++;
        }

        String[] a2 = new String[number + 1];
        System.arraycopy(a1, 0, a2, 0, number + 1);

        return a2;
    }


}
