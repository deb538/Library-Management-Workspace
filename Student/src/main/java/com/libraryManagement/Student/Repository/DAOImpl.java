package com.libraryManagement.Student.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libraryManagement.Student.Model.Student;
import com.libraryManagement.Student.Repository.IRepository.IDAOImpl;
import com.libraryManagement.Student.Repository.IRepository.IProductRepository;

@Repository
public class DAOImpl implements IDAOImpl {
	
	@Autowired
	private IProductRepository dataRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Student> getAllStudents() {
		return dataRepository.findAll();
	}
	
	public Student getStudent(Long id) {
		Optional<Student> optionalObject = dataRepository.findById(id);
		if(optionalObject.isPresent()) {
			return optionalObject.get();
		}
		return null;
	}
	
	public Student getStudentByRollNumber(Integer rollNumber) {
		
		Query q = entityManager.createNativeQuery("Select * from Student l where l.roll_number = :roll_number", Student.class);
		q.setParameter("roll_number", rollNumber);
		Student s  = (Student)q.getResultList().iterator().next();
		return s;
	}
	
	public void deleteStudent(Long id) {
		dataRepository.deleteById(id);
	}
	
	public Student addStudent(Student Student) {
		return dataRepository.save(Student);
	}

}
