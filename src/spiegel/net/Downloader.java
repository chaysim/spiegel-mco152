package spiegel.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;

public class Downloader {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket socket = new Socket("www.amazon.com", 80);
		OutputStream output = socket.getOutputStream();
		output.write("GET /index.html\n\n".getBytes());
		output.flush();
		InputStream input = socket.getInputStream();
		String s = IOUtils.toString(input);
		System.out.println(s);
		socket.close();
	}
}
