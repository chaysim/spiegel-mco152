package chayaSpiegel.ArmyUnits;

import java.util.Random;

public class UnitGenerator {

	private int lineSize;

	public UnitGenerator(int lineSize) {
		this.lineSize = lineSize;
	}

	public Unit generate() {
		Random randomNum = new Random();
		// unitSize is a random number up to 5, not including 0
		int unitSize = randomNum.nextInt(5)+1;
		// location is a random number up to lineSize - unitSize
		int location = randomNum.nextInt(lineSize - unitSize);
		// create a unit - variables already created for clarity
		Unit newUnit = new Unit(location, unitSize);
		return newUnit;
	}

}
