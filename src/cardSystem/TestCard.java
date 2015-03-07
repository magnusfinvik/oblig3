package cardSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestCard{

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
	@Test
	public void testCardClone_notSame() {
		Card card = new Employee("Pål Hansen", "pin");
		Card card2 = new Employee("Linda Olsen", "123");
		Card clonedCard = card.clone();
		assertNotSame(card2, clonedCard);
	}
	@Test
	public void testCardClone_sameInfo(){
		Card card = new Employee("Pål Hansen", "pin");
		Card card2 = new Employee("Pål Hansen", "pin");
		Card clonedCard = card.clone();
		assertEquals(card2, clonedCard);
	}
	
	

}