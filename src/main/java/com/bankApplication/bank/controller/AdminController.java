package com.bankApplication.bank.controller;

import com.bankApplication.bank.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("admin/usersInfo")
    public String usersInfo(Model model) {

        model.addAttribute("allUsers", userService.allUsers());
        return "usersInfo";
    }

    @PostMapping("admin/usersInfo")
    public String deleteUser(@RequestParam Long userId,
        @RequestParam String action, Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        model.addAttribute("allUsers", userService.allUsers());

        return usersInfo(model);
    }

    @GetMapping("admin/userSearch")
    public String userSearchPage() {
        return "userSearch";
    }


}
