package com.libraryManagement.Student.Model;

import java.util.List;

public class ControllerInputOutput {
	
	private List<Student> StudentList;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public List<Student> getStudentList() {
		return StudentList;
	}
	
	private ControllerInputOutput(ControllerBuilder controllerBuilder) {
		this.StudentList = controllerBuilder.StudentList;
		this.message = controllerBuilder.message;
	}
	
	public static class ControllerBuilder{
		
		private List<Student> StudentList;
		
		private String message;
		
		public ControllerBuilder() {
			
		}
		
		public ControllerBuilder studentList(List<Student> StudentList) {
			this.StudentList = StudentList;
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
