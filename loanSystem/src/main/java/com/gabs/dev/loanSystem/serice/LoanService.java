package com.gabs.dev.loanSystem.serice;

import com.gabs.dev.loanSystem.dtos.request.LoanRequest;
import com.gabs.dev.loanSystem.dtos.response.LoanResponse;

public interface LoanService {
     LoanResponse calculateTax(LoanRequest request);
}
