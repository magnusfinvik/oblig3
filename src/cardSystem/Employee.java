package cardSystem;

import java.util.GregorianCalendar;

public class Employee extends Card{
	private String pinCodeToCheck = "9999";
	public GregorianCalendar calendar = new GregorianCalendar();
	
	public boolean accessGranted(){
		boolean officeTime = isItOfficeTime();
		if(officeTime){
			if(isCardSuspended() == false){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	public boolean isItOfficeTime(){
		if(calendar.HOUR >= 12 && calendar.HOUR <= 17){
			return true;
		}else{
			if(checkPin(pinCodeToCheck)){
				return true;
			}else{
				return false;
			}
		}
		
	}
	
	@Override
	public boolean checkPin(String pin) {
		boolean pinEqual = (pin.contentEquals(this.getPinCode()));
		return pinEqual;
	}
}