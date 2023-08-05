import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: type enum test class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
class TypeTestStudent {

    @Test
    public void testEnumValues() {
        Type[] types = Type.values();
        assertEquals(3, types.length);

        assertEquals(Type.COFFEE, types[0]);
        assertEquals(Type.SMOOTHIE, types[1]);
        assertEquals(Type.ALCOHOL, types[2]);
    }

    @Test
    public void testEnumOrdinal() {
        assertEquals(0, Type.COFFEE.ordinal());
        assertEquals(1, Type.SMOOTHIE.ordinal());
        assertEquals(2, Type.ALCOHOL.ordinal());
    }

}
