package com.bankApplication.bank.data;

import com.bankApplication.bank.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
