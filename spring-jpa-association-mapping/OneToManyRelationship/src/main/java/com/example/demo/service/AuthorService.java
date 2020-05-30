package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }


    public Optional<Author> getAuthorById(int authorId) {
        if (!authorRepository.existsById(authorId)) {
            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
        }
        return authorRepository.findById(authorId);
    }


    public Author createAuthor(Author author) {
        return authorRepository.save(author);

    }

    public Author updateAuthorById(int authorId, Author authorRequest) {
        if (!authorRepository.existsById(authorId)) {
            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
        }
        Optional<Author> author = authorRepository.findById(authorId);

        if (!author.isPresent()) {
            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
        }

        Author author1 = author.get();
        author1.setFirstName(authorRequest.getFirstName());
        author1.setLastName(authorRequest.getLastName());
        return authorRepository.save(author1);

    }

    public ResponseEntity<Object> deleteAuthorById(int authorId) {
        if (!authorRepository.existsById(authorId)) {
            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
        }

        authorRepository.deleteById(authorId);

        return ResponseEntity.ok().build();

    }


}