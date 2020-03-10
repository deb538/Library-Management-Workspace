package com.libraryManagement.BookS.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libraryManagement.BookS.Model.Book;
import com.libraryManagement.BookS.Repository.IRepository.IDAOImpl;
import com.libraryManagement.BookS.Repository.IRepository.IProductRepository;

@Repository
public class DAOImpl implements IDAOImpl {
	
	@Autowired
	private IProductRepository dataRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Book> getAllBooks() {
		return dataRepository.findAll();
	}
	
	public Book getBook(Long id) {
		Optional<Book> optionalObject = dataRepository.findById(id);
		if(optionalObject.isPresent()) {
			return optionalObject.get();
		}
		return null;
	}
	
	public Book getBookBySerialNumber(String serialNumber) {
		
		Query q = entityManager.createNativeQuery("Select * from Book l where l.serial_number = :serialNumber", Book.class);
		q.setParameter("serialNumber", serialNumber);
		return q.getResultList() != null ? (Book)q.getResultList().iterator().next() : null;
	}
	
	public void deleteBook(Long id) {
		dataRepository.deleteById(id);
	}
	
	public Book addBook(Book Book) {
		return dataRepository.save(Book);
	}

}
