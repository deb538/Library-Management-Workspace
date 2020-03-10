package com.libarayManagement.Librarian.Service.IService;

import java.util.List;

import com.libarayManagement.Librarian.Model.Librarian;
import com.libarayManagement.Librarian.Model.IModel.ILibrarian;

public interface ILibrarianService {
	
	public List<Librarian> getAllLibrarians();
	
	public Librarian getLibrarian(Integer id);
	
	public List<Librarian> getLibrarianByEmployeeNumber(ILibrarian librarian);
	
	public void deleteLibrarian(Integer id);
	
	public Librarian addLibrarian(Librarian librarian);

}
