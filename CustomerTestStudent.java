import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: customer test class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
class CustomerTestStudent {
	@Test
    public void testConstructorWithNameAndAge() {
        // Arrange
        String name = "John Doe";
        int age = 30;

        // Act
        Customer customer = new Customer(name, age);

        // Assert
        assertEquals(name, customer.getName());
        assertEquals(age, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        // Arrange
        String name = "John Doe";
        int age = 30;
        Customer originalCustomer = new Customer(name, age);

        // Act
        Customer copiedCustomer = new Customer(originalCustomer);

        // Assert
        assertEquals(name, copiedCustomer.getName());
        assertEquals(age, copiedCustomer.getAge());
    }

}
