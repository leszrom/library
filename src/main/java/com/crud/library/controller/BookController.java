package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/books")
public class BookController {
    private BookService bookService;
    private BookMapper bookMapper;

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Book createBook(@RequestBody BookDto bookDto) {
        return bookService.saveBook(bookMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{bookId}/volumes")
    public void addBookVolume(@PathVariable Long bookId) {
        Book theBook = bookService.getBookById(bookId).get();
        theBook.getVolumes().add(new Volume(theBook, false));
        bookService.saveBook(theBook);
    }
}
