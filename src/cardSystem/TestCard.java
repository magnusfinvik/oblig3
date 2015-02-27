package cardSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCard {

	@Test
	public void test_GetName() {
		Card card = new Employee();
		assertTrue(card.getName() == "Magnus Finvik");
	}
	
	@Test
	public void test_toString() {
		Card card = new Employee();
		String temp = card.toString();
		assertTrue(temp.contains("9999 false"));
	}
	@Test
	public void testCardNumber(){
		ArrayList<Card> list = new ArrayList<Card>();
		list.add(new Employee());
		list.add(new Guest());
		list.get(1);
		assertEquals(101, list.get(0).getCardNumber());
	}
	

}