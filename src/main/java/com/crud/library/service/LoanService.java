package com.crud.library.service;

import com.crud.library.domain.Loan;
import com.crud.library.domain.dto.LoanDto;
import com.crud.library.mapper.LoanMapper;
import com.crud.library.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Autowired
    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    public Long saveLoan(final LoanDto loanDto) {
        Loan loan = loanMapper.mapToLoan(loanDto);
        loan.setPickUp(new Date());
        loan.getVolume().setRented(true);
        return loanRepository.save(loan).getId();
    }

    public Loan setDropOffDateAndVolumeStatus(final Long id) {
        Loan theLoan = loanRepository.findById(id).get();
        theLoan.setDropOff(new Date());
        theLoan.getVolume().setRented(false);
        return loanRepository.save(theLoan);
    }
}
