package com.bz.BSUserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bz.BSUserService.Model.BookModel;

public interface IBookRepository extends JpaRepository<BookModel,Long>{

}
