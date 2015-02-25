package cardSystem;

public abstract class Card {
	private String name;
	private String pinCode;
	private int cardNumber;
	private boolean cardSuspended;
	private static int currentCardNumber = 100;
	
	public Card(String name, String pinCode){
		this.name = name;
		this.pinCode = pinCode;
		this.cardNumber = currentCardNumber+1;
		currentCardNumber++;
		this.cardSuspended = false;
	}
	
	public Card(){
		this.name = "Magnus Finvik";
		this.pinCode = "9999";
		this.cardSuspended = false;
		this.cardNumber = currentCardNumber+1;
		currentCardNumber++;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isCardSuspended(){
		return cardSuspended;
	}
	
	public String toString(){
		String output = name + " " + cardNumber + " "
					+ pinCode + " " + isCardSuspended();
		return output;
	}
	
	public String getPinCode(){
		return this.pinCode;
	}
	
	public abstract boolean checkPin(String pin);

}
