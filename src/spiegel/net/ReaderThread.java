package spiegel.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReaderThread extends Thread {

	private Socket socket;
	private Scanner scanner;
	private ChatGui gui;
	private ParseMessage msgFormat;
	private Message[] messages;

	public ReaderThread(Socket socket, ChatGui gui) throws IOException {
		this.setSocket(socket);
		this.gui = gui;
		InputStream in = socket.getInputStream();
		scanner = new Scanner(in);
		msgFormat = new ParseMessage();
		messages = new Message[] { new JoinMessage(), new LeaveMessage(),
				new SayMessage(), new AnnounceMessage() };
	}

	@Override
	public void run() {
		while (true) {
			String line = scanner.nextLine() + "\n";
			for (Message message : messages) {
				if (message.isMessage(line)) {
					message.handleMessage(gui);
					break;
				}
			}
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}
