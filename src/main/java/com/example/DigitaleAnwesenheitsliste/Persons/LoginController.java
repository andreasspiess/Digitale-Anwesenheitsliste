package com.example.DigitaleAnwesenheitsliste.Persons;

import com.example.DigitaleAnwesenheitsliste.Persons.domain.Presence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/student")
    public String getStartpage(Model model) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.uuuu");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        LocalDateTime date = LocalDateTime.now();
        model.addAttribute("date", dateTimeFormatter.format(date));
        model.addAttribute("time", timeFormatter.format(date));


        return "student";
    }

    @PostMapping("/student")
    public String savePresence(Model model, Presence presence) {
        model.addAttribute("presenceToSave", presence);

        return "student";
    }

    @GetMapping("/dozent")
    public String getDozent(Model model) {

        return "dozent";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        System.out.println(passwordEncoder.encode("pass"));
        return "login";
    }
}