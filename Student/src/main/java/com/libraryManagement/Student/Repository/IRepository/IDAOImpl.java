package com.libraryManagement.Student.Repository.IRepository;

import java.util.List;

import com.libraryManagement.Student.Model.Student;

public interface IDAOImpl {
	
	public List<Student> getAllStudents();
	public Student getStudent(Long id);
	public Student getStudentByRollNumber(Integer rollNumber);
	public void deleteStudent(Long id);
	public Student addStudent(Student Student);
}
