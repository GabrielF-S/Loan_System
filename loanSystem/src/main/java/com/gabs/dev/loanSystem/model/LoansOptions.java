package com.gabs.dev.loanSystem.model;

import com.gabs.dev.loanSystem.model.util.LoansType;
import lombok.Data;

import java.util.Objects;

@Data
public class LoansOptions {

    LoansType type;

    Double interest_rate;

    public LoansOptions() {

    }

    public LoansOptions(LoansType type) {
        this.type = type;

        switch (type.name()){
            case "PERSONAL" -> this.interest_rate = 0.4;
            case "GUARANTEED" -> this.interest_rate = 0.3;
            case "CONSIGNMENT" -> this.interest_rate = 0.2;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoansOptions that = (LoansOptions) o;
        return type == that.type && Objects.equals(interest_rate, that.interest_rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, interest_rate);
    }
}
