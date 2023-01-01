package design;
import java.util.Date;
public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create Object from
	 * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible 
	 * to use with proper business work flow.Think as a Software Architect, Product Designer and 
	 * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
	 * more to design an application that will meet for fortune 500 Employee Information
	 * Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/
			public static void main(String[] args) {
			moreInfoEmployee employee1=new moreInfoEmployee("john",005,"manager");


			employee1.setDateOfBirth("(02/05/1989)");
			employee1.setSsn("456-48-4789");
			employee1.setSalary(110000);
			employee1.setPhoneNumber("347-463-4785");
			employee1.setDepartment("IT");
			employee1.printEmployeeInformation();







		}


	}


