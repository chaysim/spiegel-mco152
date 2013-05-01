package spiegel.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	private ServerSocket server;
	private Socket socket;

	public Server() throws IOException {
		server = new ServerSocket(1025);
		socket = server.accept();// waits for call from client, this is blocking

		OutputStream out = socket.getOutputStream();
		out.write("CONNECTED TO SERVER\n".getBytes());
		out.flush();
		InputStream in = socket.getInputStream();

		Scanner inputStreamReader = new Scanner(in);

		Scanner keyboard = new Scanner(System.in);
		String str;
		while (true) {
			str = inputStreamReader.nextLine();
			System.out.println(str);

			str = keyboard.nextLine() + "\n";
			out.write(str.getBytes());
			out.flush();
		}
		// server.close();
	}

}