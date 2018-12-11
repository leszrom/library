package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BookDtoRequest;
import com.crud.library.domain.dto.VolumeDto;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.mapper.BookMapper;
import com.crud.library.mapper.VolumeMapper;
import com.crud.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final VolumeMapper volumeMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper, VolumeMapper volumeMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.volumeMapper = volumeMapper;
    }

    public Long saveBook(final BookDtoRequest bookDtoRequest) {
        Book book = bookMapper.mapToBook(bookDtoRequest);
        return bookRepository.save(book).getId();
    }

    public BookDto getBookById(final Long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return bookMapper.mapToBookDto(book);
    }

    public List<BookDto> getAllBooks() {
        return bookMapper.mapToBookDtoList(bookRepository.findAll());
    }

    public BookDto updateBook(final Long id, final BookDtoRequest bookDtoRequest) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        book.setTitle(bookDtoRequest.getTitle());
        book.setAuthor(bookDtoRequest.getAuthor());
        book.setPublicationYear(bookDtoRequest.getPublicationYear());
        return bookMapper.mapToBookDto(bookRepository.save(book));
    }

    public void deleteBookById(final Long id) {
        bookRepository.deleteById(id);
    }

    public void addVolume(final Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        book.getVolumes().add(new Volume(book));
        bookRepository.save(book);
    }

    public List<VolumeDto> getAllVolumesByBookId(final Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        List<Volume> volumeList = book.getVolumes();
        return volumeMapper.mapToVolumeDtoList(volumeList);
    }
}
