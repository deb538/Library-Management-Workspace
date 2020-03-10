package com.libraryManagement.BookS.Service.IService;

import java.util.List;

import com.libraryManagement.BookS.Model.Book;

public interface IBookService {

	public List<Book> getAllBooks();
	
	public Book getBook(Integer id);
	
	public void deleteBook(Integer id);
	
	public Book saveBook(Book Book);
	
	public Book linkBookWithStudent(Book book);
	
	public Book deLinkBookWithStudent(Book book);
	
	public Book getBookBySerialNumber(String serialNumber);
}