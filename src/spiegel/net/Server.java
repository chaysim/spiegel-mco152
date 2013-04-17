package spiegel.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(1025);

		Socket socket = server.accept();
		OutputStream output = socket.getOutputStream();
		output.write("CONNECTED TO SERVER! \n".getBytes());
		output.flush();
		server.close();

	}
}
