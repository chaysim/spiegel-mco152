package spiegel.parabola;

import java.awt.Color;
import java.awt.Graphics;
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

	public GraphComponent() {
		randomNum = new Random();

		arcs = new Projectile[5];
		for (int i = 0; i < arcs.length; i++) {
			Projectile a = new Projectile(randomNum.nextInt(180),
					randomNum.nextInt(500), color());
			arcs[i] = a;
		}
	}

	// testing
	// override method- here we can fill a paint component
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		gridlines(g);
		g.translate(getWidth() / 2, getHeight() / 2);
		time += .001;
		for (int i = 0; i < arcs.length; i++) {
			int x1 = (int) arcs[i].getX(time) - 5;
			int y1 = (int) -arcs[i].getY(time) - 5;
			// obviously could call from this class too
			g.setColor(arcs[i].getC());
			g.fillOval(x1, y1, 10, 10);

		}

		this.repaint();
	}

	public void trails() {

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

	public void continuousLifespan() {

	}

	public Color color() {

		Color j = new Color(randomNum.nextInt(255), randomNum.nextInt(255),
				randomNum.nextInt(255));
		return j;
	}

}
