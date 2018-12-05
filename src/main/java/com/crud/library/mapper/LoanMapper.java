package com.crud.library.mapper;

import com.crud.library.domain.Loan;
import com.crud.library.domain.dto.LoanDto;
import com.crud.library.service.UserService;
import com.crud.library.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    private UserService userService;
    private VolumeService volumeService;

    @Autowired
    public LoanMapper(UserService userService, VolumeService volumeService) {
        this.userService = userService;
        this.volumeService = volumeService;
    }

    public Loan mapToLoan(LoanDto loanDto) {
        return new Loan(
                loanDto.getId(),
                userService.getUserById(loanDto.getUserId()).get(),
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
