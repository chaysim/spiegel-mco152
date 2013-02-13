package spiegel.parabola;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import spiegel.parabola.Projectile;

public class ProjectileTest {
	private Projectile pb;
	private Projectile pb2;

	@Before
	public void setUp() throws Exception {
		pb = new Projectile(0, 37, 73);
		pb2 = new Projectile(5, 37, 73);
	}

	@Test
	public void testGet0() {
		Assert.assertEquals(0.0, pb.getX(), .1);
		Assert.assertEquals(0.0, pb.getY(), .1);	
	}

	@Test
	public void testGet5() {
		Assert.assertEquals(291.5, pb2.getX(), .1);
		Assert.assertEquals(97.10, pb2.getY(), .1);
	}

}
