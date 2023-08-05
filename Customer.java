import java.util.Objects;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: customer class
 * Due: 8/7/23
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: talia
*/
public class Customer {

	// instance variables
	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Customer(Customer c) {
		this.name = c.name;
		this.age = c.age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

}
