package com.example.DigitaleAnwesenheitsliste.controller;

import com.example.DigitaleAnwesenheitsliste.domain.Presence;
import com.example.DigitaleAnwesenheitsliste.domain.User;
import com.example.DigitaleAnwesenheitsliste.repo.PresenceRepository;
import com.example.DigitaleAnwesenheitsliste.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PresenceRepository presenceRepository;

    @GetMapping("/student")
    public String getStartpage(Model model, Principal principal) {
        System.out.println(principal.getName());

        Optional<User> loggedUser = userRepository.findByEmailIs(principal.getName());
        model.addAttribute("fullName", loggedUser.get().getFirst_name() + " " + loggedUser.get().getLast_name());
        model.addAttribute("id", loggedUser.get().getId());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.uuuu");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        LocalDateTime date = LocalDateTime.now();
        model.addAttribute("date", dateTimeFormatter.format(date));
        model.addAttribute("time", timeFormatter.format(LocalTime.now()));
        Presence presence = new Presence();

        model.addAttribute("presenceToSave", presence);
        return "student";
    }

    @PostMapping("/student")
    public String savePresence(Model model, Principal principal) {
        Presence presence = new Presence();
        Optional<User> loggedUser = userRepository.findByEmailIs(principal.getName());
        model.addAttribute("fullName", loggedUser.get().getFirst_name() + " " + loggedUser.get().getLast_name());
        model.addAttribute("id", loggedUser.get().getId());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.uuuu");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        presence.setUser(loggedUser.get());
        presence.setDate(LocalDateTime.now());
        presenceRepository.save(presence);

        model.addAttribute("presenceToSave", presence);

        return "student-confirmation";
    }

    @GetMapping("/dozent")
    public String getDozent(Model model) {

        return "dozent";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "login";
    }

    @GetMapping("/student-confirmation")
    public String getStudentConfirmation()  {

        return "student-confirmation";
    }

    @PostMapping("/student-confirmation")
    public String showLoginPage() {

        return "/login";
    }
}
