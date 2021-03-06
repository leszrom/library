package com.crud.library.controller;

import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BookDtoRequest;
import com.crud.library.domain.dto.VolumeDto;
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
    public List<BookDto> getBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public BookDto changeBookDetails(@PathVariable Long id, @RequestBody BookDtoRequest bookDtoRequest) {
        return bookService.updateBook(id, bookDtoRequest);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{bookId}/volumes")
    public void addBookVolume(@PathVariable Long bookId) {
        bookService.addVolume(bookId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{bookId}/volumes")
    public List<VolumeDto> getVolumes(@PathVariable Long bookId) {
        return bookService.getAllVolumesByBookId(bookId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{bookId}/volumes/is")
    public List<VolumeDto> getVolumesByAvailability(@PathVariable Long bookId, @RequestParam Boolean rented) {
        return bookService.getAllVolumesByBookIdAndAvailability(bookId, rented);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{bookId}/volumes/{volumeId}")
    public VolumeDto getVolume(@PathVariable Long bookId, @PathVariable Long volumeId) {
        return bookService.getVolumeById(bookId, volumeId);
    }
}
