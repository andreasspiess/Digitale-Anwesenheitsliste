package com.example.DigitaleAnwesenheitsliste.Persons;

import com.example.DigitaleAnwesenheitsliste.Persons.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegisterController {

    @GetMapping("registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

}
