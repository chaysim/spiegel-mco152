package spiegel.net;

public class SleeperThread extends Thread {

	private int sleepSeconds;

	public SleeperThread(int seconds) {
		this.sleepSeconds = seconds;
	}

	@Override
	public void run() {
		try {
			System.out.println("sleeping for " + sleepSeconds);
			Thread.sleep(10000);
			System.out.println("awake after " + sleepSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
