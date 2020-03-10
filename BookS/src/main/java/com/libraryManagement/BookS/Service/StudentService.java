package com.libraryManagement.BookS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.libraryManagement.BookS.Exception.CustomRunTimeException;
import com.libraryManagement.BookS.Model.Student;
import com.libraryManagement.BookS.Service.IService.IStudentFeign;
import com.libraryManagement.BookS.Service.IService.IStudentService;

@Service
public class StudentService implements IStudentService{
	
	@Autowired
	IStudentFeign studentFeignService;

	public Student getStudent(Integer id) {
		
		ResponseEntity<Student> studentResponse = studentFeignService.getStudent(id);
		
		if(studentResponse == null || studentResponse.getBody() == null) {
			throw new CustomRunTimeException("No student details found for student " + id);
		}
		return studentResponse.getBody();
	}
}