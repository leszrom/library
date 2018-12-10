package com.crud.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    private long id;
    private long userId;
    private long volumeId;
    private LocalDate pickUp;
    private LocalDate dropOff;
}
