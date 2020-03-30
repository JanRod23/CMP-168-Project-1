import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;



public class Driver_SchoolDB {

	public static void main(String[] args) throws IOException {
		FileInputStream textFile = null;
		Scanner scan = null;
		String output = "";
		
		Course [] course = new Course[20];
		int numCourse = 0;
		Person [] person = new Person[20];
		int numPerson = 0;
		Employee [] employee = new Employee[20];
		int numEmployee = 0;
		Faculty [] faculty = new Faculty[20];
		int numFaculty = 0;
		GeneralStaff [] generalStaff = new GeneralStaff[20];
		int numGeneralStaff = 0;
		Student [] student = new Student[20];
		int numStudent = 0;
		
		try {
			textFile = new FileInputStream("SchoolDB_Initial.txt");
			scan = new Scanner(textFile);
			
			while(scan.hasNext()) {
				output = scan.nextLine();
				System.out.println(output);
				String objectName = extractObjectType(output);
				String parametersUnfixed = deleteObjectName(output);
				
				if(objectName.contentEquals("COURSE") ) {
					numCourse = courseMaker(parametersUnfixed, course, numCourse);
				}
				if(objectName.contentEquals("PERSON") ) {
					numPerson = personMaker(parametersUnfixed, person, numPerson);
				}
				if(objectName.contentEquals("EMPLOYEE") ) {
					numEmployee = employeeMaker(parametersUnfixed, employee, numEmployee);
				}
				if(objectName.contentEquals("FACULTY") ) {
					numFaculty = facultyMaker(parametersUnfixed, faculty, numFaculty);
				}
				if(objectName.contentEquals("GENERALSTAFF") ) {
					numGeneralStaff = generalStaffMaker(parametersUnfixed, generalStaff, numGeneralStaff);
				}
				if(objectName.contentEquals("STUDENT") ) {
					numStudent = studentMaker(parametersUnfixed, student, numStudent);
				}
				
				
			}
		}
		catch(IOException excpt){
			System.out.println("Could not find the file");
		}
		finally {
			System.out.println();
			System.out.println("**************************************************************");
			System.out.println("SCHOOL DATABASE INFO:");
			System.out.println();
			System.out.println("************************************************");
			System.out.println("COURSES:");
			
			for(int i = 0; i < numCourse; i++) {
				System.out.println(course[i].toString());
			}
			
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("PERSONS:");
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("EMPLOYEES:");
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("GENERAL STAFF:");
			
			for(int i = 0; i < numGeneralStaff; i++) {
				System.out.println(generalStaff[i].toString());
			}
			
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("FACULTY:");
			
			for(int i = 0; i < numFaculty; i++) {
				System.out.println(faculty[i].toString());
			}
			
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("STUDENTS:");
			
			for(int i = 0; i < numStudent; i++) {
				System.out.println(student[i].toString());
			}
			
			System.out.println("************************************************");
			System.out.println("**************************************************************");
			System.out.println();

		}
		
		boolean menuPrompt = true;
		Scanner menuScan = new Scanner(System.in);
		String menuInput = "";
		
		while(menuPrompt) {
			System.out.println("Welcome! Enter the following number for corresponding option:");
			System.out.println("1) To create a fresh new object");
			System.out.println("2) To add a course(s) to existing object and more");
			System.out.println("3) To PRINT all existing objects to CONSOLE");
			System.out.println("4) To EXPORT all objects to a TEXT FILE");
			menuInput = menuScan.nextLine().toUpperCase();
			
			if(menuInput.contentEquals("1")) {
				System.out.println("Select what kind of object you want to make.");
				System.out.println("C for Course, F for Faculty, G for GeneralStaff, S for Student");
				menuInput = menuScan.nextLine().toUpperCase();
			
				if(menuInput.contentEquals("C")) {
					menuInput = "";
					System.out.println("Please enter these 4 parameters seperated by a comma");
					System.out.println("is Graduate T/F || Course Number || Course Department || # of Credits");
					menuInput = menuScan.nextLine();
					numCourse = courseMaker(menuInput, course, numCourse);
					System.out.println(course[numCourse - 1].toString());
				}
				if(menuInput.contentEquals("F")) {
					menuInput = "";
					System.out.println("To create a Faculty object you can enter either 0, 1, 2 or 4 Parameters");
					System.out.println("Seperate parameters using a comma, Here is the format:");
					System.out.println("0: Leave everything blank and hit enter");
					System.out.println("1: is Tenured? T/F");
					System.out.println("2: Department Name || is Tenured? T/F");
					System.out.println("4: Name || Birth Year || Dept Name || Is Tenured? T/F");
					menuInput = menuScan.nextLine();
					numFaculty = facultyMaker(menuInput, faculty, numFaculty);
					System.out.println(faculty[numFaculty - 1].toString());
				}
				if(menuInput.contentEquals("G")) {
					menuInput = "";
					System.out.println("To create a GeneralStaff object you can enter either 0, 1, 2 or 4 Parameters");
					System.out.println("Seperate parameters using a comma, Here is the format:");
					System.out.println("0: Leave everything blank and hit enter");
					System.out.println("1: Duty");
					System.out.println("2: Department Name || Duty");
					System.out.println("4: Name || Birth Year || Dept Name || Duty");
					menuInput = menuScan.nextLine();
					numGeneralStaff = generalStaffMaker(menuInput, generalStaff, numGeneralStaff);
					System.out.println(generalStaff[numGeneralStaff - 1].toString());
					
				}
				if(menuInput.contentEquals("S")) {
					menuInput = "";
					System.out.println("To create a Student object you can enter either 0, 1, 2 or 4 Parameters");
					System.out.println("Seperate parameters using a comma, Here is the format:");
					System.out.println("0: Leave everything blank and hit enter");
					System.out.println("1: Is Graduate? T/F");
					System.out.println("2: Major || Is Graduate? T/F");
					System.out.println("4: Name || Birth Year || Major || Is Graduate? T/F");
					menuInput = menuScan.nextLine();
					numStudent = studentMaker(menuInput, student, numStudent);
					System.out.println(student[numStudent - 1].toString());
				}
			}
			
			if (menuInput.contentEquals("2")) {
				System.out.println("Which type of Object do you want to Edit?");
				System.out.println("Enter: C for Course || F for Faculty || S for Student");
				menuInput = menuScan.nextLine().toUpperCase();
				
				if(menuInput.contentEquals("C")) {
					courseHighestLowest(course, numCourse);
				}
				
				if(menuInput.contentEquals("F")) {
					System.out.println("Enter 1: To add one course");
					System.out.println("Enter 2: To add multiple courses");
					System.out.println("Enter 3: To get a course at a specific Index");
					System.out.println("Enter 4: To determine if Faculty teaches a particular course");
					System.out.println("Enter 5: To see which faculty teaches the most and least # of courses");
					menuInput = menuScan.nextLine();
					
					if(menuInput.contentEquals("1")) {
						for(int i = 0; i < numFaculty; i++) {
							System.out.println(i + ") " + faculty[i].toString());
						}
						System.out.println("*********************************************************");
						System.out.println("Pick a Faculty member by Entering his/her Index #:");
						System.out.println("*********************************************************");
						menuInput = menuScan.nextLine();
						int objectIndex = Integer.parseInt(menuInput);
						
						System.out.println("Add the course by entering these 4 parameters seperated by a comma");
						System.out.println("is Graduate T/F || Course Number || Course Department || # of Credits");
						menuInput = menuScan.nextLine();
						numCourse = courseMaker(menuInput, course, numCourse);
						faculty[objectIndex].addCourseTaught(course[numCourse - 1]);
						System.out.println("Sucessfully Added: " + course[numCourse - 1].getCourseDept() + " To: " + faculty[objectIndex].getName());
						
						
					}
					if(menuInput.contentEquals("2")) {
						for(int i = 0; i < numFaculty; i++) {
							System.out.println(i + ") " + faculty[i].toString());
						}
						System.out.println("*********************************************************");
						System.out.println("Pick a Faculty member by Entering his/her Index #:");
						System.out.println("*********************************************************");
						menuInput = menuScan.nextLine();
						int objectIndex = Integer.parseInt(menuInput);
						
						System.out.println("How many courses do you want to add?");
						int numToAdd = Integer.parseInt(menuScan.nextLine());
						Course [] tempCourse = new Course[numToAdd];
						int numTempCourse = 0;
						
						for (int i = 0; i < numToAdd; i ++) {
							System.out.println("Add the course by entering these 4 parameters seperated by a comma");
							System.out.println("is Graduate T/F || Course Number || Course Department || # of Credits");
							menuInput = menuScan.nextLine();
							numCourse = courseMaker(menuInput, course, numCourse);
							numTempCourse = courseMaker(menuInput, tempCourse, numTempCourse);
						}

						faculty[objectIndex].addCoursesTaught(tempCourse);
						
						for (int i =0; i < numTempCourse; i++) {
							if(i == 0) {
								System.out.print("Sucessfully Added: " + tempCourse[i].getCourseDept());
							}
							else {
								System.out.print(", " + tempCourse[i].getCourseDept());
							}
						}
						System.out.println(" To: " + faculty[objectIndex].getName());
					}
					
					if(menuInput.contentEquals("3")) {
						for(int i = 0; i < numFaculty; i++) {
							System.out.println(i + ") " + faculty[i].toString());
						}
						System.out.println("*********************************************************");
						System.out.println("Pick a Faculty member by Entering his/her Index #:");
						System.out.println("*********************************************************");
						menuInput = menuScan.nextLine();
						int objectIndex = Integer.parseInt(menuInput);
						
						System.out.println("This faculty member teaches " + faculty[objectIndex].getNumCoursesTaught() + " courses");
						if(faculty[objectIndex].getNumCoursesTaught() == 0) {
							System.out.println("Sorry, this faculty member does not teach any courses, cannot retrieve any info");
						}
						else {
							System.out.println("Pick an Index Number between 0 and " + (faculty[objectIndex].getNumCoursesTaught() -1) );
							int targetIndex = Integer.parseInt(menuScan.nextLine());
							if((targetIndex < 0) || (targetIndex > (faculty[objectIndex].getNumCoursesTaught() - 1)) ) {
								System.out.println("Invalid index chosen");
							}
							else {
								System.out.println( faculty[objectIndex].getCourseTaughtAsString(targetIndex) );
							}
						}
						}
					
					if(menuInput.contentEquals("4")) {
						for(int i = 0; i < numFaculty; i++) {
							System.out.println(i + ") " + faculty[i].toString());
						}
						System.out.println("*********************************************************");
						System.out.println("Pick a Faculty member by Entering his/her Index #:");
						System.out.println("*********************************************************");
						menuInput = menuScan.nextLine();
						int facultyIndex = Integer.parseInt(menuInput);
						
						for(int i = 0; i < numCourse; i++) {
							System.out.println(i + ") " + course[i].toString());
						}
						System.out.println("*********************************************************");
						System.out.println("Pick a Course by Entering its Index #:");
						System.out.println("*********************************************************");
						menuInput = menuScan.nextLine();
						int courseIndex = Integer.parseInt(menuInput);
						
						Faculty currentFaculty = faculty[facultyIndex];
						Course currentCourse = course[courseIndex];
						
						boolean doesCourseExist = false;
						for(int i = 0; i < currentFaculty.getNumCoursesTaught(); i++) {
							if(currentFaculty.getCourseTaught(i).equals(currentCourse)) {
							   doesCourseExist = true;
							   break;
							}
						}
						if(doesCourseExist) {
							System.out.println("Yes " + currentFaculty.getName() + " teaches " + currentCourse.getCourseDept());
						}
						else {
							System.out.println("No, " + currentFaculty.getName() + " does not teach " + currentCourse.getCourseDept());
						}
					}
					
					if(menuInput.contentEquals("5")) {
						facultyHighestLowest(faculty, numFaculty);
					}
				}// CLOSES OUT FACULTY ================================================
				
				if(menuInput.contentEquals("S")) {
					System.out.println("Enter 1: To add one course");
					System.out.println("Enter 2: To add multiple courses");
					System.out.println("Enter 3: To get a course at a specific Index");
					System.out.println("Enter 4: To determine which student has the most and least credits");
					menuInput = menuScan.nextLine();
					
					if(menuInput.contentEquals("1")) {
						for(int i = 0; i < numStudent; i++) {
							System.out.println(i + ") " + student[i].toString());
						}
						System.out.println("*********************************************************");
						System.out.println("Pick a student by Entering his/her Index #:");
						System.out.println("*********************************************************");
						menuInput = menuScan.nextLine();
						int objectIndex = Integer.parseInt(menuInput);
						
						System.out.println("Add the course by entering these 4 parameters seperated by a comma");
						System.out.println("is Graduate T/F || Course Number || Course Department || # of Credits");
						menuInput = menuScan.nextLine();
						numCourse = courseMaker(menuInput, course, numCourse);
						student[objectIndex].addCourseTaken(course[numCourse - 1]);
						System.out.println("Sucessfully Added: " + course[numCourse - 1].getCourseDept() + " To: " + student[objectIndex].getName());
						
						
					}
					if(menuInput.contentEquals("2")) {
						for(int i = 0; i < numStudent; i++) {
							System.out.println(i + ") " + student[i].toString());
						}
						System.out.println("*********************************************************");
						System.out.println("Pick a Student by Entering his/her Index #:");
						System.out.println("*********************************************************");
						menuInput = menuScan.nextLine();
						int objectIndex = Integer.parseInt(menuInput);
						
						System.out.println("How many courses do you want to add?");
						int numToAdd = Integer.parseInt(menuScan.nextLine());
						Course [] tempCourse = new Course[numToAdd];
						int numTempCourse = 0;
						
						for (int i = 0; i < numToAdd; i ++) {
							System.out.println("Add the course by entering these 4 parameters seperated by a comma");
							System.out.println("is Graduate T/F || Course Number || Course Department || # of Credits");
							menuInput = menuScan.nextLine();
							numCourse = courseMaker(menuInput, course, numCourse);
							numTempCourse = courseMaker(menuInput, tempCourse, numTempCourse);
						}

						student[objectIndex].addCoursesTaken(tempCourse);
						
						for (int i =0; i < numTempCourse; i++) {
							if(i == 0) {
								System.out.print("Sucessfully Added: " + tempCourse[i].getCourseDept());
							}
							else {
								System.out.print(", " + tempCourse[i].getCourseDept());
							}
						}
						System.out.println(" To: " + student[objectIndex].getName());
					}
					
					if(menuInput.contentEquals("3")) {
						for(int i = 0; i < numStudent; i++) {
							System.out.println(i + ") " + student[i].toString());
						}
						System.out.println("*********************************************************");
						System.out.println("Pick a Student by Entering his/her Index #:");
						System.out.println("*********************************************************");
						menuInput = menuScan.nextLine();
						int objectIndex = Integer.parseInt(menuInput);
						
						System.out.println("This student takes " + student[objectIndex].getNumCoursesTaken() + " courses");
						if(student[objectIndex].getNumCoursesTaken() == 0) {
							System.out.println("Sorry, this Student does not take any courses, cannot retrieve any info");
						}
						else {
							System.out.println("Pick an Index Number between 0 and " + (student[objectIndex].getNumCoursesTaken() -1) );
							int targetIndex = Integer.parseInt(menuScan.nextLine());
							if((targetIndex < 0) || (targetIndex > (student[objectIndex].getNumCoursesTaken() - 1)) ) {
								System.out.println("Invalid index chosen");
							}
							else {
								System.out.println( student[objectIndex].getCourseTakenAsString(targetIndex) );
							}
						}
					}
					
					if(menuInput.contentEquals("4")) {
						int [] totalCredit = new int [numStudent];
						
						for(int i = 0; i < numStudent; i++) {
							totalCredit[i] = studentTotalCredit(student[i]);
						}
						
						studentHighLow(totalCredit, student, numStudent);
					}
				}
			}// CLOSES OUT MAIN MENU OPTION 2
			
			if(menuInput.contentEquals("3")) {
				System.out.println();
				System.out.println("**************************************************************");
				System.out.println("SCHOOL DATABASE INFO:");
				System.out.println();
				System.out.println("************************************************");
				System.out.println("COURSES:");
				
				for(int i = 0; i < numCourse; i++) {
					System.out.println(course[i].toString());
				}
				
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("PERSONS:");
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("EMPLOYEES:");
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("GENERAL STAFF:");
				
				for(int i = 0; i < numGeneralStaff; i++) {
					System.out.println(generalStaff[i].toString());
				}
				
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("FACULTY:");
				
				for(int i = 0; i < numFaculty; i++) {
					System.out.println(faculty[i].toString());
				}
				
				System.out.println("************************************************");
				System.out.println("************************************************");
				System.out.println("STUDENTS:");
				
				for(int i = 0; i < numStudent; i++) {
					System.out.println(student[i].toString());
				}
				
				System.out.println("************************************************");
				System.out.println("**************************************************************");
				System.out.println();
			}
			
			if(menuInput.contentEquals("4")) {
				FileOutputStream outputTextFile = null;
				PrintWriter printToFile = null;
				try {
					outputTextFile = new FileOutputStream("Project1_Output.txt", false);
					printToFile = new PrintWriter(outputTextFile);
					
										printToFile.println();
					printToFile.println("**************************************************************");
					printToFile.println("SCHOOL DATABASE INFO:");
					printToFile.println();
					printToFile.println("************************************************");
					printToFile.println("COURSES:");
					
					for(int i = 0; i < numCourse; i++) {
						printToFile.println(course[i].toString());
					}
					
					printToFile.println("************************************************");
					printToFile.println("************************************************");
					printToFile.println("PERSONS:");
					printToFile.println("************************************************");
					printToFile.println("************************************************");
					printToFile.println("EMPLOYEES:");
					printToFile.println("************************************************");
					printToFile.println("************************************************");
					printToFile.println("GENERAL STAFF:");
					
					for(int i = 0; i < numGeneralStaff; i++) {
						printToFile.println(generalStaff[i].toString());
					}
					
					printToFile.println("************************************************");
					printToFile.println("************************************************");
					printToFile.println("FACULTY:");
					
					for(int i = 0; i < numFaculty; i++) {
						printToFile.println(faculty[i].toString());
					}
					
					printToFile.println("************************************************");
					printToFile.println("************************************************");
					printToFile.println("STUDENTS:");
					
					for(int i = 0; i < numStudent; i++) {
						printToFile.println(student[i].toString());
					}
					
					printToFile.println("************************************************");
					printToFile.println("************************************************");
					printToFile.flush();
				}
				catch(IOException excpt){
					System.out.println("Sorry a file error has occured");
				}
				finally {
					outputTextFile.close();
				}
			}
			
			System.out.println();
			menuPrompt = true;
			
		}

	}
	
