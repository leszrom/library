package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.domain.Volume;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.repository.BookRepository;
import com.crud.library.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/books")
public class VolumeController {
    private VolumeService volumeService;
    private BookRepository bookRepository;

    @Autowired
    public VolumeController(VolumeService volumeService, BookRepository bookRepository) {
        this.volumeService = volumeService;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "{bookId}/volumes")
    public Long createVolume(@PathVariable Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(BookNotFoundException::new);
        return volumeService.saveVolume(new Volume(book, false)).getId();
    }
}
