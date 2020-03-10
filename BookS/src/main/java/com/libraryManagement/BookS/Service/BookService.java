package com.libraryManagement.BookS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libraryManagement.BookS.Exception.CustomRunTimeException;
import com.libraryManagement.BookS.Model.Book;
import com.libraryManagement.BookS.Repository.DAOImpl;
import com.libraryManagement.BookS.Service.IService.IBookService;

@Service
public class BookService implements IBookService{
	
	private static final String TOPIC = "updateStudentBookDetails";
	
	@Autowired
	DAOImpl daoImpl;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public List<Book> getAllBooks() {
		return daoImpl.getAllBooks();
	}
	
	public Book getBook(Integer id) {
		
		Book Book = daoImpl.getBook(Long.valueOf(id.toString()));
		
		if(Book == null) {
			throw new CustomRunTimeException("No Book found for Id " + id);
		}
		return Book;
	}
	
	public Book getBookBySerialNumber(String serialNumber) {
		
		Book Book = daoImpl.getBookBySerialNumber(serialNumber);
		
		if(Book == null) {
			throw new CustomRunTimeException("No Book found for serial number " + serialNumber);
		}
		return Book;
	}
	
	public void deleteBook(Integer id) {
		daoImpl.deleteBook(Long.valueOf(id.toString()));
	}
	
	public Book saveBook(Book Book) {
		return daoImpl.addBook(Book);
	}
	
	public Book linkBookWithStudent(Book book) {
		book =  this.saveBook(book);
		if(book.getStudentRollNumber() != null) {
			
			try {
				String jsonStr = new ObjectMapper().writeValueAsString(book);
				this.kafkaTemplate.send(TOPIC, jsonStr);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} 
		}
		return book;
	}
	
	public Book deLinkBookWithStudent(Book book) {
		return this.saveBook(book);
	}
}