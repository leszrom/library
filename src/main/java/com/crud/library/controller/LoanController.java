package com.crud.library.controller;

import com.crud.library.domain.Loan;
import com.crud.library.domain.dto.LoanDto;
import com.crud.library.domain.dto.LoanDtoRequest;
import com.crud.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/loans")
public class LoanController {
    private LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Long createLoan(@RequestBody LoanDtoRequest loanDtoRequest) {
        return loanService.saveLoan(loanDtoRequest);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{loanId}")
    public LoanDto finishLoan(@PathVariable Long loanId) {
        return loanService.setDropOffDateAndVolumeStatus(loanId);
    }
}
