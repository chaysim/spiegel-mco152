package spiegel.net;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends ReaderThread {

	public Client(Socket socket, ChatGUI gui) throws IOException {
		this.socket = socket;
		this.gui = gui;

		in = socket.getInputStream();
		output = socket.getOutputStream();
	}

	@Override
	public void send(String message) throws IOException {
		output.write(message.getBytes());
		output.write("\n".getBytes());
		output.flush();
	}

	@Override
	public void run() {

		Scanner scanner = new Scanner(in);
		while (true) {
			if (scanner.hasNext()) {
				gui.getChatMessage((scanner.nextLine()));
			}

		}
	}

}