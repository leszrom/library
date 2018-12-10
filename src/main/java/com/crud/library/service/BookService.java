package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.BookDtoRequest;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.mapper.BookMapper;
import com.crud.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Long saveBook(final BookDtoRequest bookDtoRequest) {
        Book book = bookMapper.mapToBook(bookDtoRequest);
        return bookRepository.save(book).getId();
    }

    public Optional<Book> getBookById(final Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addVolume(final Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        book.getVolumes().add(new Volume(book, false));
        bookRepository.save(book);
    }


    public void deleteBookById(final Long id) {
        bookRepository.deleteById(id);
    }
}
