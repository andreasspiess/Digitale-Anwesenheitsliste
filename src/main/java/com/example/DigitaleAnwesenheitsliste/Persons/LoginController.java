package com.example.DigitaleAnwesenheitsliste.Persons;

import com.example.DigitaleAnwesenheitsliste.Persons.repository.DozentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    DozentRepo dozentRepo;


    @GetMapping("/student")
    public String getStartpage() {

        return "student";
    }

    @PostMapping("/student")
    public String savePresence(Model model,Presence presence) {
        model.addAttribute("presence", presence);

        return "student";
    }

    @GetMapping("/dozent")
    public String getDozent(Model model) {

        return "dozent";
    }

    @PostMapping("/dozent")
    public String saveDozent(Model model, Dozent dozent) {

        return "dozent";
    }
}