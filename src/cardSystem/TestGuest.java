package cardSystem;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class TestGuest {

	@Test
	public void test_accessGranted_notExpired() {
		Guest card = new Guest();
		assertTrue(card.accessGranted());	
	}
	
	@Test
	public void test_accessGranted_expiredAtYearEnd(){
		Guest card = new Guest();
		card.calendar.set(2015, 11, 28);
		card.calendar.add(card.calendar.DAY_OF_YEAR, 8);
		assertEquals(false, card.accessGranted());
	}
	
	@Test
	public void test_accessGranted_expiredAtActualTodayDate(){
		Guest card = new Guest();
		card.calendar.add(card.calendar.DAY_OF_YEAR, 8);
		assertEquals(false, card.accessGranted());
	}

}
