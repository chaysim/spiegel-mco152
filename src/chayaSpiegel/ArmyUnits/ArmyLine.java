package chayaSpiegel.ArmyUnits;

public class ArmyLine {

	private UnitGenerator unitGenerator;
	private Unit[] units;

	public ArmyLine(int size) {
		units = new Unit[size];
		this.unitGenerator = new UnitGenerator(size);
	}

	public void addUnits() {
		Unit newUnit = unitGenerator.generate();
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

			} catch (Exception e) {
				// not set
				i++;
				// increment counter
				counter++;
				// size is large enough, return start location - counter
				if (counter == unit.getSize())
					return i - counter;
			}
		}
		// not enough space
		return -1;
	}

	public boolean verifyFit(Unit unit, int slot) {
		for (int i = 0; i < unit.getSize(); i++) {
			// check if the start location + i is set
			// if it is, return false
			try {
				units[slot + i].getSize();
				return false;
			} catch (Exception e) {
				continue;
			}
		}
		return true;
	}

	public boolean verifyFit(Unit unit) {
		for (int i = 0; i < unit.getSize(); i++) {
			// check if the start location + i is set
			// if it is, return false
			try {
				units[unit.getLocation() + i].getSize();
				return false;
			} catch (Exception e) {
				continue;
			}
		}
		return true;
	}

	public Unit[] getUnits() {
		return units;
	}
}
