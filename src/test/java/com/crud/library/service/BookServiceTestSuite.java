package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BookDtoRequest;
import com.crud.library.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceTestSuite {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void should_save_given_book_to_database() {
        //Given
        BookDtoRequest bookDtoRequest = new BookDtoRequest("title", "author", 1995);

        //When
        Long bookId = bookService.saveBook(bookDtoRequest);
        Book readBook = bookRepository.findOne(bookId);

        //Then
        Assert.assertEquals("title", readBook.getTitle());
        Assert.assertEquals("author", readBook.getAuthor());
        Assert.assertEquals(1995, readBook.getPublicationYear());

        //CleanUp
        bookRepository.deleteById(bookId);
    }

    @Test
    public void should_return_book_from_database_by_given_id() {
        //Given
        Book book = new Book("title", "author", 1995);
        Long bookId = bookRepository.save(book).getId();

        //When
        BookDto readBook = bookService.getBookById(bookId);

        //Then
        Assert.assertEquals("title", readBook.getTitle());
        Assert.assertEquals("author", readBook.getAuthor());
        Assert.assertEquals(1995, readBook.getPublicationYear());

        //CleanUp
        bookRepository.deleteById(bookId);
    }

    @Test
    public void should_return_all_books_in_database() {
        //Given
        Book book = new Book("title", "author", 1995);
        int booksQuantity = bookRepository.findAll().size();

        Long bookId = bookRepository.save(book).getId();

        //When
        List<BookDto> books = bookService.getAllBooks();
        boolean isListContainingSavedBook = books.stream()
                .map(BookDto::getId)
                .anyMatch(id -> id.equals(bookId));

        //Then
        Assert.assertEquals(booksQuantity + 1, books.size());
        Assert.assertTrue(isListContainingSavedBook);

        //CleanUp
        bookRepository.deleteById(bookId);
    }

    @Test
    public void should_return_UpdateBook() {
        //Given

        //When

        //Then

    }

    @Test
    public void should_return_DeleteBookById() {
        //Given

        //When

        //Then

    }

    @Test
    public void should_return_AddVolume() {
        //Given

        //When

        //Then

    }

    @Test
    public void should_return_GetAllVolumesByBookId() {
        //Given

        //When

        //Then

    }

    @Test
    public void should_return_GetAllVolumesByBookIdAndAvailability() {
        //Given

        //When

        //Then

    }

    @Test
    public void should_return_GetVolumeById() {
        //Given

        //When

        //Then

    }


}