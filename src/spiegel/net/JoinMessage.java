package spiegel.net;

import java.io.IOException;

public class JoinMessage extends Message {

	@Override
	public void handleMessage(ChatGui gui) {
		message = message.substring(5);
		try {
			gui.sendAnnounce();
			gui.addToChat(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isMessage(String message) {
		if (message.startsWith("JOIN")) {
			this.message = message;
			return true;
		}
		return false;
	}

}
