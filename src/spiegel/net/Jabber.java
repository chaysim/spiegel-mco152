package spiegel.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Jabber {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket socket = new Socket("localhost", 8080);
		OutputStream output = socket.getOutputStream();
		for (int i = 0; i < 1000; i++) {
			String message = "This is message number " + i + "\n";
			output.write(message.getBytes());
			output.flush();

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
