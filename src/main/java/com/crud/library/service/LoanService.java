package com.crud.library.service;

import com.crud.library.domain.Loan;
import com.crud.library.domain.User;
import com.crud.library.domain.Volume;
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

    public Loan createLoan(final User user, final Volume volume) {
        return loanRepository.save(new Loan(user, volume));
    }

    public Loan finishLoan(final Loan loan) {
        loan.setDropOff(new Date());
        loan.getVolume().setRented(false);
        return loanRepository.save(loan);
    }
}
