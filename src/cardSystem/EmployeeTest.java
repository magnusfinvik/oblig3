package cardSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test_isItOfficeTime() {
		Employee card = new Employee();
		System.out.println(card.calendar.HOUR);
		assertEquals(true, card.isItOfficeTime());
	}
	
	@Test
	public void test_checkPin_9999() {
		Employee card = new Employee();
		assertEquals(card.checkPin("9999"), true);
	}
	
	@Test
	public void test_accessGranted(){
		Employee card = new Employee();
		assertTrue(card.accessGranted());
	}

}
