
public class Faculty extends Employee {
	private Course[] coursesTaught;
	private int numCoursesTaught;
	private boolean isTenured;
	
	Faculty(){
		super();
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		isTenured = false;
	}
	
	Faculty(boolean isTenured){
		super();
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	Faculty(String deptName, boolean isTenured){
		super(deptName);
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	Faculty(String name, int birthYear, String deptName, boolean isTenured){
		super(name, birthYear, deptName);
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	
	public boolean isTenured() {
		return this.isTenured;
	}
	
	public int getNumCoursesTaught() {
		return numCoursesTaught;
	}
	
	public void setIsTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	
	public void addCourseTaught(Course course) {
		if(numCoursesTaught < 100) {
			coursesTaught[numCoursesTaught] = course;
			numCoursesTaught +=1;
		}
		
	}
	
	public void addCoursesTaught(Course [] course) {
		for (int i = 0; i < course.length; i++) {
			coursesTaught[numCoursesTaught] = course[i];
			numCoursesTaught +=1;
		}
	}
	
	public Course getCourseTaught(int index) {
		if ((index < 0) || (index > numCoursesTaught - 1)) {
			return null;
		}
		return coursesTaught[index];
	}
	
	public String getCourseTaughtAsString(int index) {
		if ((index < 0) || (index > numCoursesTaught - 1)) {
			return "";
		}
		return coursesTaught[index].getCourseDept() + "-"  + coursesTaught[index].getCourseNum();
	}
	
	public String getAllCoursesTaughtAsString() {
		String output = "";
		for (int i = 0; i < numCoursesTaught; i++) {
			output = output + getCourseTaughtAsString(i) + ", ";
		}
		return output;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Faculty) {
			Faculty otherFaculty = (Faculty)obj;
			if(  ( this.getDeptName().contentEquals(otherFaculty.getDeptName()) )   
				&&  (  this.getEmployeeID() == otherFaculty.getEmployeeID()  )
				&&  (  this.getAllCoursesTaughtAsString().contentEquals(otherFaculty.getAllCoursesTaughtAsString()))  
				&&  (  this.getNumCoursesTaught() == otherFaculty.getNumCoursesTaught()  )
				&&  (  this.isTenured() == otherFaculty.isTenured()  )) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String tenuredString = "";
		if(isTenured) {
			tenuredString = "Is Tenured";
		}
		else {
			tenuredString = "Not Tenured";
		}
		String output = String.format("%s Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s", super.toString(), tenuredString, numCoursesTaught, getAllCoursesTaughtAsString());
		return output;

	}
	
	@Override
	public int compareTo(Person p) {
		if(p instanceof Faculty) {
			Faculty otherFaculty = (Faculty)p;
			if(this.getNumCoursesTaught() > otherFaculty.getNumCoursesTaught()) {
				return 1;
			}
			if(this.getNumCoursesTaught() < otherFaculty.getNumCoursesTaught()) {
				return -1;
			}
		}
		else {
			 return super.compareTo(p);
		}
		return 0;
	}

}
