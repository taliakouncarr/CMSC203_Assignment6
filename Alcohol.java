/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Alcohol class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/

public class Alcohol extends Beverage {

	// instance var
	private boolean isWeekend;
	private final double PRICE_FOR_WEEKEND = .60;

	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;

	}

	public boolean isWeekend() {
		return isWeekend;
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

		if (isWeekend) {
		price += PRICE_FOR_WEEKEND;
		}

		return price;	}

	@Override
	public String toString() {
		return getBevName() + "," + getSize() + "," + isWeekend + "," + calcPrice();
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev)
			return true;
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;
		Alcohol alcohol = (Alcohol) anotherBev;
		return getBevName().equals(alcohol.getBevName()) && getType() == alcohol.getType()
				&& getSize() == alcohol.getSize() && calcPrice() == alcohol.calcPrice()
				&& isWeekend == alcohol.isWeekend();
	}
}
