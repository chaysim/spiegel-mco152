package spiegel.net;

import java.io.IOException;

public class LeaveMessage extends Message {
	@Override
	public void handleMessage(ChatGui gui) {
		String name = message.substring(6);
		message = name + " has left";
		try {
			gui.addToChat(message);
			gui.removeFromChatters(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isMessage(String message) {
		if (message.startsWith("LEAVE")) {
			this.message = message;
			return true;
		}
		return false;
	}

}
