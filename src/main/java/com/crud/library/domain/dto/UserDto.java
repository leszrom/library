package com.crud.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String firstname;
    private String lastname;
    private Date created;
}
