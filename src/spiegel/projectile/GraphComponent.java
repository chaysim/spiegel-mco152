package spiegel.projectile;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;

import java.util.Random;

import javax.swing.JComponent;
//set origin at center
//random velocities and angles
//grid lines
//trails
//random colors
//images instead of ovals
//coordinates
//continuously shooting out
//life span

public class GraphComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private Random randomNum;
	private ArrayList<Projectile> projectiles;

	public GraphComponent() {
		randomNum = new Random();
		projectiles = new ArrayList<Projectile>();
	}

	public void addProjectiles() {
		Projectile projectile = new Projectile(randomNum.nextInt(90),
				randomNum.nextInt(500), color());
		projectiles.add(projectile);
	}

	// override method- here we can fill a paint component
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		gridlines(g);
		g.translate(getWidth() / 2, getHeight() / 2);
		addProjectiles();
		int x1, y1;
		for (Projectile p : projectiles) {
			x1 = (int) p.getX() - 5;
			y1 = (int) -p.getY() - 5;
			if (continuousLifespan(g, x1, y1)) {
				g.setColor(p.getColor());
				g.fillOval(x1, y1, 10, 10);
				p.addTime(.001);
			}
		}
		this.repaint();
	}

	// no longer to be used
	public void trails(Graphics g, int x1, int y1) {
		g.setColor(Color.lightGray);
		for (Projectile p : projectiles) {
			g.fillOval((int) p.getX(), (int) p.getY(), 10, 10);
		}
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

	public boolean continuousLifespan(Graphics g, int x1, int y1) {

		if (y1 > getHeight() / 2 || x1 > getWidth() / 2) {
			return false;
		} else {
			return true;
		}
	}

	public Color color() {

		Color j = new Color(randomNum.nextInt(255), randomNum.nextInt(255),
				randomNum.nextInt(255));
		return j;
	}

}
