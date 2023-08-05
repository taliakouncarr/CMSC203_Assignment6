import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: day enum test class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
class DayTestStudent {

	@Test
	public void testEnumValues() {
		Day[] days = Day.values();
		assertEquals(7, days.length);

		assertEquals(Day.MONDAY, days[0]);
		assertEquals(Day.TUESDAY, days[1]);
		assertEquals(Day.WEDNESDAY, days[2]);
		assertEquals(Day.THURSDAY, days[3]);
		assertEquals(Day.FRIDAY, days[4]);
		assertEquals(Day.SATURDAY, days[5]);
		assertEquals(Day.SUNDAY, days[6]);
	}

	@Test
	public void testEnumOrdinal() {
		assertEquals(0, Day.MONDAY.ordinal());
		assertEquals(1, Day.TUESDAY.ordinal());
		assertEquals(2, Day.WEDNESDAY.ordinal());
		assertEquals(3, Day.THURSDAY.ordinal());
		assertEquals(4, Day.FRIDAY.ordinal());
		assertEquals(5, Day.SATURDAY.ordinal());
		assertEquals(6, Day.SUNDAY.ordinal());
	}

}
