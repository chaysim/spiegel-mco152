package spiegel.net;

import java.io.IOException;

public class SayMessage extends Message {
	@Override
	public void handleMessage(ChatGui gui) {
		message = message.substring(4);
		try {
			gui.addToChat(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isMessage(String message) {
		if (message.startsWith("SAY")) {
			this.message = message;
			return true;
		}
		return false;
	}
}
