package com.bankApplication.bank;

import lombok.Data;

@Data
public class Transaction {

    private final Long id;
    private final Type type;
    private final Integer sum;

    private enum Type {
        SENDING, RECEIVING
    }
}
