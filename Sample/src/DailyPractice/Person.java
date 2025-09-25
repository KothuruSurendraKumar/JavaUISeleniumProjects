package DailyPractice;

public class Person {
	
	 String name;
	 String password;
	 
	 public Person() {}
	 
	 public Person(String name,String password) {
		 this.name = name;
		 this.password = password;
	 }

	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + "]";
	}
	 
	 
	 
	 
	
	

}
