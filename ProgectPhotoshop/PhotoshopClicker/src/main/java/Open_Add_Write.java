
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Open_Add_Write extends Thread {


    private int BEGIN_OF_ADD;
    private int NUMBER_TO_ADD;
    private String WAY_TO_FOLDER;
    private String[] array;
    private String EMAIL;

    Open_Add_Write(String[] array, int BEGIN_OF_ADD, int NUMBER_TO_ADD, String WAY_TO_FOLDER,String EMAIL)  {
        this.array = array;
        this.BEGIN_OF_ADD = BEGIN_OF_ADD;
        this.NUMBER_TO_ADD = NUMBER_TO_ADD;
        this.WAY_TO_FOLDER = WAY_TO_FOLDER;
        this.EMAIL=EMAIL;


    }

    @Override
    public synchronized void run()  {


        WebElement element;

        ChromeDriverManager.getInstance().setup();
        ChromeDriver m = new ChromeDriver();

        m.get("chrome://settings/content");
        try {
            Thread.sleep(5000);

        } catch (Exception e) {

            e.printStackTrace();
        }


        m.get("https://www.modelmayhem.com/login");
        element = m.findElement(By.name("email"));
        element.sendKeys(EMAIL);

        element = m.findElement(By.name("password"));
        element.sendKeys("denis1245786");

/*        element = m.findElement(By.name("check"));
        element.click();*/
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for  (int i = BEGIN_OF_ADD; i < BEGIN_OF_ADD+NUMBER_TO_ADD; i++) {

                try {
                    m.get(array[i]);
                    array[i]="+"+array[i];
                    Thread.sleep(500);

                    try {

                        element = m.findElement(By.cssSelector("#main_container_content > table > tbody > tr > td:nth-child(2) > form > textarea"));
                        element.sendKeys(Tag());
                        Thread.sleep(1500);

                        element = m.findElement(By.cssSelector("#main_container_content > table > tbody > tr > td:nth-child(2) > form > input[type=\"submit\"]:nth-child(5)"));
                        element.click();
                        Thread.sleep(1000);

                    } catch (Exception e) {
                        System.out.println("Tag not write");
                    }

                } catch (Exception e) {
                    System.out.println("Ссилки не знайдено");
                }

        }

        File myFile = new File(WAY_TO_FOLDER);
        try {
            FileWriter writer = new FileWriter(myFile);
            for (int i = 0; i < array.length; i++) {
                writer.write(array[i] + "\n");
            }
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        m.quit();

    }


    public synchronized String Tag(){
        String com1="Great work! \n" +
                "\n" +
                "If you ever need to work with a retoucher, feel free to contact me. Hope to work with you soon.";
        String com2="Beautiful portfolio! Hope we can get to work together in the nearest future!";
        String com4="Brilliant shots & models! I would be glad to work with you some day.";
        String com6="Hello! \n" +
                "\n" +
                "Your portfolio is amazing. \n" +
                "\n" +
                "I would be glad to work with you some day. \n" +
                "So if you need inexpensive, high-quality retouching, feel free to contact me any time! ";
        String com7="Nice portfolio! If you ever need a retoucher, feel free to contact me, I would love to work with you!";
        String com8="Beautiful portfolio! Hope we can get to work together in the nearest future! ";
        String com9="Amazing portfolio and style!";
        String com10="Hello, \n" +
                "Perfect job) I would be glad to work with you some day. \n" +
                "Best regards";
        String com11="Amazing portfolio! \n" +
                "You have a good taste! Keep it going.. \n" +
                "Write to me any time!";
        String com12="Really strong portfolio\n" +
                "If you ever need work with a retoucher, feel free to contact me. Hope to work with you soon!";
        String com13="Really amazing portfolio you got here. If you ever need a retoucher, I'll be happy to work with you. Looking forward to hear back from you!";
        String com14="I love your portfolio! I would love to work with you! Message me if you are interested, please.";
        String com15="Hey, \n" +
                "Nice portfolio! Please check out my spot and let me know if you have any projects in the nearest future.";
        String com16="Phenomenal work! \n" +
                "Would love to work together! ";
        String com17="You have nice works! Would love to hear from you if you need a retoucher.";
        String com18="Gorgeous portfolio, hopefully we can collaborate some time soon! \n" +
                "Cheers!";
        String com19="I love your portfolio, excellent work!\n" +
                "Looking forward to working with you! ";
        String com20="Hello, \n" +
                "Your portfolio is very unique! I would be glad to work with you some day. \n" +
                "Best regards:)";
        String com21="Hi! \n" +
                "Your pictures are really good! \n" +
                "I would like to offer my image retouching services. \n" +
                "I'd be happy to discuss further collaboration.\n" +
                "Thanks!";
        String com22="You have done so much fantastic work! Love your work! I would love to have an opportunity to work with you sometime as well.\n" +
                "Cheers!";
        String com23="So many amazing shots.\n" +
                "Look forward to seeing more of your work in the future!";
        String com24="Fabulous portfolio! I'd love to work with you one day.";
        String com25="Beautiful portfolio! Hope we can get to work together in the nearest future! ";

        String[] comment=new String[]{com1,com2,com4,com6,com7,com8,com9,com10,com11,com12,com13,com14,com15,com16,com17,com18,com19,com20,com21,com22,com23,com24,com25};
          return comment[(int)(Math.random() * comment.length)];
    }



}
