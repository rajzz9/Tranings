package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Book;

@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@EntityGraph(attributePaths = "bookCategory")
    List<Book> findFirst10ByOrderByNameAsc();

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.bookCategory.id = ?1")
    void deleteInBulkByCategoryId(int categoryId);

    @Transactional
    void deleteByBookCategoryId(int categoryId);
}
