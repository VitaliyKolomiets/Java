import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Vetal_den on 07.02.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int l=0;

        String [] mas= Array_link("C:\\Users\\Vitalya\\Desktop\\count_new\\evaevans\\best_link_text.txt");
       // System.out.println(mas[19]);


        for (int i = 0; i <mas.length; i++) {


            if (mas[i].contains("@") == true) {


                String lines[] = mas[i].split(" ");
                for (int j = 0; j < lines.length; j++) {
                    if (lines[j].contains("@")) {
                        l++;
                        spisok(lines[j]);
                        System.out.println(lines[j]);
                    }
                }
            }
        }
        System.out.println(l);




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

    public static void spisok(String bed) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\Vitalya\\Desktop\\count_new\\evaevans\\email.txt", true);
        try {
            writer.write(bed+"\n");
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}


