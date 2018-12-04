package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book mapToBook(BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear()
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
