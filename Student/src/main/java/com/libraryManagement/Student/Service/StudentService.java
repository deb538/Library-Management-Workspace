package com.libraryManagement.Student.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagement.Student.Exception.CustomRunTimeException;
import com.libraryManagement.Student.Model.Student;
import com.libraryManagement.Student.Repository.DAOImpl;

@Service
public class StudentService implements IStudentService{
	
	@Autowired
	DAOImpl daoImpl;

	public List<Student> getAllStudents() {
		return daoImpl.getAllStudents();
	}
	
	public Student getStudent(Integer id) {
		
		Student Student = daoImpl.getStudent(Long.valueOf(id.toString()));
		
		if(Student == null) {
			throw new CustomRunTimeException("No Resource found");
		}
		return Student;
	}
	
	public void deleteStudent(Integer id) {
		daoImpl.deleteStudent(Long.valueOf(id.toString()));
	}
	
	public Student addStudent(Student Student) {
		return daoImpl.addStudent(Student);
	}
}
