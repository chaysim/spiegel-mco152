package spiegel.fire;

import java.awt.Color;
import java.util.Stack;

public class Projectile {
	private int angle;
	private int velocity;
	private double x;
	private double y;
	private Color color;
	private double time;
	private double angleCosRadiansX;
	private double angleSinRadiansY;
	private int pointX, pointY;

	public Projectile(int angle, int velocity, int pointX, int pointY) {
		this.angle = angle;
		this.velocity = velocity;
		x = 0;
		angleCosRadiansX = Math.cos(Math.toRadians(angle));
		angleSinRadiansY = Math.sin(Math.toRadians(angle));
		y = 0;
		this.color = Color.white;
		this.time = 0;
		this.pointX = pointX;
		this.pointY = pointY;

	}

	public double getX() {
		x = angleCosRadiansX * velocity * time + pointX;
		return x;
	}

	public double getY() {
		y = angleSinRadiansY * velocity * time + (.5) * -9.8 * (time * time)
				+ pointY;
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
		else if (time <= 1)
			color = Color.yellow;
		else if (time <= 2)
			color = Color.orange;
		else if (time <= 3)
			color = Color.red;
		else 
			color = Color.gray;
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

	public void setPointX(int pointX) {
		this.pointX = pointX;
	}

	public void setPointY(int pointY) {
		this.pointY = pointY;
	}

	public void setTime(double time) {
		this.time = time;
	}

}
