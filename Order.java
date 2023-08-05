import java.util.ArrayList;
import java.util.Random;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: order class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
public class Order implements OrderInterface, Comparable<Order> {

	// instance variables
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private int orderNo;
	private ArrayList<Beverage> beverages;

	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = new Customer(cust);
		beverages = new ArrayList<>();
		this.orderNo = generateOrder();

	}

	public int generateOrder() {
		Random r = new Random();
		return r.nextInt(90001 - 10000) + 10000;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public Customer getCustomer() {
		return cust;
	}
	

	public void setCustomer(Customer cust) {
		this.cust = cust;
	}

	public Day getDay() {
		return orderDay;
	}

	@Override
	public boolean isWeekend() {
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Order o) {
		if (orderNo == o.getOrderNo()) {
			return 0;
		} else if (orderNo > o.getOrderNo()) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		if (itemNo >= 0 && itemNo < beverages.size()) {
			return beverages.get(itemNo);
		}

		return null;
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));

	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, isWeekend()));

	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));

	}

	@Override
	public double calcOrderTotal() {
		double sum = 0.0;
		for (Beverage beverage : beverages) {
			sum += beverage.calcPrice();
		}
		return sum;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for (Beverage beverage : beverages) {
			if (beverage.getType() == type) {
				count++;
			}
		}
		return count;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order No: ").append(orderNo).append(", Time: ").append(orderTime).append(", Day: ").append(orderDay)
				.append(", Customer: ").append(cust).append(", Total Amount: $").append(String.format("%.2f",calcOrderTotal()))
				.append("\n");
		for (int i = 0; i < beverages.size(); i++) {
			sb.append("Item ").append(i + 1).append(": ").append(beverages.get(i)).append("\n");
		}
		return sb.toString();
	}
	public int getNumOfAlcoholDrink() {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage instanceof Alcohol) {
                count++;
            }
        }
        return count;
    }

	public int getTotalItems() {
		return beverages.size();
	}
		
	public ArrayList<Beverage> getBeverages() {
        return new ArrayList<>(beverages);
    }

}
