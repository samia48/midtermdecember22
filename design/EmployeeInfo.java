package design;

import java.util.Scanner;

public class EmployeeInfo implements Employee {
	
 /*This class can be implemented from Employee interface then add additional methods in EmployeeInfo class.
 * Also, Employee interface can be implemented into an abstract class.So create an Abstract class
 * then inherit that abstract class into EmployeeInfo class.Once you are done with designing EmployeeInfo class,
 * go to FortuneEmployee class to apply all the fields and attributes.
 * 
 * Important: YOU MUST USE the 
 * OOP(abstraction,Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
 * Use all kind of keywords(super,this,static,final........)
 * Implement Nested class.
 * Use Exception Handling.
 *
 */

	/*
	 * declare few static and final fields and some non-static fields
	 */
	static String companyName;

	private int employeeId;
	private String name ;
	private String  dateOfBirth;
	private String ssn;
	private String phoneNumber;
	private double salary;
	private String department;
	/*
	 * You must implement the logic for below 2 methods and 
	 * following 2 methods are prototype as well for other methods need to be design,
	 * as you will come up with the new ideas.
	 */
	
	/*
	 * you must have multiple constructor.
	 * Must implement below constructor.
	 */
	public EmployeeInfo(int employeeId){
		this.employeeId=employeeId;


	}
	public EmployeeInfo(String name, int employeeId){
		this.name=name;
		this.employeeId=employeeId;

	}
	public EmployeeInfo(){

	}

	/*
	 * This methods should calculate Employee bonus based on salary and performance.
	 * Then it will return the total yearly bonus. So you need to implement the logic.
	 * Hints: 10% of the salary for best performance, 8% of the salary for average performance and so on.
	 * You can set arbitrary number for performance.
	 * So you probably need to send 2 arguments.
	 *
	 */
	public static int calculateEmployeeBonus(int performance,double salary){
		int total=0;
		if(performance==1){
			total= (int) (salary*0.1);
		}else if (performance==2){
			total= (int) (salary*0.08);
		}else if (performance==3){
			total= (int) (salary*0.02);
		}
		return total;
	}
	/*
	 * This methods should calculate Employee Pension based on salary and numbers of years with the company.
	 * Then it will return the total pension. So you need to implement the logic.
	 * Hints: pension will be 5% of the salary for 1 year, 10% for 2 years with the company and so on.
	 *
	 */
	public static int calculateEmployeePension(double salary ){
		int total=0;
		Scanner sc  = new Scanner(System.in);
		System.out.println("Please enter start date in format (example: May,2015): ");
		String joiningDate = sc.nextLine();
		System.out.println("Please enter today's date in format (example: August,2017): ");
		String todaysDate = sc.nextLine();
		String convertedJoiningDate = DateConversion.convertDate(joiningDate);
		String convertedTodaysDate = DateConversion.convertDate(todaysDate);

		//implement numbers of year from above two dates
		String StartYear=convertedJoiningDate.substring(convertedJoiningDate.indexOf("/")+1);
		String endYear=convertedTodaysDate.substring(convertedJoiningDate.indexOf("/")+1);
		int yearWithCompany = Integer.parseInt(endYear)-Integer.parseInt(StartYear);

		//Calculate pension
		if(yearWithCompany<2){
			total= (int) (salary*0.05);
		}else if(yearWithCompany==2){
			total= (int) (salary*0.1);
		}if(yearWithCompany>3 &&yearWithCompany<=5 ){
			total= (int) (salary*0.15);
		}if(yearWithCompany>5 ){
			total= (int) (salary*0.2);
		}

		return total;
	}



	@Override
	public int employeeId() {
		return getEmployeeId();
	}

	@Override
	public String employeeName() {
		return getName();
	}



	@Override
	public void assignDepartment() {
		System.out.println("you will be assigned to a"+getDepartment()+" department");
	}

	@Override
	public int calculateSalary() {
		return (int) getSalary();
	}

	@Override
	public void benefitLayout() {
		System.out.println("if you are a full time worked , you are eligible for all benefits");

	}

	private static class DateConversion {

		public DateConversion(Months months){}
		public static String convertDate(String date) {
			String [] extractMonth = date.split(",");
			String givenMonth = extractMonth[0];
			int monthDate = whichMonth(givenMonth);
			String actualDate = monthDate + "/" + extractMonth[1];
			return actualDate;
		}

		public static int whichMonth(String givenMonth) {
			Months months = Months.valueOf(givenMonth);
			int date = 0;
			switch (months) {
				case January:
					date = 1;
					break;
				case February:
					date = 2;
					break;
				case March:
					date = 3;
					break;
				case April:
					date = 4;
					break;
				case May:
					date = 5;
					break;
				case June:
					date = 6;
					break;
				case July:
					date = 1;
					break;
				case August:
					date = 1;
					break;
				case September:
					date = 1;
					break;
				case October:
					date = 1;
					break;
				case November:
					date = 1;
					break;
				case December:
					date = 1;
					break;
				default:
					date = 0;
					break;
			}
			return date;

		}
	}



	public static void setCompanyName(String companyName) {
		EmployeeInfo.companyName = companyName;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateOfBirth(String  dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static String getCompanyName() {
		return companyName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public String  getDateOfBirth() {
		return dateOfBirth;
	}

	public String getSsn() {
		return ssn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}