package com.bankApplication.bank.security;

import com.bankApplication.bank.entities.Card;
import com.bankApplication.bank.entities.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private final String username;

    private final String password;

    private final String fullname;

    private final String card_Number;

    private final String card_Expiration;

    private final String card_CVV;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname);
    }

    public Card toCard() {
        return new Card(card_Number, card_Expiration, card_CVV);
    }
}
