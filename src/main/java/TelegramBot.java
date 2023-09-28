import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            if ("/start".equals(messageText)) {
                startCommandReceived(chatId, update.getMessage().getChat().getFirstName());


            }


        }
        //данный метод вызывается каждый раз при отправке сообщения пользователем.
        // Он вызывается с параметром update, с помощью которого мы можем получить текст сообщения,
        //id чата для отправки ответного сообщения и другую информацию.

    }

    private void startCommandReceived(Long chatId, String name) {
        String answer = "Hi, " + name;
        sendMessage(chatId, answer);
    }

    private void sendMessage(Long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        System.out.println(sendMessage);


    }
}

