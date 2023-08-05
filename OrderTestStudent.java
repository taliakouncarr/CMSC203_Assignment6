import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: order test class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
class OrderTestStudent {

	private Customer customer;
	private Order order;
    @BeforeEach
    public void setUp() {
        // Create a customer for testing
        customer = new Customer("John Doe", 30);
        // Create an Order object with some initial data
        order = new Order(10, Day.MONDAY, customer);
    }

    @Test
    public void testGetOrderNo() {
        // Ensure that getOrderNo() returns a valid order number
        int orderNo = order.getOrderNo();
        assertTrue(orderNo >= 10000 && orderNo <= 90000);
    }

    @Test
    public void testGetOrderTime() {
        // Ensure that getOrderTime() returns the correct order time
        assertEquals(10, order.getOrderTime());
    }

    @Test
    public void testGetOrderDay() {
        // Ensure that getOrderDay() returns the correct order day
        assertEquals(Day.MONDAY, order.getOrderDay());
    }

    @Test
    public void testGetCustomer() {
        // Ensure that getCustomer() returns the correct customer object
        assertEquals(customer, order.getCustomer());
    }

    @Test
    public void testIsWeekend() {
        // Ensure that isWeekend() returns the correct result for different days
        assertFalse(order.isWeekend());
        Order weekendOrder = new Order(12, Day.SATURDAY, customer);
        assertTrue(weekendOrder.isWeekend());
    }

    @Test
    public void testAddNewBeverage() {
        // Ensure that addNewBeverage() correctly adds new beverages
        order.addNewBeverage("Latte", Size.SMALL, true, false);
        order.addNewBeverage("Mojito", Size.MEDIUM);
        assertEquals(2, order.getTotalItems());
        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
    }

    @Test
    public void testCalcOrderTotal() {
        // Ensure that calcOrderTotal() calculates the total price correctly
        order.addNewBeverage("Latte", Size.SMALL, true, false);
        order.addNewBeverage("Mojito", Size.MEDIUM);
        double expectedTotal = 0.0;
        for (Beverage beverage : order.getBeverages()) {
            expectedTotal += beverage.calcPrice();
        }
        assertEquals(expectedTotal, order.calcOrderTotal(), 0.001);
    }
}
