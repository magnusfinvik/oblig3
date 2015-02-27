package cardSystem;

public abstract class Card {
	private String name;
	private String pinCode;
	private int cardNumber;
	private boolean cardSuspended;
	private static int currentCardNumber = 100;
	
	public Card(String name, String pinCode){
		this.setName(name);
		this.setPinCode(pinCode);
		this.cardNumber = currentCardNumber+1;
		currentCardNumber++;
		this.setCardSuspended(false);
	}
	
	public Card(){
		this.setName("Magnus Finvik");
		this.setPinCode("9999");
		this.setCardSuspended(false);
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
		String output = getName() + " " + cardNumber + " "
					+ getPinCode() + " " + isCardSuspended();
		return output;
	}
	
	public String getPinCode(){
		return this.pinCode;
	}
	
	public abstract boolean checkPin(String pin);

	public void setCardSuspended(boolean cardSuspended) {
		this.cardSuspended = cardSuspended;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public int getCardNumber() {
		return cardNumber;
	}

}
