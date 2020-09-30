
public class HourlyEmployee extends Employee{
private double hourlyRate;

	public double calculatePay() {
		return super.getHours() * hourlyRate; 
		
	
	
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate; 
	}
	
	
	
}
