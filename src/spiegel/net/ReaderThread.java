package spiegel.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReaderThread extends Thread {

	@SuppressWarnings("unused")
	private Socket socket;
	private Scanner scanner;
	private ChatGui gui;

	public ReaderThread(Socket socket, ChatGui gui) throws IOException {
		this.socket = socket;
		this.gui = gui;
		InputStream in = socket.getInputStream();
		scanner = new Scanner(in);
	}

	@Override
	public void run() {
		while (true) {
			String line = scanner.nextLine() + "\n";
			gui.getPastText().append(line);
		}
	}
}
