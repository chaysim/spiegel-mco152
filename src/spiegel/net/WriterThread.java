package spiegel.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriterThread extends Thread {
	private LinkedBlockingQueue<String> queue;
	private LinkedList<OutputStream> outputStreamList;

	public final static Logger log = Logger.getLogger(WriterThread.class
			.getName());

	public WriterThread() {
		queue = new LinkedBlockingQueue<String>();
		outputStreamList = new LinkedList<OutputStream>();
	}

	public void addMessage(String msg) {
		queue.add(msg);
	}

	public void addOutputStream(OutputStream o) {
		outputStreamList.add(o);
	}

	public void addOutputStream(Socket s) throws IOException {
		outputStreamList.add(s.getOutputStream());
	}

	public void writeFirstMessage() throws IOException, InterruptedException {
		log.log(Level.INFO, "Entered WriterThread's writeFirstMessage");

		String msg = queue.take() + "\n";
		writeMessageToStream(msg);

	}

	private void writeMessageToStream(String msg) {
		Iterator<OutputStream> iterator = outputStreamList.iterator();
		while (iterator.hasNext()) {
			try {
				OutputStream out = iterator.next();
				out.write(msg.getBytes());
				out.flush();
			} catch (Exception e) {
				addMessage("Someone has left");
				iterator.remove();
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				log.log(Level.INFO, "Entered WriterThread's run");
				writeFirstMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}