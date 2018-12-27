package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BookDtoRequest;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.VolumeRepository;
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

    @Autowired
    private VolumeRepository volumeRepository;

    @Test
    public void should_save_given_book_to_database() {
        //Given
        BookDtoRequest bookDtoRequest = new BookDtoRequest("title", "author", 1995);

        //When
        long bookId = bookService.saveBook(bookDtoRequest);
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
        long bookId = bookRepository.save(book).getId();

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

        long bookId = bookRepository.save(book).getId();

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
    public void should_return_updated_book() {
        //Given
        Book book = new Book("title", "author", 1995);
        long bookId = bookRepository.save(book).getId();
        BookDtoRequest bookDtoRequest = new BookDtoRequest("new_title", "new_author", 2000);

        //When
        BookDto updatedBook = bookService.updateBook(bookId, bookDtoRequest);

        //Then
        Assert.assertEquals(bookId, updatedBook.getId());
        Assert.assertEquals("new_title", updatedBook.getTitle());
        Assert.assertEquals("new_author", updatedBook.getAuthor());
        Assert.assertEquals(2000, updatedBook.getPublicationYear());

        //CleanUp
        bookRepository.deleteById(bookId);
    }

    @Test
    public void should_return_DeleteBookById() {
        //Given
        Book book = new Book("title", "author", 1995);
        long bookId = bookRepository.save(book).getId();

        //When
        bookService.deleteBookById(bookId);

        List<BookDto> books = bookService.getAllBooks();
        boolean isListContainingDeletedBook = books.stream()
                .map(BookDto::getId)
                .anyMatch(id -> id.equals(bookId));

        //Then
        Assert.assertFalse(isListContainingDeletedBook);
    }

    @Test
    public void should_create_new_volume_of_book() {
        //Given
        Book book = new Book("title", "author", 1995);
        long bookId = bookRepository.save(book).getId();

        //When
        bookService.addVolume(bookId);
        int volumesQuantity = volumeRepository.findAllByBookId(bookId).size();

        //Then
        Assert.assertEquals(1, volumesQuantity);

        //ClenaUp
        bookRepository.deleteById(bookId);
    }

    @Test
    public void should_return_list_of_volumes_by_book_id() {
        //Given
        Book book = new Book("title", "author", 1995);
        book.getVolumes().add(new Volume(book));
        long bookId = bookRepository.save(book).getId();

        //When
        int volumesQuantity = bookService.getAllVolumesByBookId(bookId).size();

        //Then
        Assert.assertEquals(1, volumesQuantity);

        //CleanUp
        bookRepository.deleteById(bookId);
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