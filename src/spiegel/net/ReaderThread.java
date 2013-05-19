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

	public ReaderThread(Socket socket, ChatGui gui) throws IOException {
		this.socket = socket;
		this.gui = gui;
		InputStream in = socket.getInputStream();
		scanner = new Scanner(in);
		msgFormat = new ParseMessage();
	}

	@Override
	public void run() {
		while (true) {
			String line = scanner.nextLine() + "\n";
			if (line.startsWith("JOIN")) {
				try {
					gui.sendAnnounce();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			line = msgFormat.parseMessage(line);
			try {
				if (line.startsWith("ANNOUNCE")) {
					gui.addToChatters(line);
				} else {
					gui.addToChat(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
