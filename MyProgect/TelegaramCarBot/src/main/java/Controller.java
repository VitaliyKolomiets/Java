import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Controller extends Bot  {
    Controller(){
        for (int i = 0; i <jdbs.getID().size() ; i++) {
            if (jdbs.stan(jdbs.getID().get(i))==true){
                User user = new User();
                user.setChatId(jdbs.getID().get(i));
                userHashMap.put(user.getChatId(), user);
                for (int j = 0; j < jdbs.getLinkID(user.getChatId()).size(); j++) {
                    ArrayList<String> test = firstMass(jdbs.getLinkID(user.getChatId()).get(j));
                    userHashMap.get(user.getChatId()).getLinkMass().put(jdbs.getLinkID(user.getChatId()).get(j), test);
                }
            }
        }
    }

    public void str() {


        while (true) {
            if (userHashMap.isEmpty()) {
                try {
                    TimeUnit.SECONDS.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {

                try {
                    for (Map.Entry<Long, User> entry : userHashMap.entrySet()) {

                        for (Map.Entry<String, ArrayList<String>> entry1 : entry.getValue().getLinkMass().entrySet()) {

                            WebElement element;

                            ChromeDriverManager.getInstance().setup();
                            ChromeDriver n = new ChromeDriver();

                            n.get(entry1.getKey());

                            for (int i = 0; i < entry1.getValue().size(); i++) {

                                try {
                                    element = n.findElement(By.cssSelector("body > div.g-content > div > div.u-display-flex.u-margin-top-18 > section > div.result-list-section.js-result-list-section.u-clearfix > article:nth-child(" + i + ") > div > div.g-row.js-ad-entry > a > div.g-col-s-12.g-col-m-8 > div.vehicle-text.g-row > h3"));
                                    boolean flag = false;
                                    for (int j = 0; j < entry1.getValue().size(); j++) {
                                        String a = element.getText().replace("Новое", "").replaceFirst("\n", "");
                                        String c = entry1.getValue().get(j);
                                        if (a.equals(c)) {
                                            flag = true;
                                        }
                                    }
                                    if (flag != true) {
                                        entry1.getValue().add(element.getText().replace("Новое", "").replaceFirst("\n", ""));
                                        String message="name: "+element.getText().replace("Новое", "").replaceFirst("\n", "")+"\n";
                                        element = n.findElement(By.cssSelector("body > div > div > div.u-display-flex.u-margin-top-18 > section > div.result-list-section.js-result-list-section.u-clearfix > article:nth-child(2) > div > div.g-row.js-ad-entry > a"));
                                        message+="price: "+element.findElement(By.className("vehicle-prices")).getText().replace("(Брутто)", "").substring(0,element.findElement(By.className("vehicle-prices")).getText().replace("(Брутто)", "").indexOf("\n"))+"\n"+element.getAttribute("href");
                                        System.out.println(message);
                                        sendMsg(entry.getKey().toString(), message);
                                    }

                                } catch (Exception e) {
                                }
                            }
                            n.close();
                        }

                    }
                }catch (Exception e){
                    System.out.println("controller error");
                }

            }
        }
    }

}




