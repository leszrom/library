package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.dto.BookDto;
import com.crud.library.domain.dto.BookDtoRequest;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book mapToBook(BookDtoRequest bookDtoRequest) {
        return new Book(
                bookDtoRequest.getTitle(),
                bookDtoRequest.getAuthor(),
                bookDtoRequest.getPublicationYear()
        );
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear()
        );
    }
}
