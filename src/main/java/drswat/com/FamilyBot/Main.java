package drswat.com.FamilyBot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main extends TelegramLongPollingBot {
	public static void main(String[] args) {
//		System.setProperty("log4j2.debug", "");
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotApi = new TelegramBotsApi();
		try {
			telegramBotApi.registerBot(new Main());
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		System.out.println("getBotUsername");
		return "@ShastaloFamilyBot";
	}

	@Override
	public void onUpdateReceived(Update arg0) {
		
		System.out.println("onUpdateReceived");
		Message message = arg0.getMessage();
		if (message != null && message.hasText()) {
			switch (message.getText()) {
			case "/help":
				sendMsg(message, "What can I do for you?");
				break;
			case "/Settings":
				sendMsg(message, "What we will be set?");
				break;

			default:
				sendMsg(message, "answer is absent");
				break;
			}
		}

	}

	public void sendMsg(Message message, String text) {
		System.out.println(text);
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.setReplyToMessageId(message.getMessageId());
		sendMessage.setText(text);
		try {
			execute(sendMessage);
		} catch (Exception e) {
		}

	}

	@Override
	public String getBotToken() {
		return "1029325960:AAFMXotL64ow_HLWxbLFSGX9aeXk_J2jpcE";
	}
}
