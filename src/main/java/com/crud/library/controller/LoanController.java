package com.crud.library.controller;

import com.crud.library.domain.Loan;
import com.crud.library.domain.dto.LoanDto;
import com.crud.library.mapper.LoanMapper;
import com.crud.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/loans")
public class LoanController {
    private LoanService loanService;
    private LoanMapper loanMapper;

    @Autowired
    public LoanController(LoanService loanService, LoanMapper loanMapper) {
        this.loanService = loanService;
        this.loanMapper = loanMapper;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Loan createLoan(@RequestBody LoanDto loanDto) {
        return loanService.saveLoan(loanMapper.mapToLoan(loanDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{loanId}")
    public Loan finishLoan(@PathVariable Long loanId) {
        return loanService.setDropOffDateAndVolumeStatus(loanId);
    }
}
