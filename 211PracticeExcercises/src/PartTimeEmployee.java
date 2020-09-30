
public class PartTimeEmployee extends HourlyEmployee {
	private int hourLimit;
	
	public void setHourLimit(int hourLimit) {
		this.hourLimit = hourLimit; 
	}
	public void addHours(int hours) {
		
		if (super.getHours() + hours <= hourLimit) {
		 super.addHours(hours);
			
		
		
		}
		else {
			System.out.println("Too many hours worked");
		}
	
	
	
	
	
	}



}
