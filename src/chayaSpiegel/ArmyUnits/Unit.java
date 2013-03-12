package chayaSpiegel.ArmyUnits;

public class Unit {

	private int location;
	private int size;

	public Unit(int location, int size) {
		this.location = location;
		this.size = size;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		return "Unit location=" + location + ", size=" + size ;
	}

}
