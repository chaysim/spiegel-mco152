package spiegel.parabola;

public class Projectile {
	private double angle;
	private double velocity;
	private int time;
	private double x;
	private double y;

	public Projectile(int time, double angle, double velocity) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		x = getX();
		y = getY();
	}

	public double getX() {
		double x = Math.cos(Math.toRadians(angle)) * velocity * time;
		return x;
	}

	public double getY() {
		double y = Math.sin(Math.toRadians(angle)) * velocity * time + (.5) * -9.8
				* (time * time);
		return y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	@Override
	public String toString() {
		return "Parabola angle=" + angle + ", velocity=" + velocity + ", x="
				+ x + ", y=" + y + ", time=" + time + ".";
	}

	public static void main(String[] args) {

		Projectile[] a = new Projectile[11];
		for (int i = 0; i < 11; i++) {
			Projectile pb = new Projectile(i, 0.645771823, 73);
			System.out.println(pb);
			a[i] = pb;
		}

	}

}
