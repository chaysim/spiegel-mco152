package spiegel.net;

public abstract class Message {
	protected String message;

	public Message() {

	}

	public abstract void handleMessage(ChatGui gui);

	// use gui method to do whatever it needs

	public abstract boolean isMessage(String message);
	// tests that the message is the right kind

}
