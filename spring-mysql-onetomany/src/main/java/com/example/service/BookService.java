package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.entity.BookCategory;
import com.example.repository.BookCategoryRepository;
import com.example.repository.BookRepository;

@Service
public class BookService {
	private final BookCategoryRepository bookCategoryRepository;
    private final BookRepository bookRepository;

    public BookService(BookCategoryRepository bookCategoryRepository,
                       BookRepository bookRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookRepository = bookRepository;
    }

    public void create() {
        List<BookCategory> bookCategories = new ArrayList<>();
        IntStream intStream = IntStream.range(0, 9);
        intStream.forEach(index -> {
        	BookCategory bookCategory = new BookCategory("Category " + (index+1));
        	
            for (int j = 0; j < 2; j++) {
                Book book = new Book(String.format("Book %s.%s", (index+1), (j+1)));
                book.setBookCategory(bookCategory);
            }
            bookCategories.add(bookCategory);
        });

        bookCategoryRepository.saveAll(bookCategories);
    }

    public void read() {
        List<Book> books = bookRepository.findFirst10ByOrderByNameAsc();
        books.forEach(b -> System.out.println(
            String.format("%s, %s", b.getName(), b.getBookCategory().getName())
        ));
    }

    public void delete() {
        bookRepository.deleteInBulkByCategoryId(1);
    }
}
