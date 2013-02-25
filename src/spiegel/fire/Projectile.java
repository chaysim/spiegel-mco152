package spiegel.fire;

import java.awt.Color;

public class Projectile {
	private int angle;
	private int velocity;
	private double x;
	private double y;
	private Color color;
	private double time;

	public Projectile(int angle, int velocity) {
		this.angle = angle;
		this.velocity = velocity;
		x = 0;
		y = 0;
		this.color = Color.white;
		this.time = 0;
	}

	public double getX() {
		x = Math.cos(Math.toRadians(angle)) * velocity * time;
		return x;
	}

	public double getY() {
		y = Math.sin(Math.toRadians(angle)) * velocity * time + (.5) * -9.8
				* (time * time);
		return y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public Color getColor() {
		if (time <= .1)
			color = Color.white;
		else if (time <= .3)
			color = Color.yellow;
		else if (time <= .4)
			color = Color.red;
		else if (time <= .6)
			color = Color.orange;
		else if (time <= .8)
			color = Color.red;
		else if (time <= 1)
			color = Color.gray;
		else
			color = Color.lightGray;
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getTime() {
		return time;
	}

	public void addTime(double delta) {
		this.time = time + delta;
	}

}
