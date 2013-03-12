package chayaSpiegel.ArmyUnits;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitGeneratorTest {

	@Test
	public void testGenerate() {
		UnitGenerator ug = new UnitGenerator(50);
		Unit unit = ug.generate();
		assertTrue((unit.getLocation() < 50 - unit.getSize()));
		assertTrue((unit.getSize() < 6 && unit.getSize() > 0));
	}

}
