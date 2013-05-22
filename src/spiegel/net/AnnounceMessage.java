package spiegel.net;

public class AnnounceMessage extends Message {
	@Override
	public void handleMessage(ChatGui gui) {
		message = message.substring(9);
		gui.addToChatters(message);
	}

	@Override
	public boolean isMessage(String message) {
		if (message.startsWith("ANNOUNCE")) {
			this.message = message;
			return true;
		}
		return false;
	}
}
