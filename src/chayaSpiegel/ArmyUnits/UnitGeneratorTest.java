package chayaSpiegel.ArmyUnits;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitGeneratorTest {

	@Test
	public void testGenerate() {
		//new UnitGenerator
		UnitGenerator ug = new UnitGenerator(50);
		//new Unit
		Unit unit = ug.generate();
		//correct location?
		assertTrue((unit.getLocation() < 50 - unit.getSize()));
		//correct size?
		assertTrue((unit.getSize() < 6 && unit.getSize() > 0));
	}

}
