package spiegel.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		ServerSocket server;
		Socket socket;
		server = new ServerSocket(8080);

		while (true) {
			socket = server.accept();
			ClientHandlerThread thread = new ClientHandlerThread(socket);
			thread.start();

		}

	}

}
