package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.domain.Volume;
import com.crud.library.service.BookService;
import com.crud.library.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/books")
public class VolumeController {
    private static final String BOOK_DOES_NOT_EXIST = "The book with the given id does not exist";
    private VolumeService volumeService;
    private BookService bookService;

    @Autowired
    public VolumeController(VolumeService volumeService, BookService bookService) {
        this.volumeService = volumeService;
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "{bookId}/volumes")
    public Long createVolume(@PathVariable Long bookId) throws BookNotFoundException {
        Book theBook = bookService.getBookById(bookId)
                .orElseThrow(() -> new BookNotFoundException(BOOK_DOES_NOT_EXIST));
        return volumeService.saveVolume(new Volume(theBook, false)).getId();
    }
}
