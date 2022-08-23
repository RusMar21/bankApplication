package com.bankApplication.bank;

import lombok.Data;

@Data
public class Card {

    private final Long id;
    private final String cardNumber;
    private final String cardExpiration;
    private final String cardCVV;
}
