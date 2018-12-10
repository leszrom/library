package com.crud.library.controller;

import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BookDtoRequest;
import com.crud.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Long createBook(@RequestBody BookDtoRequest bookDtoRequest) {
        return bookService.saveBook(bookDtoRequest);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public BookDto getBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookDto>getBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{bookId}/volumes")
    public void addBookVolume(@PathVariable Long bookId) {
        bookService.addVolume(bookId);
    }
}
