package spiegel.net;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea pastText;

	public JTextArea getPastText() {
		return pastText;
	}

	public void setPastText(JTextArea pastText) {
		this.pastText = pastText;
	}

	private JTextField currText;
	private JPanel textPanel;
	private JButton send;
	private ServerSocket server;
	private Socket socket;
	private OutputStream out;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ChatGui() throws IOException {
		setTitle("Chat Box");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.pastText = new JTextArea(20, 1);
		pastText.setLineWrap(true);
		this.currText = new JTextField(20);
		this.textPanel = new JPanel(new BorderLayout());
		this.send = new JButton("Send");
		JPanel sideBySide = new JPanel(new BorderLayout());
		sideBySide.add(currText, BorderLayout.WEST);
		sideBySide.add(send, BorderLayout.EAST);
		textPanel.add(sideBySide, BorderLayout.SOUTH);
		this.add(textPanel);
		textPanel.add(pastText, BorderLayout.NORTH);
		send.addActionListener(new ButtonListener());
		setVisible(true);
		server();
	}

	public void server() throws IOException {
		this.server = new ServerSocket(1025);
		socket = server.accept();
		out = socket.getOutputStream();

	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton pressed = (JButton) e.getSource();
			if (pressed == send) {
				if (!currText.getText().isEmpty()) {
					String text = currText.getText() + "\n";
					try {
						out.write(text.getBytes());
						out.flush();
					} catch (IOException e1) {

						e1.printStackTrace();
					}

					pastText.append(text);
				}
				currText.setText("");
			}

		}

	}

	public static void main(String[] args) throws IOException {

		ChatGui gui = new ChatGui();
		ReaderThread rThread = new ReaderThread(gui.getSocket(), gui);
		rThread.start();
	}
}
