package com;

public class Student {
	
	int rollNo;
	double marks;
	String name;
	
	void display() {
		System.out.println("Name :"+name);
		System.out.println("rollNo :"+rollNo);
		System.out.println("Marks :"+marks);
	}

	public static void main(String[] args) {
		// First Student
		Student st1 = new Student();
		st1.name = "Jhon";
		st1.rollNo = 123;
		st1.marks = 900.01;
		
		Student st2 = new Student();
		st2.name = "Ram";
		st2.rollNo = 234;
		st2.marks = 950.24;
		
		st1.display();
		st2.display();
		

	}

}
