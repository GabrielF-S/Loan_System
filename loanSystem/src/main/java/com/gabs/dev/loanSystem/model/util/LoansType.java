package com.gabs.dev.loanSystem.model.util;

public enum LoansType {
    PERSONAL(1L, "PERSONAL" ),
    GUARANTEED(2L,"GUARANTEED"),
    CONSIGNMENT(3L, "CONSIGNMENT" );

    LoansType(Long id, String name) {

    }
}
