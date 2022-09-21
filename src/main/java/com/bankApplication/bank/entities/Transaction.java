package com.bankApplication.bank.entities;

import com.bankApplication.bank.entities.Card;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Transaction_table")
@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final Integer sum;
    private final Date time_of_Transaction = new Date();
    private final String recipient_card_number;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private final Card card;

}
