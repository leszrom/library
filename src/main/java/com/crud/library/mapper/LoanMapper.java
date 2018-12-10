package com.crud.library.mapper;

import com.crud.library.domain.Loan;
import com.crud.library.domain.dto.LoanDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<LoanDto> mapToLoanDtoList(final List<Loan> loanList) {
        return loanList.stream()
                .map(this::mapToLoanDto)
                .collect(Collectors.toList());
    }
}
