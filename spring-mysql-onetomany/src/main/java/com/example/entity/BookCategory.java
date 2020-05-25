package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "BookCategory")
@Table(name = "book_category")
public class BookCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(
        mappedBy = "bookCategory",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )
    private Set<Book> books;

    public BookCategory() {
        books = new HashSet<>();
    }

    public BookCategory(String name) {
        this.name = name;
        books = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
        for (Book book : books) {
            book.setBookCategory(this);
        }
    }
    
}
