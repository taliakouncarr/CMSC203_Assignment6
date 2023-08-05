import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: coffee test class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
class CoffeeTestStudent {

	 @Test
	    public void testCalcPrice() {
	        Coffee coffee1 = new Coffee("Latte", Size.SMALL, true, true);
	        Coffee coffee2 = new Coffee("Espresso", Size.MEDIUM, false, false);

	        // Test price calculation for a small coffee with extra shot and syrup
	        
	        assertEquals(3, coffee1.calcPrice(), 0.001);

	        // Test price calculation for a medium-sized coffee without extra shot and syrup
	        assertEquals(3, coffee2.calcPrice(), 0.001);
	    }

	    @Test
	    public void testToString() {
	        Coffee coffee = new Coffee("Cappuccino", Size.LARGE, true, false);
	        String expectedString = "Cappuccino,LARGE,true,false," + coffee.calcPrice();
	        assertEquals(expectedString, coffee.toString());
	    }

	    @Test
	    public void testEquals() {
	        Coffee coffee1 = new Coffee("Americano", Size.MEDIUM, true, false);
	        Coffee coffee2 = new Coffee("Americano", Size.MEDIUM, true, false);
	        Coffee coffee3 = new Coffee("Mocha", Size.SMALL, false, true);

	        // Test equality between two Coffee objects with the same properties
	        assertEquals(coffee1, coffee2);

	        // Test equality between two Coffee objects with different properties
	        assertNotEquals(coffee1, coffee3);
	    }
}