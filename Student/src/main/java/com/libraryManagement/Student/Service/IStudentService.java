package com.libraryManagement.Student.Service;

import java.util.List;

import com.libraryManagement.Student.Model.Student;

public interface IStudentService {
	
	public List<Student> getAllStudents();
	
	public Student getStudent(Integer id);
	
	public void deleteStudent(Integer id);
	
	public Student addStudent(Student Student);

}
