package com.bankApplication.bank.controller;

import com.bankApplication.bank.entities.Card;
import com.bankApplication.bank.entities.Transaction;
import com.bankApplication.bank.entities.User;
import com.bankApplication.bank.repositories.CardRepository;
import com.bankApplication.bank.repositories.TransactionRepository;
import com.bankApplication.bank.services.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    private UserService userService;

    private CardRepository cardRepository;

    private TransactionRepository transactionRepository;

    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userMain")
    public String showMainPage(Model model, Principal user) {
        model.addAttribute("username",user.getName());
        return "userMain";
    }

    @GetMapping("/userMain/currentUserInfo")
    public String currentUserInfo(Model model, Principal principal) {
        User user =  userService.findUserByUsername(principal.getName());
        Card card = userService.findUserCard(user.getId()).get();
        model.addAttribute("user", user);
        model.addAttribute("card", card);
        return "currentUserInfo";
    }

    @GetMapping("/userMain/transfer")
    public String transferPage() {
        return "transfer";
    }

    @PostMapping("/userMain/transfer")
    public String transferMoney(@RequestParam String recipient_card_Number, @RequestParam String sum, Principal principal) {
        User currUser = userService.findUserByUsername(principal.getName());
        Card card = userService.findUserCard(currUser.getId()).get();

        Long id_recipient = cardRepository.findByCard_Number(recipient_card_Number).get();
        Card card_recipient = cardRepository.findById(id_recipient).get();

        card_recipient.setBalance(card_recipient.getBalance() + Integer.parseInt(sum));
        card.setBalance(card.getBalance() - Integer.parseInt(sum));

        Transaction transaction = new Transaction( Integer.parseInt(sum), recipient_card_Number, card);
        List<Transaction> transactions = card.getTransactions();
        transactions.add(transaction);
        card.setTransactions(transactions);

        transactionRepository.save(transaction);
        cardRepository.save(card);
        cardRepository.save(card_recipient);

        return "transfer";
    }



}
