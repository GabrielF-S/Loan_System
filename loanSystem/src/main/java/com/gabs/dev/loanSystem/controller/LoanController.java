package com.gabs.dev.loanSystem.controller;

import com.gabs.dev.loanSystem.dtos.request.LoanRequest;
import com.gabs.dev.loanSystem.dtos.response.LoanResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;

public interface LoanController {

    @PostMapping("/costumer-loans")
    ResponseEntity<LoanResponse> requestLoan(@Valid @RequestBody LoanRequest request);
}
