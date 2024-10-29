package com.example.Shops.Controllers;

import com.example.Shops.Models.Users;
import com.example.Shops.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    private UsersService userService;

    @PostMapping("/signup/customer")
    public String signupCustomer(@RequestParam String username, @RequestParam String password) {
        return userService.signupCustomer(username, password);
    }

    @PostMapping("/signup/admin")
    public String signupAdmin(@RequestParam String username, @RequestParam String password) {
        return userService.signupAdmin(username, password);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Users user = userService.login(username, password);
        if (user != null) {
            return "Login successful :) Welcome" + user.getUsername();
        }
        return "Invalid username or password.";
    }
}
