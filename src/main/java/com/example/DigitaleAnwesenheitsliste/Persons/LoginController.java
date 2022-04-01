package com.example.DigitaleAnwesenheitsliste.Persons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getStartpage() {

        return "login";
    }


}