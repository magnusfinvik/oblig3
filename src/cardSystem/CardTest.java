package cardSystem;

import java.util.ArrayList;

public class CardTest {

	 public static void main(String[] args) {

		 ArrayList<Card> reg = new ArrayList<Card>();

		 Card c1 = new Employee("Ole Olsen", "1234");
		 Card c2 = new Guest("Marit Olsen", "9999");
		 reg.add(c1);
		 reg.add(c2);
		 for (int i=0; i<reg.size(); i++) {
		 Card card = (Card)reg.get(i);
		 System.out.print(card);
		 System.out.println("\nTest av kort: med kode 1234 er" + (card.checkPin("1234") ? " gyldig" : " ugyldig" ) );
		 System.out.println("\nTest av kort: med kode 9999 er" + (card.checkPin("9999") ? " gyldig" : " ugyldig" ) );
		 }
		 }
		}
