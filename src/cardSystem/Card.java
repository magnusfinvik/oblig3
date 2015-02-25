package cardSystem;

public abstract class Card {
	private String firstName;
	private String lastName;
	private String pinCode;
	private int cardNumber;
	private boolean cardOpen;
	private static int currentCardNumber = 100;
	
	public Card(String firstName, String lastName, String pinCode){
		this.firstName = firstName;
		this.lastName = lastName;
		this.pinCode = pinCode;
		this.cardNumber = currentCardNumber+1;
		currentCardNumber++;
		this.cardOpen = true;
	}
	
	public String getName(){
		String name = firstName + " " + lastName;
		return name;
	}
	
	public boolean isCardSuspended(){
		return cardOpen;
	}
	
	public String toString(){
		String output = firstName + " " + lastName + " " + cardNumber + " "
					+ pinCode + " " + isCardSuspended();
		return output;
	}
	
	public abstract boolean checkPin(int pin);

}
