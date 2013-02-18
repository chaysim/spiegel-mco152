package spiegel.projectile;

import java.awt.Color;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import spiegel.projectile.Projectile;

public class ProjectileTest {
	private Projectile pb;
	private Projectile pb2;
	private double time = 2;

	@Before
	public void setUp() throws Exception {
		
		pb = new Projectile(37, 73, Color.red, 12000);
		pb2 = new Projectile(37, 73, Color.red, 12000);
	}

	@Test
	public void testGet0() {
		Assert.assertEquals(0.0, pb.getX(0), .1);
		Assert.assertEquals(0.0, pb.getY(0), .1);	
	}

	@Test
	public void testGet5() {
		Assert.assertEquals(291.5, pb2.getX(5), .1);
		Assert.assertEquals(97.10, pb2.getY(5), .1);
	}

}
