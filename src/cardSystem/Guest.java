package cardSystem;

import java.util.GregorianCalendar;

public class Guest extends Card{
	public GregorianCalendar calendar = new GregorianCalendar();
	public GregorianCalendar expires = new GregorianCalendar();
	public Guest(){
		expires.add(calendar.DAY_OF_YEAR, 7);
		this.setCardSuspended(false);
	}
	
	public boolean accessGranted(){
		if(calendar.getTime().after(expires.getTime())){
			setCardSuspended(true);
			return false;
		}else{
		return true;
		}
		
	}

	@Override
	public boolean checkPin(String pin) {
		boolean isPinCorrect = pin.contentEquals(getPinCode());
		return isPinCorrect;
	}


}
