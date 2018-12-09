package com.crud.library.service;

import com.crud.library.domain.Loan;
import com.crud.library.domain.User;
import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.LoanDto;
import com.crud.library.repository.LoanRepository;
import com.crud.library.repository.UserRepository;
import com.crud.library.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final VolumeRepository volumeRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository, UserRepository userRepository, VolumeRepository volumeRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.volumeRepository = volumeRepository;
    }

    public Long saveLoan(final LoanDto loanDto) {
        User user = userRepository.findOne(loanDto.getUserId());
        Volume volume = volumeRepository.findOne(loanDto.getId());
        volume.setRented(true);
        Loan loan = new Loan(user, volume, new Date());
        return loanRepository.save(loan).getId();
    }

    public Loan setDropOffDateAndVolumeStatus(final Long id) {
        Loan theLoan = loanRepository.findById(id).get();
        theLoan.setDropOff(new Date());
        theLoan.getVolume().setRented(false);
        return loanRepository.save(theLoan);
    }
}
