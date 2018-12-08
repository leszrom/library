package com.crud.library.mapper;

import com.crud.library.domain.Loan;
import com.crud.library.domain.dto.LoanDto;
import com.crud.library.repository.UserRepository;
import com.crud.library.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    private VolumeService volumeService;
    private UserRepository userRepository;

    @Autowired
    public LoanMapper(VolumeService volumeService, UserRepository userRepository) {
        this.volumeService = volumeService;
        this.userRepository = userRepository;
    }

    public Loan mapToLoan(LoanDto loanDto) {
        return new Loan(
                loanDto.getId(),
                userRepository.findOne(loanDto.getUserId()),
                volumeService.getVolumeById(loanDto.getVolumeId()).get(),
                loanDto.getPickUp(),
                loanDto.getDropOff()
        );
    }

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
