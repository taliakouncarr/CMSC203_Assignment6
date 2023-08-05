/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: coffee class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
public class Coffee extends Beverage {

	// instance variables
	private boolean extraShot;
	private boolean extraSyrup;
	

	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;

	}

	public boolean getExtraShot() {
		return extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	@Override
	public double calcPrice() {
		double price = super.getBasePrice();

		if (super.getSize() == Size.MEDIUM) {
		price += super.getSIZE_PRICE();
		}
		else if (super.getSize() == Size.LARGE) {
		price += 2 * super.getSIZE_PRICE();
		}

		if (extraShot) {
		price += 0.5;
		}
		if (extraSyrup) {
		price += 0.5;
	}
		return price;
	}

	@Override
	public String toString() {
		return getBevName() + "," + getSize() + "," + extraShot + "," + extraSyrup + "," + calcPrice();
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev)
			return true;
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;
		Coffee coffee = (Coffee) anotherBev;
		return getBevName().equals(coffee.getBevName()) && getType() == coffee.getType()
				&& getSize() == coffee.getSize() && calcPrice() == coffee.calcPrice() && extraShot == coffee.extraShot
				&& extraSyrup == coffee.extraSyrup;
	}
}
