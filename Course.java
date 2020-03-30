
public class Course implements Comparable<Course>{
	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;
	
	Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits){
		this.isGraduateCourse = isGraduateCourse;
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
	}
	
	public boolean isGraduateCourse() {
		return isGraduateCourse;
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public String getCourseDept() {
		return courseDept;
	}
	
	public int getNumCredits() {
		return numCredits;
	}
	
	public String getCourseName() {
		String isItGraduate = "";
		if(isGraduateCourse) {
			isItGraduate = "G";
		}
		else {
			isItGraduate = "U";
		}
		return isItGraduate + courseDept + courseNum;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Course) {
			Course otherCourse = (Course) o;
			if(  (this.isGraduateCourse == otherCourse.isGraduateCourse()  )
				&&  (  this.courseNum == otherCourse.getCourseNum()  )
				&&  (  this.courseDept.contentEquals(otherCourse.getCourseDept())  )
				&&  (  this.numCredits == otherCourse.getNumCredits()  )) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String isGraduate = "";
		if(isGraduateCourse) {
			isGraduate = "Graduate";
		}
		else {
			isGraduate = "Undergraduate";
		}
		return String.format("Course: %3s-%3d | Number of Credits: %02d | %s", courseDept, courseNum, numCredits, isGraduate);
	}
	
	@Override
	public int compareTo(Course c) {
		if(this.courseNum > c.getCourseNum()) {
			return 1;
		}
		else if(this.courseNum < c.getCourseNum()) {
			return -1;
		}
		return 0;
	}


}
