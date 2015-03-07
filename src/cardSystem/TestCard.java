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
		Card card = new Employee();
		Card card2 = new Employee();
		assertNotEquals(card2.getCardNumber(), card.getCardNumber());
	}
	@Test
	public void testCardClone_notSame() throws CloneNotSupportedException {
		Card card = new Employee("Pål Hansen", "pin");
		Card card2 = new Employee("Linda Olsen", "123");
		Card clonedCard = card.clone();
		assertNotSame(card2, clonedCard);
	}
	@Test
	public void testCardClone_sameInfo() throws CloneNotSupportedException{
		Card card = new Employee("Pål Hansen", "pin");
		Card card2 = new Employee("Pål Hansen", "pin");
		Card clonedCard = card.clone();
		assertEquals(card.getName(), clonedCard.getName());
		assertEquals(card.getPinCode(),clonedCard.getPinCode());
		assertEquals(card.isCardSuspended(), clonedCard.isCardSuspended());
		
	}
	@Test
	public void testCardClone_sameName() throws CloneNotSupportedException{
		Card card = new Employee("Pål Hansen", "pin");
		Card card2 = new Employee();
		Card clonedCard = card.clone();
		assertEquals(clonedCard.getName(), card.getName());
	}
	
	

}