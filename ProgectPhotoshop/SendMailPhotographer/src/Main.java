import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, MessagingException {
        String waytofolder="C:\\Users\\Vitalya\\Desktop\\count_new\\evaevans\\email.txt";
        String[] mas=Array_link(waytofolder);
        String[] mas1;
        mas1=mas;


            final Properties properties = new Properties();


            properties.setProperty("mail.transport.protocol", "smtps");
            properties.setProperty("mail.smtps.auth","true");
            properties.setProperty("mail.smtps.host", "smtp.gmail.com");
            properties.setProperty("mail.smtps.user", "evaevansretouch@gmail.com");

        for (int i = 2000; i <2100 ; i++) {

            Session mailSession = Session.getDefaultInstance(properties);
            MimeMessage massage = new MimeMessage(mailSession);
            massage.setFrom(new InternetAddress("evaevansretouch@gmail.com"));

                try {
                    massage.addRecipient(Message.RecipientType.TO, new InternetAddress(mas[i]));
                }
                catch (Exception e){
                    System.out.println("no_message");
                }

            massage.setSubject("Retouching");
            massage.setContent("<td align=\"center\" valign=\"top\" style=\"padding-left:13px;padding-right:13px;background-color:#ffffff\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "          <tbody><tr>\n" +
                    "            <td><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "              <tbody>\n" +
                    "            </tbody></table></td>\n" +
                    "\t\t\t\n" +
                    "\t\t\n" +
                    "                     \n" +
                    "        </tr><tr>\n" +
                    "\t\t\t<td height=\"10\" align=\"center\" valign=\"middle\"><img src=\"https://ci5.googleusercontent.com/proxy/evu2N3iXtwYU6Rhkt2qJODpU2Psw1fOOuMIdLGx_1VA5LQriW-wIkvkXiimGuM6C50cDr6bPyw=s0-d-e1-ft#https://image.ibb.co/mFk4T7/v.png\" class=\"m_8979021281621926252CToWUd CToWUd\"><div></div></td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "\t\t\t<td height=\"10\" align=\"center\" valign=\"middle\"><img src=\"https://ci6.googleusercontent.com/proxy/vpCuRxUELbGJJSEpcsoBVoQ0woWscsfnB5I4mtszEH1SzSaTFRBhl2O-rEZTB00phtMImTbkQ8o=s0-d-e1-ft#https://image.ibb.co/mdkGrS/ev.gif\" class=\"m_8979021281621926252CToWUd CToWUd\">      <img src=\"https://ci3.googleusercontent.com/proxy/5lC_FJMmXakm14LssZln16XBT4qx7m-Nn7UdIf4KhAUw51ocT7MNa3kzRoFb0cKdyPI26oi-KR1L=s0-d-e1-ft#https://image.ibb.co/grULJ7/ev1.gif\" class=\"m_8979021281621926252CToWUd CToWUd\"><div></div></td>\n" +
                    "\t\t\t\n" +
                    "        </tr>\n" +
                    "         \n" +
                    "        <tr>\n" +
                    "            <td height=\"10\" valign=\"middle\"><img src=\"https://ci3.googleusercontent.com/proxy/CWFQUn2cBGJFkkrI3WeH4C4om-R8YJIRI0mMaPPq3r998vYs0HK_ncl0YV_6adTXyj9a8coXL7-4_g=s0-d-e1-ft#https://image.ibb.co/jZak1S/eva2.png\" class=\"m_8979021281621926252CToWUd CToWUd\"><div></div></td>\n" +
                    "\t\t</tr>\n" +
                    "\t\t<tr>\n" +
                    "\t\t\t<td height=\"10\" align=\"center\" valign=\"middle\"><a href=\"https://evaevansretouch1.wixsite.com/evans\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?hl=ru&amp;q=https://evaevansretouch1.wixsite.com/evans&amp;source=gmail&amp;ust=1520864041593000&amp;usg=AFQjCNFbOZUP85cErS2zCfvTMn7UZLEFvA\"><img src=\"https://ci6.googleusercontent.com/proxy/GUA8Mk2Ezaf3RQjQIN_JFz2HntW9LjKs__qpG3mHYR6RGaCPC9hmgWC7WhOStBc4d_Wd69ADtaYn=s0-d-e1-ft#https://image.ibb.co/mcrJQ7/ev4.png\" class=\"m_8979021281621926252CToWU CToWUd\"><div></div></a></td>\n" +
                    "\t\t</tr>\n" +
                    "\t\t\t<tr><td height=\"10\" align=\"center\" valign=\"middle\"><img src=\"https://ci3.googleusercontent.com/proxy/qQ_M6kZEJH6TH8BPW9L_0SbIoT8t5kvWmgX8w9OEm-tisT-1aw-McBcS5jj5EwnTprvvYoUNuovqZA=s0-d-e1-ft#https://image.ibb.co/e9xb87/eva4.png\" class=\"m_8979021281621926252CToWU CToWUd a6T\" tabindex=\"0\"><div class=\"a6S\" dir=\"ltr\" style=\"opacity: 0.01; left: 530px; top: 1059px;\"><div id=\":1s8\" class=\"T-I J-J5-Ji aQv T-I-ax7 L3 a5q\" title=\"Скачать\" role=\"button\" tabindex=\"0\" aria-label=\"Скачать файл \" data-tooltip-class=\"a1V\"><div class=\"aSK J-J5-Ji aYr\"></div></div></div><div></div></td>\n" +
                    "\t\t\t</tr><tr>\n" +
                    "\t\t\t<td height=\"10\" align=\"center\" valign=\"middle\">You can reply on this Email: <div></div></td>\n" +
                    "\t\t\t</tr>\n" +
                    "\t\t\t<tr>\n" +
                    "\t\t\t<td height=\"10\" align=\"center\" valign=\"middle\"><a href=\"mailto:evaevansretouch@gmail.com\" target=\"_blank\">evaevansretouch@gamil.com</a> <div></div></td>\n" +
                    "\t\t\t</tr>\n" +
                    "            \n" +
                    "\t\t\t\n" +
                    "\t\t\t\n" +
                    "\t\t\t<tr>\n" +
                    "  \n" +
                    "\n" +
                    "    </tr></tbody></table>\n" +
                    "    <br>\n" +
                    "    <br></td>", "text/html");


            Transport tr = mailSession.getTransport();

            tr.connect(null, "50bivati");
            try {
                tr.sendMessage(massage, massage.getAllRecipients());
            }
            catch (Exception e){
                System.out.println("no send mail "+mas[i]);
            }

            tr.close();
            mas1[i]="+"+mas1[i];
               mas1= perezapus(waytofolder,mas1);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("time");
            }
        }



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
    public static String[] perezapus(String WAY_TO_FOLDER,  String[] mas) throws IOException {


        File myFile = new File(WAY_TO_FOLDER);
        try {
            FileWriter writer = new FileWriter(myFile);
            for (int i = 0; i < mas.length; i++) {
                writer.write(mas[i] + "\n");
            }
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return mas;

    }




}
