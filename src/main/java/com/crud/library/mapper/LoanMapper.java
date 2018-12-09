package com.crud.library.mapper;

import com.crud.library.domain.Loan;
import com.crud.library.domain.dto.LoanDto;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public LoanDto mapToLoanDto(Loan loan) {
        return new LoanDto(
                loan.getId(),
                loan.getUser().getId(),
                loan.getVolume().getId(),
                loan.getPickUp(),
                loan.getDropOff()
        );
    }
}
