package cardSystem;

import java.util.GregorianCalendar;

public class Employee extends Card{
	private String pinCodeToCheck = "9999";
	public GregorianCalendar calendar = new GregorianCalendar();
	
	public Employee(String name, String pin) {
		this.setName(name);
		this.setPinCode(pin);
		this.setCardSuspended(false);
	}
	public Employee() {
		
	}
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
		if(calendar.get(calendar.HOUR_OF_DAY) >= 7 && calendar.get(calendar.HOUR_OF_DAY) < 17){
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
		//when running tests for this, it prints out the number 11 to console
	}
}