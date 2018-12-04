package com.crud.library.mapper;

import com.crud.library.domain.Loan;
import com.crud.library.domain.dto.LoanDto;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    public Loan mapToLoan(LoanDto loanDto) {
        return new Loan(
                loanDto.getId(),
                loanDto.getUser(),
                loanDto.getVolume(),
                loanDto.getPickUp(),
                loanDto.getDropOff()
        );
    }

    public LoanDto mapToLoanDto(Loan loan) {
        return new LoanDto(
                loan.getId(),
                loan.getUser(),
                loan.getVolume(),
                loan.getPickUp(),
                loan.getDropOff()
        );
    }
}
