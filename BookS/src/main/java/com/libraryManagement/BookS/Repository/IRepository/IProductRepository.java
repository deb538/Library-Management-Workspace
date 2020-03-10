package com.libraryManagement.BookS.Repository.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libraryManagement.BookS.Model.Book;

@Repository
public interface IProductRepository extends JpaRepository<Book, Long> {

}
