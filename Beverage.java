/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: beverage class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
public abstract class Beverage {

	// instance variables
	private String bevName;
	private Type type;
	private Size size;
	private final double SIZE_PRICE = 1.0;
	private final double BASE_PRICE = 2.0;

	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}

	public String getBevName() {
		return bevName;
	}

	public Type getType() {
		return type;
	}

	public Size getSize() {
		return size;
	}

	public double getBasePrice() {
		return BASE_PRICE;
	}

	// point of error here maybe if tests fail

	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}

	public abstract double calcPrice();

	public double addSizePrice() {
		switch (size) {
		case SMALL:
			return 0;
		case MEDIUM:
			return SIZE_PRICE;
		case LARGE:
			return (2 * SIZE_PRICE);
		default:
			throw new IllegalArgumentException("Invalid size");
		}
	}

	@Override
	public String toString() {
		return bevName + "," + size;
	}

	@Override
	public boolean equals(Object Bev2) {
		if (this == Bev2)
			return true;
		if (Bev2 == null || getClass() != Bev2.getClass())
			return false;
		Beverage beverage = (Beverage) Bev2;
		return bevName.equals(beverage.bevName) && type == beverage.type && size == beverage.size;
	}
}
