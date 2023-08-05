import java.util.ArrayList;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: bevShop class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
public class BevShop implements BevShopInterface {

	private int numOfAlcDrinksInOrder;
	private ArrayList<Order> orders;

	public BevShop() {
		orders = new ArrayList<>();
	}

	@Override
	public boolean isValidTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		return false;
	}

	// got to do this one
	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > MAX_FRUIT) {
			return true;
		} else
			return false;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		if (numOfAlcDrinksInOrder < MAX_ORDER_FOR_ALCOHOL) {
			return true;
		} else
			return false;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		return numOfAlcDrinksInOrder;
	}

	@Override
	public boolean isValidAge(int age) {
		if (age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
		} else
			return false;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));

	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Order currentOrder = getCurrentOrder();
		if (currentOrder != null) {
			currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
			if (extraShot) {
				System.out.println("You have added an extra shot");
			}
			if (extraSyrup) {
				System.out.println("You have added extra syrup");

			}
			if (!(extraShot || extraSyrup)) {
				System.out.println("You haven't added any add ons");
			}
			System.out.println("The current order of drinks is " + currentOrder.getTotalItems());
			System.out.println("The Total Price on the Order: " + String.format("%.2f", currentOrder.calcOrderTotal()));

		}
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		Order currentOrder = getCurrentOrder();
		if (currentOrder != null) {
			currentOrder.addNewBeverage(bevName, size);
			System.out.println("The current order of drinks is " + currentOrder.getTotalItems());
			System.out.println("The Total Price on the Order: " + String.format("%.2f", currentOrder.calcOrderTotal()));
			if (currentOrder.getNumOfAlcoholDrink() < getMaxOrderForAlcohol()) {
				System.out.println("Your current alcohol drink order is less than " + (getMaxOrderForAlcohol() + 1));
				if (currentOrder.getBeverage(currentOrder.getTotalItems() - 1) instanceof Alcohol) {
					numOfAlcDrinksInOrder++;
				}
			} else {
				System.out.println("You have a maximum alcohol drinks for this order");
				
			}
		}
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Order currentOrder = getCurrentOrder();
		if (currentOrder != null) {
			currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
			System.out.println("Total number of fruits is " + numOfFruits);
			System.out.println("The current order of drinks is " + currentOrder.getTotalItems());
			System.out.println("The Total Price on the Order: " + String.format("%.2f", currentOrder.calcOrderTotal()));
			if (numOfFruits >= MAX_FRUIT) {
				System.out.println("You reached a Maximum number of fruits");
			}
		}
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		int index = findOrder(orderNo);
		if (index != -1) {
			double orderTotal = orders.get(index).calcOrderTotal();

	        // Format the orderTotal to have two decimal places
	        orderTotal = Double.parseDouble(String.format("%.2f", orderTotal));

	        return orderTotal;
	    }
		
		return -1.0;
	}

	@Override
	public double totalMonthlySale() {
		double totalSale = 0.0;
		for (Order order : orders) {
			totalSale += order.calcOrderTotal();
		}
	    totalSale = Math.round(totalSale * 100.0) / 100.0;

		return totalSale;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();

	}

	@Override
	public Order getCurrentOrder() {
		if (orders.isEmpty()) {
			return null;
		}
		return orders.get(orders.size() - 1);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		if (index >= 0 && index < orders.size()) {
			return orders.get(index);
		}
		return null;
	}

	@Override
	public void sortOrders() {
		int n = orders.size();
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Order temp = orders.get(i);
				orders.set(i, orders.get(minIndex));
				orders.set(minIndex, temp);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Order order : orders) {
			sb.append(order.toString()).append("\n");
		}
		sb.append("Total Monthly Sale: $").append(String.format("%.2f", totalMonthlySale()));
		return sb.toString();
	}

}
