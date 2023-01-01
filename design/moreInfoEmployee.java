package design;

public class moreInfoEmployee extends EmployeeInfo{

        private String position ;

        public moreInfoEmployee(){
            super();

        }


        public moreInfoEmployee(int employeeId) {
            super(employeeId);
        }

        public moreInfoEmployee(String name, int employeeId,String position) {
            super(name, employeeId);
            this.position=position;
        }

        public void printEmployeeInformation(){
            System.out.println("the id of employee "+super.getName()+" is "+super.getEmployeeId());
            System.out.println("his date of birth is "+super.getDateOfBirth()+"and his phone number is "+super.getPhoneNumber());
            System.out.println("he is working in "+super.getDepartment()+"  department with salary of "+super.getSalary()+"$ yealy"+"in position as "+getPosition());
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }

