package db;

import java.util.ArrayList;

public interface IStudentAccess 
{
	public boolean addStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student readStudent(int indeks, int godinaUpisa);
	ArrayList<Student> readStudents();
	
}
