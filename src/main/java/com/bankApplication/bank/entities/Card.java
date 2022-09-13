package com.bankApplication.bank.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private final String cardNumber;
    private final String cardExpiration;
    private final String cardCVV;
    @OneToOne(optional = false, mappedBy="card")
    private final User user;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "card" )
    private final List<Transaction> transactions;
}
