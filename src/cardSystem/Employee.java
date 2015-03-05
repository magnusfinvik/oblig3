package cardSystem;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Employee extends Card implements Permanent{
	private String pinCodeToCheck = "9999";
	public GregorianCalendar calendar = new GregorianCalendar();
	public String firstName;
	public String lastName;
	private double creditConstant;
	private double wage;
	private int bonusConstant;
	private int seniority;
	
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
	@Override
	public void setFirstName(String name) {
		final Pattern SPACE = Pattern.compile(" ");
		String[] arr = SPACE.split(name);
		this.firstName = arr[0];
			for(int i = 1; i < arr.length-1; i++){
				this.firstName = this.firstName + " " + arr[i];
			}
	}
	@Override
	public String getFirstName() {
		return this.firstName;
	}
	@Override
	public void setLastName(String name) {
		final Pattern SPACE = Pattern.compile(" ");
		String[] arr = SPACE.split(name);
		this.lastName = arr[arr.length-1];
		
	}
	@Override
	public String getLastName() {
		return this.lastName;
	}
	@Override
	public void setFullName(String firstName, String lastName) {
		this.setName(firstName + " " + lastName);
	}
	@Override
	public String getFullName() {
		return this.getName();
	}
	@Override
	public double calculateCredit() {
		double credit = creditConstant*wage;
		return credit;
	}
	@Override
	public double calculateBonus() {
		double bonus = bonusConstant*seniority;
		return bonus;
	}
}