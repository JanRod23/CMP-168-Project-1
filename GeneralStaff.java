
public class GeneralStaff extends Employee {
	private String duty;
	
	GeneralStaff(){
		super();
		duty = "";
	}
	
	GeneralStaff(String duty){
		super();
		this.duty = duty;
	}
	
	GeneralStaff(String deptName, String duty){
		super(deptName);
		this.duty = duty;
	}
	
	GeneralStaff(String name, int birthYear, String deptName, String duty){
		super(name, birthYear, deptName);
		this.duty = duty;
	}
	
	public String getDuty() {
		return duty;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof GeneralStaff) {
			GeneralStaff otherStaff = (GeneralStaff)o;
			if( super.equals(otherStaff) && this.duty.contentEquals(otherStaff.getDuty())) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String output = super.toString() + " ";
		output = output + String.format("GeneralStaff: Duty: %10s", duty);
		return output;
	}

}
