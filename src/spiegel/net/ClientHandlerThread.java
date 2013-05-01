package spiegel.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandlerThread extends Thread {

	private Socket socket;
	private InputStream in;

	public ClientHandlerThread(Socket socket) throws IOException {
		this.socket = socket;
		in = socket.getInputStream();
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(in);

		while (scanner.hasNext()) {
			System.out.println(scanner.nextLine());
		}

	}

}
