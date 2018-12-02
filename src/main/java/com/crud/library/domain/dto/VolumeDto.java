package com.crud.library.domain.dto;

import com.crud.library.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VolumeDto {
    private long id;
    private Book book;
    private boolean isRented;
}
