package com.libraryManagement.Student.Repository.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libraryManagement.Student.Model.Student;

@Repository
public interface IProductRepository extends JpaRepository<Student, Long> {

}
