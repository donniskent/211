
public class EmployeeMain {
	public static void main(String [] args) {
		EmployeeMain constructor = new EmployeeMain();
		constructor.go();
		
	}

	public void go() {
		PartTimeEmployee partTime1 = new PartTimeEmployee();
		partTime1.setHourlyRate(10.50);
		partTime1.setHourLimit(20);
		partTime1.addHours(3);
		System.out.println(partTime1.calculatePay());
		partTime1.addHours(17);
		System.out.println(partTime1.calculatePay());
		partTime1.addHours(3);
		System.out.println(partTime1.calculatePay());

		HourlyEmployee hourly1 = new HourlyEmployee();
		hourly1.setHourlyRate(21.25);
		hourly1.addHours(40);
		System.out.println("Hourly1 pay: " + hourly1.calculatePay());
		
		
		SalariedEmployee salary1 = new SalariedEmployee(); 
		salary1.setWeeklySalary(1250.75);
		System.out.println("Salary 1 weekly pay: " + salary1.calculatePay());

		
		 
	}
	


}
