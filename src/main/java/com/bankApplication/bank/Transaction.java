package com.bankApplication.bank;

import lombok.*;
import org.hibernate.annotations.TypeDefs;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private final Type type;
    private final Integer sum;
    private Date timeOfTransaction = new Date();
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card card;

    private enum Type {
        SENDING, RECEIVING
    }
}
