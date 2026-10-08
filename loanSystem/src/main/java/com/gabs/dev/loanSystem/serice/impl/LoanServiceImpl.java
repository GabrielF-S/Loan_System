package com.gabs.dev.loanSystem.serice.impl;

import com.gabs.dev.loanSystem.dtos.request.LoanRequest;
import com.gabs.dev.loanSystem.dtos.response.LoanResponse;
import com.gabs.dev.loanSystem.model.LoansOptions;
import com.gabs.dev.loanSystem.model.util.LoansType;
import com.gabs.dev.loanSystem.model.util.Location;
import com.gabs.dev.loanSystem.serice.LoanService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class LoanServiceImpl implements LoanService {

    @Override
    @Cacheable("costomer_loan")
    public LoanResponse calculateTax(LoanRequest request) {

        Set<LoansOptions> options = new HashSet<>();


        int incomeLessThan3K = request.income().compareTo(BigDecimal.valueOf(3000.00));

        if (incomeLessThan3K <= 0) {
            options.add(new LoansOptions(LoansType.PERSONAL));
            options.add(new LoansOptions(LoansType.GUARANTEED));
        }

        int incomeCompareTo5K = request.income().compareTo(BigDecimal.valueOf(5000.00));
        if (
                request.location().equals(Location.SP)
                && request.age() < 30
                && (incomeLessThan3K >= 0
                && incomeCompareTo5K <= 0)
        ) {
            options.add(new LoansOptions(LoansType.PERSONAL));
            options.add(new LoansOptions(LoansType.GUARANTEED));

        }
        if (incomeCompareTo5K >= 0) {
            options.add(new LoansOptions(LoansType.CONSIGNMENT));
        }

        return new LoanResponse(request.name(), options.stream().toList());
    }

}
