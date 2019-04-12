package test;

import java.util.ArrayList;
import java.util.Date;

import db.Databases;
import db.IStudentAccess;
import db.Student;

public class Test 
{

	public static void main(String[] args) 
	{
		
		IStudentAccess studentAccess = new Databases();
		
		ArrayList<Student> lista = studentAccess.readStudents();
		Student slavko = new Student (20, 2010, "Mirko", "Cuprija", new Date(1987, 9, 2), 2);
		//studentAccess.addStudent(slavko);
		
		for (Student s : lista)
			System.out.println(s);
		
//		System.out.println("Vraca odredjenog studenta");
//		Student s1 = studentAccess.readStudent(99, 2000);
//		System.out.println(s1);
		
//		System.out.println("Brise studenta");
//		studentAccess.deleteStudent(s1);
//		for (Student s : lista)
//			System.out.println(s);
		System.out.println("********************************");
		slavko.setIme("Mirko");
		studentAccess.updateStudent(slavko);
		for (Student s : lista)
			System.out.println(s);
	}

}
