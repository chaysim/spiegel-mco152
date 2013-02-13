package spiegel.parabola;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	// override method- here we can fill a paint component
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.translate(0, getHeight());
		int[] arcs = new int[5];
		int a1 = 0, b1 = 0, j = 0;
		for (int i = 0; i < arcs.length; i++) {
			g.setColor(color(i));
			for (j = 0; j < 20; j++) {
				Projectile a = new Projectile(j, 50 + i, 73 + i);
				g.fillOval((int) a.getX() - 5, (int) -a.getY() - 5, 10, 10);
				g.drawLine(a1, b1, (int) a.getX(), (int) -a.getY());
				a1 = (int) a.getX();
				b1 = (int) -a.getY();

			}
		}

	}

	public Color color(int i) {
		// makes it reasonably high
		i += 1;
		Color j = new Color(i * 40, i * 20, i * 32, i * 50);
		return j;
	}

}
