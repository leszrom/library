package com.crud.library.service;

import com.crud.library.domain.Loan;
import com.crud.library.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan saveLoan(final Loan loan) {
        loan.setPickUp(new Date());
        loan.getVolume().setRented(true);
        return loanRepository.save(loan);
    }

    public Loan setDropOffDateAndVolumeStatus(final Long id) {
        Loan theLoan = loanRepository.findById(id).get();
        theLoan.setDropOff(new Date());
        theLoan.getVolume().setRented(false);
        return loanRepository.save(theLoan);
    }
}
