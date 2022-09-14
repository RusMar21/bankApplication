package com.bankApplication.bank.entities;

import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class Card {

    @Id
    private Long id;

    @CreditCardNumber
    private final String card_Number;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([2-9][0-9])$")
    private final String card_Expiration;

    @Digits(integer = 3, fraction = 0)
    private final String card_CVV;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;


    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "card" )
    //private final List<Transaction> transactions;
}
