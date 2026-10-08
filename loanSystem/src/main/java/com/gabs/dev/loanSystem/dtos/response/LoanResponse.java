package com.gabs.dev.loanSystem.dtos.response;

import com.gabs.dev.loanSystem.model.LoansOptions;

import java.util.List;

public record LoanResponse(String customer, List<LoansOptions> loans) {
}
