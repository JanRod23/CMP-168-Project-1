
public class Student extends Person {
	private static int numStudents = 0;
	private int studentID;
	private Course[] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major;
	
	Student(){
		super();
		numStudents += 1;
		studentID = numStudents;
		coursesTaken = new Course[100];
		numCoursesTaken = 0;
		isGraduate = false;
		major = "undeclared";
	}
	
	Student(boolean isGraduate){
		super();
		numStudents += 1;
		studentID = numStudents;
		coursesTaken = new Course[100];
		numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		major = "undeclared";
	}
	
	Student(String major, boolean isGraduate){
		super();
		numStudents += 1;
		studentID = numStudents;
		coursesTaken = new Course[100];
		numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
	}
	
	Student(String name, int birthYear, String major, boolean isGraduate){
		super(name, birthYear);
		numStudents += 1;
		studentID = numStudents;
		coursesTaken = new Course[100];
		numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
	}
	
	public boolean isGraduate() {
		return isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setIsGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void addCourseTaken(Course course) {
		coursesTaken[numCoursesTaken] = course;
		numCoursesTaken += 1;
	}

	public void addCoursesTaken(Course [] course) {
		int count = 0;
		for(int i = numCoursesTaken; i < course.length; i++) {
			coursesTaken[i] = course[count];
			count += 1;
			numCoursesTaken +=1;
		}
	}
	
	public Course getCourseTaken(int index) {
		if( (index < 0) || (index >= numCoursesTaken) ) {
			return null;
		}
		return coursesTaken[index];
	}
	
	public String getCourseTakenAsString(int index) {
		if( (index < 0) || (index >= numCoursesTaken) ) {
			return "";
		}
		String output = "" + coursesTaken[index].getCourseDept() + "-" + coursesTaken[index].getCourseNum();
		return output;
		
	}
	
	public String getAllCoursesTakenAsString() {
		String output = "";
		for(int i = 0; i < numCoursesTaken; i++) {
			if(i == 0) {
				output = getCourseTakenAsString(i);
			}
			else {
				output = output + ", " +  getCourseTakenAsString(i);
			}
		}
		return output;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Student) {
			Student otherStudent = (Student)o;
			if(super.equals(otherStudent) && (this.getNumStudents() == otherStudent.getNumStudents())
				&& (studentID == otherStudent.getStudentID()) 
				&& (this.getAllCoursesTakenAsString().contentEquals(otherStudent.getAllCoursesTakenAsString())) 
				&& (numCoursesTaken == otherStudent.getNumCoursesTaken()) 
				&& (isGraduate == otherStudent.isGraduate) 
				&& (major.contentEquals(otherStudent.getMajor())) ) {
				   
					return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String graduateStatus = "";
		if (isGraduate) {
			graduateStatus = "Graduate";
		}
		else {
			graduateStatus = "Undergraduate";
		}
		String output = super.toString() + " ";
		output = output + String.format("Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, graduateStatus, numCoursesTaken, getAllCoursesTakenAsString());
		return output;
	}
	
	@Override
	public int compareTo(Person p) {
		if(p instanceof Student) {
			Student otherStudent = (Student)p;
			if(numCoursesTaken > otherStudent.getNumCoursesTaken()) {
				return 1;
			}
			if(numCoursesTaken < otherStudent.getNumCoursesTaken()) {
				return -1;
			}
			
		}
		else {
			return super.compareTo(p);
		}
		return 0;
	}

}
