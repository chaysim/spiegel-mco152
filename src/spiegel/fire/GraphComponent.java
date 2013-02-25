package spiegel.fire;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private Random randomNum;
	private LinkedList<Projectile> projectiles;

	public GraphComponent() {
		randomNum = new Random();
		projectiles = new LinkedList<Projectile>();

	}

	public void addProjectiles() {
		Projectile p = new Projectile(randomNum.nextInt(145 - 35) + 35,
				randomNum.nextInt(80 - 40));
		projectiles.add(p);

	}

	// override method- here we can fill a paint component
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite
				.getInstance(AlphaComposite.SRC_OVER, .1f));
		g.translate(getWidth() / 2, getHeight() / 2);
		addProjectiles();
		Iterator<Projectile> iterator = projectiles.iterator();
		while (iterator.hasNext()) {
			Projectile p = iterator.next();
			g.setColor(p.getColor());
			int x1 = (int) p.getX() - 5, y1 = (int) -p.getY() - 5;
			if (continuousLifespan(g, p)) {
				g.fillOval(x1, y1, (int) (10), (int) (10));
			} else {
				iterator.remove();
			}
			p.addTime(.001);
		}
		this.repaint();
	}

	public boolean continuousLifespan(Graphics g, Projectile p) {

		if (p.getTime() > randomNum.nextDouble() + 1) {
			return false;
		} else {
			return true;
		}
	}

}
