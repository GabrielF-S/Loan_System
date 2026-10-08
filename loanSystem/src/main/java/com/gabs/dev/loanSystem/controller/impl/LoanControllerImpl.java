package com.gabs.dev.loanSystem.controller.impl;

import com.gabs.dev.loanSystem.controller.LoanController;
import com.gabs.dev.loanSystem.dtos.request.LoanRequest;
import com.gabs.dev.loanSystem.dtos.response.LoanResponse;
import com.gabs.dev.loanSystem.serice.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/loan")
public class LoanControllerImpl implements LoanController {

    private final LoanService loanService;

    public LoanControllerImpl(LoanService loanService) {
        this.loanService = loanService;
    }


    @Override
    public ResponseEntity<LoanResponse> requestLoan(LoanRequest request) {
        return ResponseEntity.ok(loanService.calculateTax(request));
    }
}
