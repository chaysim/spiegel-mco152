package spiegel.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer {
	public final static Logger log = Logger.getLogger(ChatServer.class
			.getName());

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		WriterThread writerThread = new WriterThread();
		writerThread.start();
		Socket socket;
		while ((socket = server.accept()) != null) {
			log.log(Level.INFO, "Socket Accepted");
			ClientHandlerThread clientHandlerThread = new ClientHandlerThread(
					socket, writerThread);
			clientHandlerThread.start();
		}
	}

}