package spiegel.fire;

import java.util.Random;
import java.util.Stack;

public class Fountain {

	private Random randomNum;
	private int x, y;


	public Fountain(int x, int y) {
		this.randomNum = new Random();
		this.x = x;
		this.y = y;
	}

	public Projectile addProjectiles() {
		Projectile p = new Projectile(randomNum.nextInt(111) + 35,
				randomNum.nextInt(40) + 60, x, y);
		return p;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
