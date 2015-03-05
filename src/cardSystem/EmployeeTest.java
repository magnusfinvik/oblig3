package cardSystem;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test_isItOfficeTime_1700_returnTrue_wrongPinCode() {
		Employee card = new Employee();
		card.setPinCode("1234");
		card.calendar.set(2015, 1, 27, 17, 00);
		assertTrue(card.isItOfficeTime());
	}
	
	@Test
	public void testIsItOfficeTime_1730_returnFalse_pinCodeShouldBeFalse(){
		Employee card = new Employee();
		card.setPinCode("1234");
		card.calendar.set(2015, 1, 27, 17, 30);
		assertFalse(card.isItOfficeTime());
	}
	
	@Test
	public void testIsItOfficeTime_1730_pinCodeCorrect_returnTrue(){
		Employee card = new Employee();
		card.calendar.set(2015, 1, 27, 17, 30);
		assertTrue(card.isItOfficeTime());
	}
	
	@Test
	public void testIsItOfficeTime_0700_returnTrue_wrongPinCode(){
		Employee card = new Employee();
		card.setPinCode("1234");
		card.calendar.set(2015, 1, 27, 07, 00);
		assertTrue(card.isItOfficeTime());
	}
	
	@Test
	public void testIsItOfficeTime_0659_returnFalse_wrongPinCode(){
		Employee card = new Employee();
		card.setPinCode("1234");
		card.calendar.set(2015, 1, 27, 06, 59);
		assertFalse(card.isItOfficeTime());
	}
	
	@Test
	public void testIsItWeekDay_notWeekDay_returnFalse(){
		Employee card = new Employee();
		card.setPinCode("notCorrect");
		card.calendar.set(2015, 1, 28, 10, 00);
		assertFalse(card.isItOfficeTime());
	}
	
	@Test
	public void testIsItWeekDay_returnTrue(){
		Employee card = new Employee();
		card.setPinCode("notCorrect");
		card.calendar.set(2015, 1, 26, 10, 00);
		assertTrue(card.isItOfficeTime());
	}
	
	@Test
	public void testCheckPin_9999_returnTrue() {
		Employee card = new Employee();
		assertTrue(card.checkPin("9999"));
	}
	@Test
	public void testCheckPin_1234_returnFalse(){
		Employee card = new Employee();
		assertFalse(card.checkPin("1234"));
	}
	@Test
	public void testCardSuspended_weekDay_officeHours_shouldBeSuspended_returnsFalse(){
		Employee card = new Employee();
		card.calendar.set(2015, 1, 26, 10, 00);
		card.setCardSuspended(true);
		assertFalse(card.accessGranted());
	}
	@Test
	public void testCardSuspended_notWeekDay_NotOfficeHours_shouldBeSuspended_returnsFalse(){
		Employee card = new Employee();
		card.calendar.set(2015, 1, 28, 05, 00);
		card.setCardSuspended(true);
		assertFalse(card.accessGranted());
	}
	
	@Test
	public void test_accessGranted_weekDay_officeHours_pinCorrect_notSuspended_returnsTrue(){
		Employee card = new Employee();
		card.calendar.set(2015, 1, 26, 10, 00);
		assertTrue(card.accessGranted());
	}
	@Test
	public void testAccessGranted_weekDay_officeHours_pinWrong_notSuspended_returnsTrue(){
		Employee card = new Employee();
		card.calendar.set(2015, 1, 26, 10, 00);
		card.setPinCode("notCorrect");
		assertTrue(card.accessGranted());
	}
	@Test
	public void testAccessGranted_weekDay_notOfficeHours_pinCorrect_notSuspended_returnsTrue(){
		Employee card = new Employee();
		card.calendar.set(2015, 1, 26, 05, 00);
		assertTrue(card.accessGranted());
	}
	@Test
	public void testAccessGranted_weekDay_notOfficeHours_pinWrong_notSuspended_returnsFalse(){
		Employee card = new Employee();
		card.calendar.set(2015, 1, 26, 05, 00);
		card.setPinCode("notCorrect");
		assertFalse(card.accessGranted());
	}
	@Test
	public void testAccessGranted_weekend_officeHours_pinWrong_returnsFalse(){
		Employee card = new Employee();
		card.calendar.set(2015, 1, 28, 10, 00);
		card.setPinCode("notCorrect");
		assertFalse(card.accessGranted());
	}
	
	@Test
	public void testAccessGranted_weekDay_officeHours_pinCorrect_suspended_returnsFalse(){
		Employee card = new Employee();
		card.calendar.set(2015, 1, 26, 10, 00);
		card.setCardSuspended(true);
		assertFalse(card.accessGranted());
	}
	
	@Test
	public void testSetFirstName_onlyOneFirstNameAndLastName(){
		Employee card = new Employee();
		card.setFirstName(card.getName());
		assertEquals("Magnus", card.getFirstName());
	}
	@Test
	public void testSetFirstName_threeNamesInTotal(){
		Employee card = new Employee("Harald Martin Haraldsen", "1234");
		card.setFirstName(card.getName());
		assertEquals("Harald Martin", card.getFirstName());
	}
	@Test
	public void testSetLastName_OnlyOneFirstAndLastName(){
		Employee card = new Employee();
		card.setLastName(card.getName());
		assertEquals("Finvik", card.getLastName());
	}
	@Test
	public void testSetLastName_threeNamesInTotal(){
		Employee card = new Employee("Harald Martin Haraldsen", "1234");
		card.setLastName(card.getName());
		assertEquals("Haraldsen", card.getLastName());
	}
	@Test
	public void testSetFullName_onlyOneFirstAndLastName(){
		Employee card = new Employee();
		card.setLastName(card.getName());
		card.setFirstName(card.getName());
		card.setFullName(card.getFirstName(), card.getLastName());
		assertEquals("Magnus Finvik", card.getFullName());
	}
	@Test
	public void testSetFullName_threeNamesInTotal(){
		Employee card = new Employee("Harald Martin Haraldsen", "1234");
		card.setLastName(card.getName());
		card.setFirstName(card.getName());
		card.setFullName(card.getFirstName(), card.getLastName());
		assertEquals("Harald Martin Haraldsen", card.getFullName());
	}

}
