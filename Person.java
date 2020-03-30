
public class Person implements Comparable<Person> {
	private String name;
	private int birthYear;
	
	Person(){
		name = "";
		birthYear = 0;
	}
	
	Person(String name, int birthYear){
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setBirthYear(int newBirthYear) {
		birthYear = newBirthYear;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Person) {
			Person otherPerson = (Person)o;
			if( this.name.contentEquals(otherPerson.getName()) ) {
				if( this.birthYear == otherPerson.getBirthYear() ) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
	}
	
	@Override
	public int compareTo(Person p) {
		if(this.birthYear > p.getBirthYear()) {
			return 1;
		}
		else if(this.birthYear < p.getBirthYear()) {
			return -1;
		}
		return 0;
	}

}
