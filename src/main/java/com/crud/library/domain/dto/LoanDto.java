package com.crud.library.domain.dto;

import com.crud.library.domain.User;
import com.crud.library.domain.Volume;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    private long id;
    private User user;
    private Volume volume;
    private Date pickUp;
    private Date dropOff;
}
