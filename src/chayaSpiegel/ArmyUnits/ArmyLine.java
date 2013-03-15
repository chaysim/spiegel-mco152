package chayaSpiegel.ArmyUnits;

public class ArmyLine {

	private UnitGenerator unitGenerator;
	// the ArmyLine
	private Unit[] units;

	public ArmyLine(int size) {
		this.unitGenerator = new UnitGenerator(size);
		units = new Unit[size];
	}

	// a method that will generate a new unit every time it is called
	// it verifies that the unit fits into its default location
	// if it doesn't it find the correct place for it
	public void addUnits() throws Exception {
		Unit newUnit = unitGenerator.generate();
		// if the unit fits where is is set by default
		if (verifyFit(newUnit)) {
			// fill the line
			fillLine(newUnit);
		}
		// the unit doesn't fit where it is ste by default
		else {
			// get a new starting point
			int firstSlot = findFirstSlot(newUnit);
			// if there is a slot that the unit will fit into
			if (firstSlot != -1) {
				// reset the unit location
				newUnit.setLocation(firstSlot);
				// fill the line
				fillLine(newUnit);
			}
			// there is no space, throw Exception
			else {
				throw new Exception("No space exists for this unit");
			}
		}
	}

	// another method to add, does the same thing as above method
	// but allows you to enter a unit as opposed to generating
	// to be used for testing
	public void addUnits(Unit newUnit) {

		if (verifyFit(newUnit)) {
			for (int i = 0; i < newUnit.getSize(); i++) {
				units[newUnit.getLocation() + i] = newUnit;
			}
		} else {
			int firstSlot = findFirstSlot(newUnit);
			if (firstSlot != -1) {
				newUnit.setLocation(firstSlot);
				for (int i = 0; i < newUnit.getSize(); i++) {
					units[newUnit.getLocation() + i] = newUnit;
				}
			}
		}
	}

	public void fillLine(Unit newUnit) {
		// loop to fill the ArmyLine, by the length of the unit
		for (int i = 0; i < newUnit.getSize(); i++) {
			// set each slot in the ArmyLine to hold the unit
			// at the location + i
			units[newUnit.getLocation() + i] = newUnit;
		}
	}

	public int findFirstSlot(Unit unit) {
		int i = 0;
		int counter = 0;
		while (i < units.length) {
			try {
				int size = units[i].getSize();
				// size is set, push i to the end of the unit
				i += size;
				// reset counter
				counter = 0;

			} catch (NullPointerException e) {
				// size is not set, increment to next spot
				i++;
				// increment counter
				counter++;
				// if size is large enough, return start location - counter
				if (counter == unit.getSize())
					return i - counter;
			}
		}
		// not enough space
		return -1;
	}

	// a method that checks if a unit will fit into
	// a specific slot
	public boolean verifyFit(Unit unit, int slot) {
		// first make sure that the unit won't go
		// over the edge of the ArmyLine
		if (slot + unit.getSize() > units.length)
			return false;
		// iterate through the line as many times as the
		// unit length
		for (int i = 0; i < unit.getSize(); i++) {
			// check if the location in the army line
			// + i is set, if it is, return false
			if (units[slot + i] != null) {
				return false;
			} else {
				continue;
			}
		}
		// the iteration completed without returning false
		// the unit fits
		return true;
	}

	// a method that checks if a unit will fit into its default slot
	public boolean verifyFit(Unit unit) {
		// first make sure that the unit won't go
		// over the edge of the ArmyLine
		// the generator won't allow it but the second AddUnit method
		// can cause it to happen
		if (unit.getSize() + unit.getLocation() > units.length)
			return false;
		// iterate through the line as many times as the
		// unit length
		for (int i = 0; i < unit.getSize(); i++) {
			// check if the location in the army line
			// + i is set, if it is, return false
			if (units[unit.getLocation() + i] != null) {
				return false;
			} else {
				continue;
			}
		}
		// the iteration completed without returning false
		// the unit fits
		return true;
	}

	public Unit[] getUnits() {
		return units;
	}
}
