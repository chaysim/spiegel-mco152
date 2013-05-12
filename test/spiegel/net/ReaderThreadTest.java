package spiegel.net;

import static org.mockito.Mockito.times;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.mockito.Mockito;

public class ReaderThreadTest {

	@Test
	public void testReadAndAppend() throws IOException {
		Socket socket = Mockito.mock(Socket.class);
		ChatGui gui = Mockito.mock(ChatGui.class);
		ByteArrayInputStream in = new ByteArrayInputStream("hello\n".getBytes());
		Mockito.when(socket.getInputStream()).thenReturn(in);
		ReaderThread thread = new ReaderThread(socket, gui);
		try {
			thread.run();
		} catch (NoSuchElementException e) {

		}
		Mockito.verify(gui, times(1)).addToChat(Mockito.anyString());
	}

}
