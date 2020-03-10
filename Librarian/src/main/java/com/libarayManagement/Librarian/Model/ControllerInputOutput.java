package com.libarayManagement.Librarian.Model;

import java.util.List;

public class ControllerInputOutput {
	
	private List<Librarian> librarianList;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public List<Librarian> getLibrarianList() {
		return librarianList;
	}
	
	private ControllerInputOutput(ControllerBuilder controllerBuilder) {
		this.librarianList = controllerBuilder.librarianList;
		this.message = controllerBuilder.message;
	}
	
	public static class ControllerBuilder{
		
		private List<Librarian> librarianList;
		
		private String message;
		
		public ControllerBuilder() {
			
		}
		
		public ControllerBuilder librarianList(List<Librarian> librarianList) {
			this.librarianList = librarianList;
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
