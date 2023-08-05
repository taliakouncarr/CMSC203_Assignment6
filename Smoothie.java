/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: smoothie class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
public class Smoothie extends Beverage {

	// add instance variables
	private int numOfFruits;
	private boolean addProtein;

	private final double PRICE_OF_FRUIT = .5;
	private final double PRICE_OF_PROTEIN = 1.5;

	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}

	public int getNumOfFruits() {
		return numOfFruits;
	}

	public boolean getAddProtein() {
		return addProtein;
	}

	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
		if (super.getSize() == Size.MEDIUM) {
			price += super.getSIZE_PRICE();
		} else if (super.getSize() == Size.LARGE) {
			price += 2 * super.getSIZE_PRICE();
		}

		price += numOfFruits * PRICE_OF_FRUIT;
		if (addProtein) {
			price += PRICE_OF_PROTEIN;
		}
		return price;
	}

	@Override
	public String toString() {
		return getBevName() + "," + getSize() + "," + addProtein + "," + numOfFruits + "," + calcPrice();
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (this == anotherBev)
			return true;
		if (anotherBev == null || getClass() != anotherBev.getClass())
			return false;
		Smoothie smoothie = (Smoothie) anotherBev;
		return getBevName().equals(smoothie.getBevName()) && getType() == smoothie.getType()
				&& getSize() == smoothie.getSize() && calcPrice() == smoothie.calcPrice()
				&& numOfFruits == smoothie.numOfFruits && addProtein == smoothie.addProtein;
	}

}
