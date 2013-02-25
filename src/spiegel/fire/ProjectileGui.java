package spiegel.fire;

import java.awt.*;

import javax.swing.*;

public class ProjectileGui extends JFrame {

	private static final long serialVersionUID = 1L;

	public ProjectileGui() {
		setTitle("Projectile Gui");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(new GraphComponent(), BorderLayout.CENTER);

		setVisible(true);

	}

	public static void main(String args[]) {
		new ProjectileGui();
	}

}
