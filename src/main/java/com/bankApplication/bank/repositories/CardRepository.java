package com.bankApplication.bank.repositories;

import com.bankApplication.bank.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findById(Long user_id);

    @Query(nativeQuery = true, value = "SELECT user_id FROM Card WHERE card_number = :card_Number")
    Optional<Long> findByCard_Number(@Param("card_Number") String card_Number);
}
