package spiegel.projectile;

import java.awt.Color;

public class Projectile {
	private int angle;
	private int velocity;
	private double x;
	private double y;
	private Color c;

	public Projectile(int angle, int velocity, Color c) {
		this.angle = angle;
		this.velocity = velocity;
		x = 0;
		y = 0;
		this.c = c;
	}

	public double getX(double time) {
		double x = Math.cos(Math.toRadians(angle)) * velocity * time;
		return x;
	}

	public double getY(double time) {
		double y = Math.sin(Math.toRadians(angle)) * velocity * time + (.5)
				* -9.8 * (time * time);
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

	@Override
	public String toString() {
		return "Parabola angle=" + angle + ", velocity=" + velocity + ", x="
				+ x + ", y=" + y + ".";
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public static void main(String[] args) {

		Projectile[] a = new Projectile[11];
		for (int i = 0; i < 11; i++) {
			Projectile pb = new Projectile(i, 25, Color.red);
			System.out.println(pb);
			a[i] = pb;
		}

	}
}
