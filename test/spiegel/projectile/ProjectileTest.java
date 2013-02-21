package spiegel.projectile;

import java.awt.Color;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import spiegel.projectile.Projectile;

public class ProjectileTest {
	private Projectile pb;
	private Projectile pb2;
	

	@Before
	public void setUp() throws Exception {
		
		pb = new Projectile(37, 73, Color.red);
		pb2 = new Projectile(37, 73, Color.red);
	}

	@Test
	public void testGet0() {
		Assert.assertEquals(0.0, pb.getX(), .1);
		Assert.assertEquals(0.0, pb.getY(), .1);	
	}

	@Test
	public void testGet5() {
		pb2.addTime(5);
		Assert.assertEquals(291.5, pb2.getX(), .1);
		Assert.assertEquals(97.10, pb2.getY(), .1);
	}

}
