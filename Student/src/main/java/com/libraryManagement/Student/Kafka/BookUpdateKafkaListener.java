package com.libraryManagement.Student.Kafka;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.libraryManagement.Student.Model.Book;
import com.libraryManagement.Student.Model.Student;
import com.libraryManagement.Student.Repository.IRepository.IDAOImpl;

@Component
public class BookUpdateKafkaListener {
	
	@Autowired
	private IDAOImpl dao;
	//private final CountDownLatch latch = new CountDownLatch(3);

	/*@Autowired
	public BookUpdateKafkaListener(IDAOImpl dao) {
		super();
		this.dao = dao;
	}*/
	
	@KafkaListener(topics = "updateStudentBookDetails")
	public void consume(ConsumerRecord<String, String> cr) throws IOException {
		
		Book book = /*cr.value();*/new ObjectMapper().readValue(cr.value(), Book.class);
		
		if(book != null) {
			Student student = dao.getStudentByRollNumber(book.getStudentRollNumber());
			if(student != null) {
				student.setBookSerialNumber(book.getSerialNumber());
				dao.addStudent(student);
			}
		}
	}
	
	@PostConstruct
	public void consumeKafkaMessages() {
		
	}

}
