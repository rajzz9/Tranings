package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Child;
import com.example.demo.entity.Parent;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.ChildService;
import com.example.demo.service.ParentService;

@RestController
public class AuthorBookController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @Autowired
    ParentService parentService;

    @Autowired
    ChildService childService;

    @RequestMapping(value = "/getAllAuthors", method = RequestMethod.GET)
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @RequestMapping(value = "/parent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Parent createParent(@RequestBody Parent parent) {
        return parentService.createParent(parent);
    }


    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.GET)
    public Optional<Author> getAuthorById(@PathVariable(value = "authorId") int authorId) {
        return authorService.getAuthorById(authorId);
    }

    @RequestMapping(value = "/author", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author updateAuthor(@PathVariable(value = "authorId") int authorId, @RequestBody Author author) {
        return authorService.updateAuthorById(authorId, author);
    }

    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAuthorById(@PathVariable(value = "authorId") int authorId) {
        return authorService.deleteAuthorById(authorId);
    }

    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }


    //
    @RequestMapping(value = "/{authorId}/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@PathVariable(value = "authorId") int authorId, @RequestBody Book book) {
        return bookService.createBook(authorId, book);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public Optional<Book> getBookById(@PathVariable(value = "bookId") int bookId) {
        return bookService.getBookById(bookId);
    }


    @RequestMapping(value = "/book", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book updateBook(@PathVariable(value = "bookId") int bookId, @RequestBody Book book) {
        return bookService.updateBookById(bookId, book);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBookById(@PathVariable(value = "bookId") int bookId) {
        return bookService.deleteBookById(bookId);
    }


    @RequestMapping(value = "/{parentId}/child", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Child createChild(@PathVariable(value = "parentId") int parentId, @RequestBody Child child) {
        return childService.createChild(parentId, child);
    }

    @RequestMapping(value = "/child/{childId}", method = RequestMethod.GET)
    public Optional<Child> getChildById(@PathVariable(value = "childId") int childId) {
        return childService.getChildById(childId);
    }

}
