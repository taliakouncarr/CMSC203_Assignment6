/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: bevShopDriver class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
public class BevShopDriverApp {

	public static void main(String[] args) {
		BevShop bevShop = new BevShop();

		// intro messages
		System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol()
				+ " alcoholic beverages.");
		System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol() + "\n");

		// starting first order
		bevShop.startNewOrder(12, Day.TUESDAY, "Jones", 40);
		// create new customer object
		Customer customerOne = bevShop.getCurrentOrder().getCustomer();

		System.out.println("Start please a new order:");
		System.out.println(
				"Your Total Order for now is " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));
		System.out.println("Would you please enter your name " + customerOne.getName());
		System.out.println("Would you please enter your age " + customerOne.getAge());
		// if for eligibilty
		if (customerOne.getAge() >= bevShop.getMinAgeForAlcohol()) {
			System.out.println(
					"Your age is above " + bevShop.getMinAgeForAlcohol() + " and you are eligible to order alcohol");
		} else
			System.out.println("Your age is not appropriate for alcohol drink!");

		System.out.println("Would you please add an ALCOHOLIC DRINK to order ");
		// add if for eligibilty
		if (customerOne.getAge() >= bevShop.getMinAgeForAlcohol()) {

			bevShop.processAlcoholOrder("Green Tea Shot", Size.MEDIUM);

		} else
			System.out.println("Your age is not appropriate for alcohol drink!");


		System.out.println("Would you please add a SMOOTHIE to your order: ");

		bevShop.processSmoothieOrder("Kiwi Smoothie", Size.LARGE, 2, true);

		System.out.println("Would you please add a COFFEE to your order: ");
		bevShop.processCoffeeOrder("Chocolate Latte", Size.SMALL, false, false);
		

		System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getTotalItems());
		System.out.println(
				"The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));

		// Adding another order
		bevShop.startNewOrder(1, Day.SUNDAY, "Johnny", 13);
		Customer customerTwo = bevShop.getCurrentOrder().getCustomer();

		System.out.println("#------------------------------------#");
		System.out.println("Would you please start a new order");
		System.out.println("Would you please enter your name: " + customerTwo.getName());
		System.out.println("Would you please enter your age: " + customerTwo.getAge());

		System.out.println("Would you please add an ALCOHOLIC DRINK to order ");

		// add if for eligibilty
		if (customerTwo.getAge() >= bevShop.getMinAgeForAlcohol()) {
			System.out.println(
					"Your age is above " + bevShop.getMinAgeForAlcohol() + " and you are eligible to order alcohol");
			bevShop.processAlcoholOrder("Wine", Size.SMALL);

		} else
			System.out.println("Your age is not appropriate for alcohol drink!");
		System.out.println(
				"The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()));

		System.out.println("Would you please add a SMOOTHIE to order: ");
		bevShop.processSmoothieOrder("Blueberry", Size.SMALL, 4, false);
		System.out.println("Would you please add a COFFEE to order ");
		bevShop.processCoffeeOrder("Iced Coffee", Size.LARGE, false, true);

		System.out.println("Would you please add a COFFEE to order ");
		bevShop.processCoffeeOrder("Large Coffee", Size.LARGE, false, true);

		

		System.out.println("\nTotal price on the second Order: "
				+ bevShop.totalOrderPrice(bevShop.getOrderAtIndex(1).getOrderNo()));
		System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());

		// using the toString from bevShop
		System.out.println("\n" + bevShop.toString());
	}
}
