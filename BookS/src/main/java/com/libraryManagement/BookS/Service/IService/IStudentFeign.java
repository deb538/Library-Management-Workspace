package com.libraryManagement.BookS.Service.IService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.libraryManagement.BookS.Model.Student;

@FeignClient(name="student-service")
public interface IStudentFeign {

	@GetMapping("/api/v1/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable(value = "id") Integer id);
}