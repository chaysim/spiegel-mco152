package spiegel.projectile;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JComponent;
//set origin at center
//random velocities and angles
//grid lines
//trails
//random colors
//images instead of ovals
//coordinates
//continuous
//life span

public class GraphComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private double time = 0;
	private Projectile[] arcs;
	private Random randomNum;
	private long currentTime;

	public GraphComponent() {
		randomNum = new Random();
		currentTime = Calendar.getInstance().getTimeInMillis();
		arcs = new Projectile[5];
		for (int i = 0; i < arcs.length; i++) {
			Projectile a = new Projectile(randomNum.nextInt(180),
					randomNum.nextInt(500), color());
			arcs[i] = a;
		}
	}

	// override method- here we can fill a paint component
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		gridlines(g);
		g.translate(getWidth() / 2, getHeight() / 2);
		time += .009;
		int x1 = 0, y1 = 0;
		for (int i = 0; i < arcs.length; i++) {
			continuousLifespan(g, x1, y1);
			x1 = (int) arcs[i].getX(time) - 5;
			y1 = (int) -arcs[i].getY(time) - 5;
			g.setColor(arcs[i].getC());
			g.fillOval(x1, y1, 10, 10);
		}

		this.repaint();
	}

	public void drawTrail(Graphics g, int x, int y, int size1, int size2) {
		g.fillOval(x, y, size1, size2);
	}

	public void gridlines(Graphics g) {
		int height = 0, width = 0;
		while (width <= getWidth()) {
			g.drawLine(width, height, width, getHeight());
			width += 20;
		}
		height = 0;
		width = 0;
		while (height <= getHeight()) {
			g.drawLine(width, height, getWidth(), height);
			height += 20;
		}
	}

	public void continuousLifespan(Graphics g, int x1, int y1) {
		long timeNow = Calendar.getInstance().getTimeInMillis();
		if (timeNow > currentTime + 60000){
			System.exit(0);
		}
		if (y1 < -300 && x1 < -400 || y1 > 300 && x1 > 400) {
			time = 0;
		}
	}

	public Color color() {

		Color j = new Color(randomNum.nextInt(255), randomNum.nextInt(255),
				randomNum.nextInt(255));
		return j;
	}

}
