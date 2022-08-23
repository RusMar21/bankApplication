package com.bankApplication.bank.data;

import com.bankApplication.bank.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
