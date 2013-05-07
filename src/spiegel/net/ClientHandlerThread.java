package spiegel.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandlerThread extends Thread {

	private InputStream in;
	private Scanner scanner;
	private WriterThread writerThread;

	public ClientHandlerThread(Socket socket, WriterThread writerThread)
			throws IOException {
		this.in = socket.getInputStream();
		this.scanner = new Scanner(this.in);
		this.writerThread = writerThread;
		this.writerThread.addOutputStream(socket);
	}

	@Override
	public void run() {
		while (scanner.hasNextLine()) {
			String msg = scanner.nextLine();
			// System.out.println(msg);
			writerThread.addMessage(msg);
		}
		scanner.close();
	}
}