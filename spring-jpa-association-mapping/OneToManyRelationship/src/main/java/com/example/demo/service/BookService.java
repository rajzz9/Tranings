package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Optional<Book> getBookById(int bookId) {
		if (!bookRepository.existsById(bookId)) {
			throw new ResourceNotFoundException("Book with id " + bookId + " not found");
		}
		return bookRepository.findById(bookId);
	}

	public Book createBook(int authorId, Book book) {
		Set<Book> books = new HashSet<>();
		Author author1 = new Author();

		Optional<Author> byId = authorRepository.findById(authorId);
		if (!byId.isPresent()) {
			throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
		}
		Author author = byId.get();

		// tie Author to Book
		book.setAuthor(author);

		Book book1 = bookRepository.save(book);
		// tie Book to Author
		books.add(book1);
		author1.setBooks(books);

		return book1;

	}

	public Book updateBookById(int bookId, Book bookRequest) {
		if (!bookRepository.existsById((int) bookId)) {
			throw new ResourceNotFoundException("Book with id " + bookId + " not found");
		}
		Optional<Book> book = bookRepository.findById(bookId);

		if (!book.isPresent()) {
			throw new ResourceNotFoundException("Book with id " + bookId + " not found");
		}

		Book book1 = book.get();
		book1.setGenre(bookRequest.getGenre());
		book1.setTitle(bookRequest.getTitle());

		return bookRepository.save(book1);
	}

	public ResponseEntity<Object> deleteBookById(int bookId) {
		if (!bookRepository.existsById(bookId)) {
			throw new ResourceNotFoundException("Book with id " + bookId + " not found");
		}

		bookRepository.deleteById(bookId);

		return ResponseEntity.ok().build();

	}
}