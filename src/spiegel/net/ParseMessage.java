package spiegel.net;

public class ParseMessage {

	public String parseMessage(String line) {
		if (line.substring(0, 3).compareTo("SAY") == 0) {
			line = line.substring(4);
		}
		if (line.substring(0, 4).compareTo("JOIN") == 0) {
			line = line.substring(5);
		} else if (line.substring(0, 5).compareTo("LEAVE") == 0) {
			line = line.substring(6);
		}
		return line;
	}
}
