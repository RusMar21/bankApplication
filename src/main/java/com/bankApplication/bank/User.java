package com.bankApplication.bank;

import lombok.Data;

@Data
public class User {

    private final Long id;
    private final String username;
    private final String password;
    private final String fullname;

}