	public static String extractObjectType(String input) {
		// Exit if the string is empty
		if(input.length() == 0) {
			return "";
		}
		String objectName = "";
		String newString = "";
		
		for(int i = 0; i < input.length(); i++) {
			//The object type is whatever comes before the ":"
			if(input.charAt(i) == ':') {
				objectName = input.substring(0, i);
				// newString only has the object's parameters
				if(i+2 < input.length()) {
					newString = input.substring(i+2, input.length());
				}
				break;
			}
		}
		objectName = objectName.toUpperCase();
		return objectName;
		
	}
	
	public static String deleteObjectName(String input) {
		// Exit if the string is empty
		if(input.length() == 0) {
			return "";
		}
		String objectName = "";
		String newString = "";
		
		for(int i = 0; i < input.length(); i++) {
			//The object type is whatever comes before the ":"
			if(input.charAt(i) == ':') {
				objectName = input.substring(0, i);
				// newString only has the object's parameters
				if(i+2 < input.length()) {
					newString = input.substring(i+2, input.length());
				}
				break;
			}
		}
		objectName = objectName.toUpperCase();
		return newString;
		
	}
	
	
	
	public static int courseMaker(String input, Course [] course, int numCourse) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
			Course addCourse = new Course(Boolean.parseBoolean(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], Integer.parseInt(parameters[3]) );
			course[numCourse] = addCourse;
			numCourse += 1;
			return numCourse;
	}
	
	public static int personMaker(String input, Person [] person, int numPerson) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			Person addPerson = new Person();
			person[numPerson] = addPerson;
			numPerson += 1;
			return numPerson;
		}
		if (numParameters == 2) {
			Person addPerson = new Person(parameters[0], Integer.parseInt(parameters[1]));
			person[numPerson] = addPerson;
			numPerson += 1;
			return numPerson;
		}
		return 0;
	}
	
	public static int employeeMaker(String input, Employee [] employee, int numEmployee) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			Employee addEmployee = new Employee();
			employee[numEmployee] = addEmployee;
			numEmployee += 1;
			return numEmployee;
		}
		if (numParameters == 1) {
			Employee addEmployee = new Employee(parameters[0]);
			employee[numEmployee] = addEmployee;
			numEmployee += 1;
			return numEmployee;
		}
		if (numParameters == 3) {
			Employee addEmployee = new Employee(parameters[0], Integer.parseInt(parameters[1]), parameters[2]);
			employee[numEmployee] = addEmployee;
			numEmployee += 1;
			return numEmployee;
		}
		return 0;
	}
	
	public static int facultyMaker(String input, Faculty [] faculty, int numFaculty) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			Faculty addFaculty = new Faculty();
			faculty[numFaculty] = addFaculty;
			numFaculty += 1;
			return numFaculty;
		}
		if (numParameters == 1) {
			Faculty addFaculty = new Faculty(Boolean.parseBoolean(parameters[0]));
			faculty[numFaculty] = addFaculty;
			numFaculty += 1;
			return numFaculty;
		}
		if (numParameters == 2) {
			Faculty addFaculty = new Faculty(parameters[0], Boolean.parseBoolean(parameters[1]));
			faculty[numFaculty] = addFaculty;
			numFaculty += 1;
			return numFaculty;
		}
		if (numParameters == 4) {
			Faculty addFaculty = new Faculty(parameters[0], Integer.parseInt(parameters[1]), parameters[2], Boolean.parseBoolean(parameters[3]));
			faculty[numFaculty] = addFaculty;
			numFaculty += 1;
			return numFaculty;
		}
		return 0;
	}
	
	public static int generalStaffMaker(String input, GeneralStaff [] generalStaff, int numGeneralStaff) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			GeneralStaff addGeneralStaff = new GeneralStaff();
			generalStaff[numGeneralStaff] = addGeneralStaff;
			numGeneralStaff += 1;
			return numGeneralStaff;
		}
		if (numParameters == 1) {
			GeneralStaff addGeneralStaff = new GeneralStaff(parameters[0]);
			generalStaff[numGeneralStaff] = addGeneralStaff;
			numGeneralStaff += 1;
			return numGeneralStaff;
		}
		if (numParameters == 2) {
			GeneralStaff addGeneralStaff = new GeneralStaff(parameters[0], parameters[1]);
			generalStaff[numGeneralStaff] = addGeneralStaff;
			numGeneralStaff += 1;
			return numGeneralStaff;
		}
		if (numParameters == 4) {
			GeneralStaff addGeneralStaff = new GeneralStaff(parameters[0], Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
			generalStaff[numGeneralStaff] = addGeneralStaff;
			numGeneralStaff += 1;
			return numGeneralStaff;
		}
		return 0;
	}
	
	public static int studentMaker(String input, Student [] student, int numStudent) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			Student addStudent = new Student();
			student[numStudent] = addStudent;
			numStudent += 1;
			return numStudent;
		}
		if (numParameters == 1) {
			Student addStudent = new Student(Boolean.parseBoolean(parameters[0]));
			student[numStudent] = addStudent;
			numStudent += 1;
			return numStudent;
		}
		if (numParameters == 2) {
			Student addStudent = new Student(parameters[0], Boolean.parseBoolean(parameters[1]));
			student[numStudent] = addStudent;
			numStudent += 1;
			return numStudent;
		}
		if (numParameters == 4) {
			Student addStudent = new Student(parameters[0], Integer.parseInt(parameters[1]), parameters[2], Boolean.parseBoolean(parameters[3]));
			student[numStudent] = addStudent;
			numStudent += 1;
			return numStudent;
		}
		return 0;
	}
	
	
	
	public static int countNumParameters(String text) {
		int numWords = 0;
		for(int i = 0; i < text.length(); i ++) {
			if(text.charAt(i) == ',') {
				numWords += 1;
			}
		}
		if (numWords == 0) {
		}
		else { 
			numWords = numWords + 1; 
			}
		//For cases where there is only 1 parameter and no commas to count
		if( (numWords == 0) && (text.length() > 0) ) {
			numWords = 1;
		}
		return numWords;
		
	}
	
	public static String [] seperateParameters(String text, int numParameters) {
		String [] parameters = new String[numParameters];
		int count = 0;
		String fixMe = "";
		int previousIndex = 0;
		
		for(int i = 0; i < text.length(); i++) {
			//Getting the last word into the array
			if(i == (text.length() - 1) ) {
				fixMe = text.substring(previousIndex, text.length() );
				//Word shouldn't begin with a space
				if(fixMe.charAt(0) == ' ') {
					fixMe = fixMe.substring(1, fixMe.length());
				}
				parameters[count] = fixMe;
				count += 1;
				previousIndex = i+1;
			}
			//Extracting the words into array based on "," follow by space
			if( (text.charAt(i) == ',') && (text.charAt(i+1) == ' ') ) {
				fixMe = text.substring(previousIndex, i);
				//Word shouldn't begin with a space
				if(fixMe.charAt(0) == ' ') {
					fixMe = fixMe.substring(1, fixMe.length());
				}
				parameters[count] = fixMe;
				count += 1;
				previousIndex = i+1;
			}
			//Extracting the word into array that go before a comma
			else if(text.charAt(i) == ',') {
				fixMe = text.substring(previousIndex, i);
				//Word shouldn't begin with a space
				if(fixMe.charAt(0) == ' ') {
					fixMe = fixMe.substring(1, fixMe.length());
				}
				parameters[count] = fixMe;
				count += 1;
				previousIndex = i+1;
			}
		
		}
		return parameters;
	}
	
	public static void courseHighestLowest(Course [] course, int numCourse) {
		int highest = 0;
		int highIndex = 0;
		int lowest = 0;
		int lowIndex = 0;
		int currentNum = 0;
		
		for(int i = 0; i < numCourse; i++) {
			if(i == 0) {
				lowest = course[i].getCourseNum();
				highest = course[i].getCourseNum();
			}
			else {
				currentNum = course[i].getCourseNum();
				if( currentNum < lowest) {
					lowest = currentNum;
					lowIndex = i;
				}
				if (currentNum > highest) {
					highest = currentNum;
					highIndex = i;
				}
			}
		}
		
		System.out.println("Lowest Course #: " + course[lowIndex]);
		System.out.println("Highest Course #: " + course[highIndex]);
	}
	
	public static void facultyHighestLowest(Faculty [] faculty, int numFaculty) {
		int lowest = 0;
		int lowIndex = 0;
		int highest = 0;
		int highIndex = 0;
		int currentNum = 0;
		
		for(int i = 0; i < numFaculty; i++) {
			if(i == 0) {
				lowest = faculty[i].getNumCoursesTaught();
				highest = faculty[i].getNumCoursesTaught();
			}
			else {
				currentNum = faculty[i].getNumCoursesTaught();
				if( currentNum < lowest) {
					lowest = currentNum;
					lowIndex = i;
				}
				if (currentNum > highest) {
					highest = currentNum;
					highIndex = i;
				}
			}
		}
		
		System.out.println("Teachest least # of Courses: " + faculty[lowIndex].toString());
		System.out.println("Teachst most #  of Courses: " + faculty[highIndex].toString());
		
		
	}
	
	public static int studentTotalCredit(Student student) {
		int total = 0;
		int numClassTaken = student.getNumCoursesTaken();
		
		for(int i = 0; i < numClassTaken; i++) {
			total = total + student.getCourseTaken(i).getNumCredits();
		}
		return total;
	}
	
	public static void studentHighLow(int [] totals, Student [] student, int totalLength) {
		int lowest = 0;
		int lowIndex = 0;
		int highest = 0;
		int highIndex = 0;
		int currentNum = 0;
		
		for(int i = 0; i < totalLength; i++) {
			if(i == 0) {
				lowest = totals[i];
				highest = totals[i];
			}
			else {
				currentNum = totals[i];
				if( currentNum < lowest) {
					lowest = currentNum;
					lowIndex = i;
				}
				if (currentNum > highest) {
					highest = currentNum;
					highIndex = i;
				}
			}
		}
		
		System.out.println("Student with least credits: " + student[lowIndex].toString());
		System.out.println("Student with most credits: " + student[highIndex].toString());
	}
	
	

}
