
public class Employee extends Person {
	private String deptName;
	private static int numEmployees = 0;
	private int employeeID = 0;
	
	Employee(){
		super();
		deptName = "";
		numEmployees ++;
		employeeID = numEmployees;
	}
	
	Employee(String deptName){
		super();
		this.deptName = deptName;
		numEmployees ++;
		employeeID = numEmployees;
	}
	
	Employee(String name, int birthYear, String deptName){
		super(name, birthYear);
		this.deptName = deptName;
		numEmployees ++;
		employeeID = numEmployees;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public static int getNumEmployees() {
		return numEmployees;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setDeptName(String newDeptName) {
		deptName = newDeptName;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Employee) {
			Employee otherEmployee = (Employee)o;
			if( (this.getName().contentEquals(otherEmployee.getName()) ) 
			    && (this.getBirthYear() == otherEmployee.getBirthYear())
			    && (this.getDeptName().contentEquals(otherEmployee.getDeptName()))
			    && (this.getEmployeeID() == otherEmployee.getEmployeeID())) {
				
				return true;			
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String personInfo = super.toString();
		return String.format("%s Employee: Department: %20s | Employee Number: %3d", personInfo, deptName, employeeID);
	}
	
	@Override
	public int compareTo(Person p) {
		if(p instanceof Employee) {
			Employee otherEmployee = (Employee)p;
			if(this.getEmployeeID() > otherEmployee.getEmployeeID()) {
				return 1;
			}
			if(this.getEmployeeID() < otherEmployee.getEmployeeID()) {
				return -1;
			}
		}
		else {
		    return super.compareTo(p);
		}
		return 0;
	}


}
