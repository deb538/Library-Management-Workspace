package com.libraryManagement.Student.Model;

public class Book{
	
	private Long id;
	private String bookName;
	private String serialNumber;
	private Integer studentRollNumber;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getStudentRollNumber() {
		return studentRollNumber;
	}
	public void setStudentRollNumber(Integer studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
