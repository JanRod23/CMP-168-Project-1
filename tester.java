
public class tester {

	public static void main(String[] args) {
		Course algebra = new Course(true, 125, "Math", 4);
		Course algebraClone = new Course(true, 125, "Math", 4);
		Course preCalc = new Course(false, 174, "Math", 4);
		Course calculus = new Course(false, 175, "Math", 4);
		
		System.out.println(algebra.compareTo(algebraClone));
		System.out.println(algebra.equals(algebraClone));
		System.out.println(algebra.equals(calculus));
		System.out.println(preCalc.equals(calculus));
		System.out.println(algebra.toString());
		System.out.println(algebraClone.toString());
		System.out.println(preCalc.toString());
		System.out.println(calculus.toString());
		System.out.println();
		System.out.println("===============================================================");
		
		Person lebron = new Person("LeBron", 1984);
		Person james = new Person("LeBron", 1984);
		Person davis = new Person("Davis", 1993);
		Person nikola = new Person("Nikola", 1995);
		Person mahomes = new Person("Mahomes", 1995);
		Person lamar = new Person("Lamar", 1997);
		
		System.out.println(lebron.compareTo(james));
		System.out.println(lebron.compareTo(mahomes));
		System.out.println(nikola.toString());
		System.out.println(davis.equals(lamar));
		System.out.println();
		System.out.println("===============================================================");
		
		Employee goku = new Employee("Goku", 1980, "Earth");
		Employee gokuTwin = new Employee("Goku", 1980, "Earth");
		Employee vegeta = new Employee("Vegeta", 1980, "Saiyan");
		Employee gohan = new Employee("Gohan", 2000, "Earth");
		Employee pikolo = new Employee("Pikolo", 1950, "Namek");
		
		System.out.println(goku.toString());
		System.out.println(vegeta.toString());
		System.out.println(gohan.toString());
		System.out.println(pikolo.toString());
		System.out.println("Comparing Goku with Gohan:   " + goku.compareTo(gohan));
		System.out.println("is Goku equal to GokuTwin?   " + goku.equals(gokuTwin));
		System.out.println();
		System.out.println("===============================================================");
		
		Faculty tomBrady = new Faculty("Tom Brady", 1975, "Patriots", true);
		Faculty drewBrees = new Faculty("Drew Brees", 1979, "Saints", true);
		Faculty aaronRodgers = new Faculty("Aaron Rodgers", 1983, "Packers", true);
		
		tomBrady.addCourseTaught(algebra);
		tomBrady.addCourseTaught(algebraClone);
		tomBrady.addCourseTaught(preCalc);
		tomBrady.addCourseTaught(calculus);
		drewBrees.addCourseTaught(calculus);
		aaronRodgers.addCourseTaught(preCalc);
		
		System.out.println(tomBrady.toString());
		System.out.println(drewBrees.toString());
		System.out.println(aaronRodgers.toString());
		System.out.println(tomBrady.getCourseTaught(3));
		System.out.println();
		System.out.println("===============================================================");
		
		GeneralStaff mcgregor = new GeneralStaff("Conor McGregor", 1988, "UFC", "Fight");
		GeneralStaff jonjones = new GeneralStaff("Jon Jones", 1985, "MMA", "Strike");
		GeneralStaff mayweather = new GeneralStaff("Floyd Mayweather", 1975, "Boxing", "Box");
		GeneralStaff canelo = new GeneralStaff("Canelo Alvarez", 1990, "Boxing", "Uppercut");
		
		System.out.println(mcgregor.toString());
		System.out.println(jonjones.toString());
		System.out.println(mayweather.toString());
		System.out.println(canelo.toString());
		System.out.println();
		System.out.println("===============================================================");
		
		Student ironMan = new Student("Tony Stark", 1970, "Billionare", true);
		Student ironManClone = new Student("Tony Stark", 1970, "Avenging", true);
		Student capAmerica = new Student("Cap", 1600, "Avenging", true);
		Student spiderMan = new Student("Spider-Man", 2000, "Student", false);
		Student wolverine = new Student("Logan", 1960, "X-Men", false);
		
		System.out.println(ironMan.toString());
		System.out.println(capAmerica.toString());
		System.out.println(spiderMan.toString());
		System.out.println(wolverine.toString());
		System.out.println("is IronMan equal to his clone? " + ironMan.compareTo(ironManClone));


	}

}
