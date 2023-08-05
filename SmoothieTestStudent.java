import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: smoothie test class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
class SmoothieTestStudent {

	 @Test
	    public void testCalcPrice() {
	        Smoothie smoothie1 = new Smoothie("Berry Blast", Size.SMALL, 3, true);
	        Smoothie smoothie2 = new Smoothie("Mango Tango", Size.MEDIUM, 5, false);

	        // Test price calculation for a small smoothie with 3 fruits and protein added
	        assertEquals(5, smoothie1.calcPrice(), 0.001);

	        // Test price calculation for a medium-sized smoothie with 5 fruits and no protein added
	        assertEquals(5.5, smoothie2.calcPrice(), 0.001);
	    }

	    @Test
	    public void testToString() {
	        Smoothie smoothie = new Smoothie("Green Detox", Size.LARGE, 2, true);
	        String expectedString = "Green Detox,LARGE,true,2," + smoothie.calcPrice();
	        assertEquals(expectedString, smoothie.toString());
	    }

	    @Test
	    public void testEquals() {
	        Smoothie smoothie1 = new Smoothie("Tropical Paradise", Size.MEDIUM, 4, false);
	        Smoothie smoothie2 = new Smoothie("Tropical Paradise", Size.MEDIUM, 4, false);
	        Smoothie smoothie3 = new Smoothie("Mixed Berry", Size.LARGE, 3, true);

	        // Test equality between two Smoothie objects with the same properties
	        assertEquals(smoothie1, smoothie2);

	        // Test equality between two Smoothie objects with different properties
	        assertNotEquals(smoothie1, smoothie3);
	    }
}
