package chayaSpiegel.ArmyUnits;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArmyLineTest {

	@Test
	public void testCompleteProgram() {
		// create an ArmyLine
		ArmyLine armyLine = new ArmyLine(20);
		// create a unit that will begin at slot 2
		Unit newUnit = new Unit(2, 3);
		// create a unit set to begin at slot 3
		Unit secondUnit = new Unit(3, 3);
		// verify that the first unit will fit
		assertEquals(true, armyLine.verifyFit(newUnit));
		// add the first unit
		armyLine.addUnits(newUnit);
		// verify that it went and location is set to slot 2
		assertEquals(2, armyLine.getUnits()[2].getLocation());
		// verify that the second unit won't fit
		assertFalse(armyLine.verifyFit(secondUnit));
		// verify that the second unit will go to slot 5
		assertEquals(5, armyLine.findFirstSlot(secondUnit));
		// add the second unit
		armyLine.addUnits(secondUnit);
		// verify that it went and location is set to slot 5
		assertEquals(5, armyLine.getUnits()[5].getLocation());

	}

	@Test
	public void testFindFirstSlot() {
		// create an ArmyLine
		ArmyLine armyLine = new ArmyLine(20);
		// create a unit that will begin at slot 2
		Unit newUnit = new Unit(2, 3);
		// when the unit is sent to find a first slot,
		// it should return 0
		assertEquals(0, armyLine.findFirstSlot(newUnit));
	}

	@Test
	public void testVerifyFitWithoutSLot() {
		// create an ArmyLine
		ArmyLine armyLine = new ArmyLine(20);
		// create a unit that will begin at slot 2
		Unit newUnit = new Unit(2, 3);
		// verify that the unit will fit
		assertEquals(true, armyLine.verifyFit(newUnit));
	}

	@Test
	public void testVerifyFitWithSLot() {
		// create an ArmyLine
		ArmyLine armyLine = new ArmyLine(20);
		// create a unit that will begin at slot 2
		Unit newUnit = new Unit(2, 3);
		// verify that the first unit will fit into a specific slot
		assertEquals(true, armyLine.verifyFit(newUnit, 7));
	}

	@Test
	public void testVerifyWontFit() {
		// create an ArmyLine
		ArmyLine armyLine = new ArmyLine(20);
		// create a unit that will begin at slot 2
		// it is 30 units long and shouldn't fit
		Unit newUnit = new Unit(2, 30);
		// verify the unit won't fit
		assertFalse(armyLine.verifyFit(newUnit));
	}

	@Test
	public void testFindFirstSlotWontFit() {
		// create an ArmyLine
		ArmyLine armyLine = new ArmyLine(20);
		// create a unit that will begin at slot 2
		// it is 30 units long and shouldn't fit
		Unit newUnit = new Unit(2, 30);
		// verify the unit won't fit
		assertEquals(-1, armyLine.findFirstSlot(newUnit));
	}
}
