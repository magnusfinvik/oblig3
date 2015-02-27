package cardSystem;

import java.util.Calendar;
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
		if(isCardSuspended()){
			return false;
		}
		if(isItOfficeHours(calendar) && isItWeekDay(calendar) == true){
			return true;
		}else{
			if(checkPin(pinCodeToCheck)){//fix this on a later stage
				return true;
			}else{
				return false;
			}
		}
		
	}
	
	private boolean isItOfficeHours(Calendar calendar) {
		int hourOfDay = calendar.get(calendar.HOUR_OF_DAY);
		int minuteOfHour = calendar.get(calendar.MINUTE);
		if(hourOfDay >= 7 && hourOfDay < 17)
			return true;
		else if(hourOfDay == 17 && minuteOfHour == 0){
			return true;
		}else{
			return false;
		}
	}
	private boolean isItWeekDay(Calendar calendar) {
		int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
		if(dayOfWeek >= 2 && dayOfWeek <= 6){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean checkPin(String pin) {
		boolean pinEqual = (pin.contentEquals(this.getPinCode()));
		return pinEqual;
	}
}