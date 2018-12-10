package com.crud.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDtoRequest {
    private String title;
    private String author;
    private int publicationYear;
}
