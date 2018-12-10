package com.crud.library.service;

import com.crud.library.exception.LoanNotFoundException;
import com.crud.library.exception.UserNotFoundException;
import com.crud.library.exception.VolumeNotFoundException;
import com.crud.library.domain.Loan;
import com.crud.library.domain.User;
import com.crud.library.domain.Volume;
import com.crud.library.domain.dto.LoanDto;
import com.crud.library.domain.dto.LoanDtoRequest;
import com.crud.library.mapper.LoanMapper;
import com.crud.library.repository.LoanRepository;
import com.crud.library.repository.UserRepository;
import com.crud.library.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final VolumeRepository volumeRepository;
    private final LoanMapper loanMapper;

    @Autowired
    public LoanService(LoanRepository loanRepository, UserRepository userRepository, VolumeRepository volumeRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.volumeRepository = volumeRepository;
        this.loanMapper = loanMapper;
    }

    public Long saveLoan(final LoanDtoRequest loanDtoRequest) {

        User user = userRepository.findById(loanDtoRequest.getUserId())
                .orElseThrow(UserNotFoundException::new);
        Volume volume = volumeRepository.findById(loanDtoRequest.getVolumeId())
                .orElseThrow(VolumeNotFoundException::new);
        volume.setRented(true);

        Loan loan = new Loan(user, volume);
        return loanRepository.save(loan).getId();
    }

    public LoanDto setDropOffDateAndVolumeStatus(final Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(LoanNotFoundException::new);
        loan.getVolume().setRented(false);
        //loan.setDropOff(new Date());
        return loanMapper.mapToLoanDto(loanRepository.save(loan));
    }
}
