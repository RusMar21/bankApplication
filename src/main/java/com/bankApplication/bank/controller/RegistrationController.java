package com.bankApplication.bank.controller;

import com.bankApplication.bank.entities.Card;
import com.bankApplication.bank.entities.Role;
import com.bankApplication.bank.entities.User;
import com.bankApplication.bank.repositories.CardRepository;
import com.bankApplication.bank.repositories.RoleRepository;
import com.bankApplication.bank.repositories.UserRepository;
import com.bankApplication.bank.security.RegistrationForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserRepository userRepository;

    private CardRepository cardRepository;

    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;

    public RegistrationController(UserRepository userRepository, CardRepository cardRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        User user = form.toUser(passwordEncoder);
        Card card = form.toCard();
        card.setUser(user);
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        cardRepository.save(card);
        return "redirect:/login";
    }
}
