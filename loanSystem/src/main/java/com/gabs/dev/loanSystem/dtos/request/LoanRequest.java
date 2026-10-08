package com.gabs.dev.loanSystem.dtos.request;

import com.gabs.dev.loanSystem.model.util.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record LoanRequest(Integer age, @CPF String cpf, @NotBlank @NotNull String name, BigDecimal income, Location location) {
}
