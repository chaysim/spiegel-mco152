package spiegel.fire;

import java.awt.AlphaComposite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JComponent;

//create an arraylist of 10,000 projectiles and call from it 
//when you need a new one, when you finish, you release it

public class FireView extends JComponent {

	private static final long serialVersionUID = 1L;
	private LinkedList<Projectile> projectiles;
	private LinkedList<Fountain> fountains;
	private Integer numProjectiles;
	private Stack<Projectile> pool;
	private Random randomNum;

	public FireView() {
		projectiles = new LinkedList<Projectile>();
		fountains = new LinkedList<Fountain>();
		numProjectiles = 0;
		FireMouseListener listener = new FireMouseListener();
		this.addMouseListener(listener);
		this.randomNum = new Random();
		this.pool = new Stack<Projectile>();
		createPool();
	}

	public void createPool() {
		for (int i = 0; i < 40000; i++) {
			Projectile P = new Projectile(randomNum.nextInt(111) + 35,
					randomNum.nextInt(40) + 60, 0, 0);
			pool.push(P);
		}

	}

	public void addFountain(Fountain fountain) {
		if (fountains.size() < 4)
			fountains.add(fountain);
	}

	public void addProjectiles() {
		for (Fountain f : fountains) {
			for (int i = 0; i < 75; i++) {
				Projectile p = pool.pop();
				p.setPointX(f.getX());
				p.setPointY(f.getY());
				projectiles.add(p);
				numProjectiles++;
			}
		}
	}

	// override method- here we can fill a paint component
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.white);
		g.drawString(numProjectiles.toString(), 0, getHeight());
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite
				.getInstance(AlphaComposite.SRC_OVER, .1f));
		g.translate(0, getHeight());
		addProjectiles();
		Iterator<Projectile> iterator = projectiles.iterator();
		while (iterator.hasNext()) {
			Projectile p = iterator.next();
			g.setColor(p.getColor());
			int x1 = (int) p.getX() - 5;
			int y1 = (int) -p.getY() - 5;
			if (continuousLifespan(p)) {
				g.fillOval(x1, y1, (int) (10), (int) (10));
			} else {
				iterator.remove();
			}
			p.addTime(.05);

		}
		this.repaint();
	}

	public boolean continuousLifespan(Projectile p) {

		if (p.getColor() == Color.gray) {
			p.setTime(0);
			pool.push(p);
			numProjectiles--;
			return false;
		} else {
			return true;
		}
	}

}
