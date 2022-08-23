package com.bankApplication.bank;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User_info")
@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private final String username;
    private final String password;
    private final String fullname;
    @OneToOne(optional = false)
    @JoinColumn(name="card_id", unique = true)
    private Card card;

}
