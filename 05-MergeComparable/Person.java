
public class Person implements Comparable<Person> { 
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int compareTo(Person person) {
		return this.age - person.getAge();
	}
	/*public String compareTo(Person person) {
		return this.name.compareTo(Person.getName());
	}*/
	
	public String toString() {
		return this.name + ", who is " + this.age + " years old";
	}
}