import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {

    static Map<Long, User> userHashMap = new HashMap<Long, User>();
    static JDBS jdbs= new JDBS();

    @Override
    public void onUpdateReceived(Update e) {
        final Message msg = e.getMessage();
        final String txt = msg.getText();

        if (txt.equals("/start")) {
            SendMessage message = new SendMessage()
                    .setChatId(msg.getChatId())
                    .setText("Here is your keyboard");
            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow row = new KeyboardRow();
            row.add("Create account");
            row.add("Stop");

            keyboard.add(row);
            row = new KeyboardRow();
            row.add("Status");
            row.add("Link");
            row.add("Help");
            keyboard.add(row);

            keyboardMarkup.setKeyboard(keyboard);
            message.setReplyMarkup(keyboardMarkup);
            try {
                sendMessage(message);
            } catch (TelegramApiException r) {
                r.printStackTrace();
            }
        }

        if (txt.equals("Create account")) {
            if (!userHashMap.containsKey(msg.getChatId())) {
                User user = new User();
                user.setChatId(msg.getChatId());
                user.setName(msg.getChat().getFirstName());
                if (jdbs.seachChatId(user.getChatId()) == false) {
                    jdbs.addUser(user.getChatId(), msg.getChat().getFirstName());

                }
                if (jdbs.stan(user.getChatId()) == true) {
                    userHashMap.put(user.getChatId(), user);
                    sendMsg(msg.getChatId().toString(), "Come in this site https://www.mobile.de/ru \nCopy link with your filter and send me please.\nExample: https://www.mobile.de/ru/автомобиль/opel/vhc:car,ms1:19000__,prx:12000,ful:petrol".replace("_", "\\_"));
                } else sendMsg(msg.getChatId().toString(), "please pay me");
            }
        }

        if (txt.equals("Status")) {
            try {

                for (Map.Entry<Long, User> entry : userHashMap.entrySet()) {
                    if (entry.getKey().equals(msg.getChatId())) {
                        if (entry.getValue().getLinkMass().isEmpty()) {
                            sendMsg(msg.getChatId().toString(), "You use 0 link");
                        } else {
                            sendMsg(msg.getChatId().toString(), "You use this link");
                            for (Map.Entry<String, ArrayList<String>> entry1 : entry.getValue().getLinkMass().entrySet()) {
                                sendMsg(msg.getChatId().toString(), entry1.getKey().replace("_", "\\_"));
                            }
                        }

                    }

                }
            } catch (Exception w) {
                System.out.println("status error");
            }
        }
        if (txt.equals("Help")) {
            sendMsg(msg.getChatId().toString(), "Start a search - ...\nStatus - ...\nLink - ... \nStop-");
        }


        if (txt.equals("Link")) {
            if (jdbs.stan(msg.getChatId()) == true) {
                sendMsg(msg.getChatId().toString(), "Come in this site https://www.mobile.de/ru \nCopy link with your filter and send me please.\nExample: https://www.mobile.de/ru/автомобиль/opel/vhc:car,ms1:19000__,prx:12000,ful:petrol".replace("_", "\\_"));
            } else sendMsg(msg.getChatId().toString(), "please pay me");

            //sendMsg(msg.getChatId().toString(), "Send me link please. Example: https://www.mobile.de/ru/автомобиль/opel/vhc:car,ms1:19000__,prx:12000,ful:petrol".replace("_", "\\_"));

        }
        if (txt.equals("Stop")) {
            try {

                for (Map.Entry<Long, User> entry : userHashMap.entrySet()) {
                    if (entry.getKey().equals(msg.getChatId())) {
                        entry.getValue().getLinkMass().clear();
                        //userHashMap.remove(entry.getKey());
                    }
                }
                jdbs.deleteLink(msg.getChatId());
            } catch (Exception q) {
                System.out.println("stop error");
            }

        }
        if (txt.contains("https://www.mobile.de")) {
            if (jdbs.stan(msg.getChatId()) == true) {
                ArrayList<String> test = firstMass(txt);
                if (test.isEmpty()) {
                    sendMsg(msg.getChatId().toString(), "Your link is incorrect, try again");
                } else {
                    userHashMap.get(msg.getChatId()).getLinkMass().put(txt, test);
                    jdbs.addLink(msg.getChatId(), txt);
                }
            } else sendMsg(msg.getChatId().toString(), "please pay me");

        }
    }

    @SuppressWarnings("deprecation")
    public  void sendMsg(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "IvanBotCar_bot";
    }


    @Override
    public String getBotToken() {
        return "648277300:AAEgWcMZpaJPZFqjq1ETwc8TEeDniaPaqNs";
    }



    public synchronized ArrayList<String> firstMass(String link) {

        ArrayList<String> arrayList =new ArrayList<String>();

        WebElement element;

        ChromeDriverManager.getInstance().setup();
        ChromeDriver n = new ChromeDriver();

        n.get(link);

        for (int i = 1; i < 14; i++) {
            try {
                element = n.findElement(By.cssSelector("body > div.g-content > div > div.u-display-flex.u-margin-top-18 > section > div.result-list-section.js-result-list-section.u-clearfix > article:nth-child(" + i + ") > div > div.g-row.js-ad-entry > a > div.g-col-s-12.g-col-m-8 > div.vehicle-text.g-row > h3"));
                arrayList.add(element.getText().replace("Новое", "").replaceFirst("\n", ""));
            } catch (Exception e) {
            }
        }
        n.close();
        return arrayList;
    }



}