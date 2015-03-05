package cardSystem;

public interface Permanent {
	
	void setFirstName(String name);
	
	String getFirstName();
	
	void setLastName(String name);
	
	String getLastName();
	
	void setFullName(String firstName, String lastName);
	
	String getFullName();
	
	double calculateCredit();
	
	double calculateBonus();

}