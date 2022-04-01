package com.example.DigitaleAnwesenheitsliste.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getStartpage() {

        return "startpage";
    }
}