package cardSystem;

import java.util.ArrayList;
import java.util.Collections;

public class CardTest {

	 public static void main(String[] args) throws CloneNotSupportedException {

		 ArrayList<Card> reg = new ArrayList<Card>();

		 Card c1 = new Employee("Ole Olsen", "1234");
		 Card c2 = new Guest("Marit Olsen", "9999");
		 Card c3 = new Employee("Pål Hansen", "1234");
		 Card c4 = new Guest();
		 Card c5 = new Employee();
		 reg.add(c1);
		 reg.add(c2);
		 reg.add(c3);
		 reg.add(c4);
		 reg.add(c5);
		 for (int i=0; i<reg.size(); i++) {
		 Card card = (Card)reg.get(i);
		 System.out.print(card);
		 System.out.println("\nTest av kort: med kode 1234 er" + (card.checkPin("1234") ? " gyldig" : " ugyldig" ) );
		 System.out.println("\nTest av kort: med kode 9999 er" + (card.checkPin("9999") ? " gyldig" : " ugyldig" ) );
		 }
		 
		 Collections.sort(reg);
		 System.out.println(reg.toString());
		 
		 Card clonedCard = c1.clone();
		 System.out.println("\n" + clonedCard.toString() + " is a clone of: " + c1.toString());
		 }
		}
