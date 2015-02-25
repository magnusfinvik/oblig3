package cardSystem;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test_isItOfficeTime() {
		Employee card = new Employee();
		assertEquals(true, card.isItOfficeTime());
	}
	
	@Test
	public void test_isItOfficeTime_HOUR_20(){
		Employee card = new Employee();
		card.setPinCode("1234");
		card.calendar.set(Calendar.HOUR_OF_DAY, 20);
		assertEquals(false, card.isItOfficeTime());
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
