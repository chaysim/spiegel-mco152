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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton sendBtn;
	private JTextField compose;
	private JTextArea chat;
	private JTextArea chatters;
	private JScrollPane scroll;
	private ReaderThread readerThread;
	private Socket socket;
	private OutputStream out;
	private String name;

	public ChatGui() throws IOException {
		super();
		name = JOptionPane.showInputDialog("Enter your name");
		sendBtn = new JButton("Send");
		compose = new JTextField();
		compose.addKeyListener(new EnterListener());
		chat = new JTextArea();
		chatters = new JTextArea();
		chatters.setEnabled(false);
		chatters.setSize(20, 200);
		chatters.setText("Currently chatting");
		scroll = new JScrollPane(chat);
		chat.setEditable(false);
		setLayout(new BorderLayout());
		add(chatters, BorderLayout.EAST);
		add(scroll, BorderLayout.CENTER);
		add(new ComposePanel(sendBtn, compose), BorderLayout.SOUTH);
		sendBtn.addActionListener(new ClickListener());
		setVisible(true);
		setSize(400, 300);
		setName("Chat");
		initializeClient();
		readerThread.start();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		prepareClose();
	}

	public void addToChatters(String line) {
		if (!chatters.getText().contains(line)) {
			chatters.setText(chatters.getText() + "\n" + line);
		}
	}

	public void removeFromChatters(String line) {
		if (chatters.getText().contains(line)) {
			chatters.setText(chatters.getText().replace(line, "") + "\b");

		}
	}

	public void sendAnnounce() throws IOException {
		String s = "ANNOUNCE " + name + "\n";
		out.write(s.getBytes());
		out.flush();
	}

	public void prepareClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String s = "LEAVE " + name;
				try {
					out.write(s.getBytes());
					out.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
					System.exit(0);
				}
				System.exit(0);
			}
		});
	}

	private void initializeClient() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.126", 8080);
		out = socket.getOutputStream();
		readerThread = new ReaderThread(socket, this);
		String s = "JOIN " + name + "\n";
		out.write(s.getBytes());
		out.flush();
	}

	public void addToChat(String s) throws IOException {
		chat.setText(chat.getText() + "\n" + s);
	}

	public void sendTheChat() throws IOException {
		String s = "SAY " + name + ": " + compose.getText() + "\n";
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

		private static final long serialVersionUID = 1L;

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