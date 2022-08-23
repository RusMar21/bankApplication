package com.bankApplication.bank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("userMain")
public class MainController {

    @GetMapping
    public String showMainPage() {
        return "userMain";
    }

}
