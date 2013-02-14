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

	public GraphComponent() {
		Random randomNum = new Random();

		arcs = new Projectile[5];
		for (int i = 0; i < arcs.length; i++) {
			Projectile a = new Projectile(randomNum.nextInt(180),
					randomNum.nextInt(500), color(i));
			arcs[i] = a;
		}
	}

	// override method- here we can fill a paint component
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
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
	public void trails()
	{
		
	}
	public void gridlines()
	{
		
	}
	public void randomColors()
	{
		
	}
	public void continuousLifespan()
	{
		
	}
	public Color color(int i) {
		i += 1;
		Color j = new Color(i * 40, i * 20, i * 32, i * 50);
		return j;
	}

}
