package spiegel.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		@SuppressWarnings("resource")
		Socket socket = new Socket("192.168.117.119", 1025);
		InputStream in = socket.getInputStream();
		OutputStream output = socket.getOutputStream();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(in);
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			System.out.println(scanner.nextLine());

			String message = keyboard.nextLine() + "\n";
			output.write(message.getBytes());
			output.flush();
		}

	}

}
