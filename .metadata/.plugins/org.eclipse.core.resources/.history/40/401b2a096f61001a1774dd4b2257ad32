package com.libraryManagement.BookS.Model;

import java.util.List;

public class ControllerInputOutput {
	
	private List<Book> bookList;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public List<Book> getbookList() {
		return bookList;
	}
	
	private ControllerInputOutput(ControllerBuilder controllerBuilder) {
		this.bookList = controllerBuilder.bookList;
		this.message = controllerBuilder.message;
	}
	
	public static class ControllerBuilder{
		
		private List<Book> bookList;
		
		private String message;
		
		public ControllerBuilder() {
			
		}
		
		public ControllerBuilder bookList(List<Book> bookList) {
			this.bookList = bookList;
			return this;
		}
		
		public ControllerBuilder message(String message) {
			this.message = message;
			return this;
		}
		
		public ControllerInputOutput build() {
			ControllerInputOutput user =  new ControllerInputOutput(this);
            return user;
        }
	}
}
