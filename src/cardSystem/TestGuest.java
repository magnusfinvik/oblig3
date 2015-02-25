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
	public void test_accessGranted_expired(){
		Guest card = new Guest();
		card.calendar.add(Calendar.DAY_OF_YEAR, 8);
		assertEquals(false, card.accessGranted());
	}

}
