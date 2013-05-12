package spiegel.net;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGui extends JFrame {

	private JButton sendBtn;
	private JTextField compose;
	private JTextArea chat;
	private JScrollPane scroll;
	private ReaderThread readerThread;
	private Socket socket;
	private OutputStream out;

	public ChatGui() throws IOException {
		super();
		sendBtn = new JButton("Send");
		compose = new JTextField();
		compose.addKeyListener(new EnterListener());
		chat = new JTextArea();
		scroll = new JScrollPane(chat);
		chat.setEditable(false);
		setLayout(new BorderLayout());

		add(scroll, BorderLayout.CENTER);
		add(new ComposePanel(sendBtn, compose), BorderLayout.SOUTH);
		sendBtn.addActionListener(new ClickListener());
		setVisible(true);
		setSize(300, 200);
		setName("Chat");
		initializeClient();
		readerThread.start();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		prepareClose();

	}

	public void prepareClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String s = "LEAVE Spiegel has left";
				try {
					out.write(s.getBytes());
					out.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
	}

	private void initializeClient() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 8080);
		out = socket.getOutputStream();
		readerThread = new ReaderThread(socket, this);
		String s = "JOIN Spiegel has joined" + "\n";
		out.write(s.getBytes());
		out.flush();
	}

	public void addToChat(String s) throws IOException {
		chat.setText(chat.getText() + "\n" + s);
	}

	public void sendTheChat() throws IOException {
		String s = "SAY Spiegel: " + compose.getText() + "\n";
		compose.setText("");
		out.write(s.getBytes());
		out.flush();
	}

	public static void main(String[] args) {
		try {
			new ChatGui();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private class ComposePanel extends JPanel {
		public ComposePanel(JButton send, JTextField compose) {
			setLayout(new BorderLayout());
			add(compose, BorderLayout.CENTER);
			add(send, BorderLayout.EAST);
		}
	}

	private class ClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				sendTheChat();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	private class EnterListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {

			if (event.getKeyCode() == KeyEvent.VK_ENTER) {
				try {
					sendTheChat();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {

		}

	}

}