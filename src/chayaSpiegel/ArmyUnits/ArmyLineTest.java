package chayaSpiegel.ArmyUnits;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArmyLineTest {

	@Test
	public void testAddUnits() {
		//create an ArmyLine
		ArmyLine armyLine = new ArmyLine(20);
		//create a unit that will begin at slot 2
		Unit newUnit = new Unit(2, 3);
		//create a unit set to begin at slot 3
		Unit secondUnit = new Unit(3, 3);
		//verify that the first unit will fit
		assertEquals(true, armyLine.verifyFit(newUnit));
		//add the first unit
		armyLine.addUnits(newUnit);
		//verify that it went and was set to slot 2
		assertEquals(2, armyLine.getUnits()[2].getLocation());
		//verify that the second unit won't fit
		assertNotSame(true, armyLine.verifyFit(secondUnit));
		//verify that the second unit will go to slot 5
		assertEquals(5, armyLine.findFirstSlot(secondUnit));
		//add the second unit
		armyLine.addUnits(secondUnit);
		//verify that it went and was set to slot 5
		assertEquals(5, armyLine.getUnits()[5].getLocation());
		
	}
}
