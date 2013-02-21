package spiegel.projectile;

import java.awt.Color;

public class Projectile {
	private int angle;
	private int velocity;
	private double x;
	private double y;
	private double time;
	private Color color;

	public Projectile(int angle, int velocity, Color color) {
		this.angle = angle;
		this.velocity = velocity;
		x = 0;
		y = 0;
		this.time = 0;
		this.setColor(color);
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

	public double getTime() {
		return time;
	}

	public void addTime(double delta) {
		time += delta;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
