package com.libarayManagement.Librarian.Repository.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libarayManagement.Librarian.Model.Librarian;

@Repository
public interface IProductRepository extends JpaRepository<Librarian, Long> {

}
