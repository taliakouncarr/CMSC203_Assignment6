import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Alcohol test class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
class AlcoholTestStudent {
	   @Test
	    public void testCalcPrice() {
	        Alcohol alcohol1 = new Alcohol("Wine", Size.MEDIUM, true);
	        Alcohol alcohol2 = new Alcohol("Beer", Size.LARGE, false);

	        // Test price calculation for a medium-sized alcohol on a weekend
	        assertEquals(3.6, alcohol1.calcPrice(), 0.001);

	        // Test price calculation for a large-sized alcohol on a weekday
	        
	        assertEquals(4, alcohol2.calcPrice(), 0.001);
	    }

	    @Test
	    public void testToString() {
	        Alcohol alcohol = new Alcohol("Vodka", Size.SMALL, false);
	        String expectedString = "Vodka,SMALL,false," + alcohol.calcPrice();
	        assertEquals(expectedString, alcohol.toString());
	    }

	    @Test
	    public void testEquals() {
	        Alcohol alcohol1 = new Alcohol("Whiskey", Size.LARGE, false);
	        Alcohol alcohol2 = new Alcohol("Whiskey", Size.LARGE, false);
	        Alcohol alcohol3 = new Alcohol("Vodka", Size.MEDIUM, true);

	        // Test equality between two Alcohol objects with the same properties
	        assertEquals(alcohol1, alcohol2);

	        // Test equality between two Alcohol objects with different properties
	        assertNotEquals(alcohol1, alcohol3);
	    }
	}


