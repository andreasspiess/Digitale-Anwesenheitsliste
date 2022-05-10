package com.example.DigitaleAnwesenheitsliste.controller;

import com.example.DigitaleAnwesenheitsliste.domain.Role;
import com.example.DigitaleAnwesenheitsliste.domain.User;
import com.example.DigitaleAnwesenheitsliste.domain.UserBean;
import com.example.DigitaleAnwesenheitsliste.repo.RoleRepository;
import com.example.DigitaleAnwesenheitsliste.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(path = "registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userRegistration", new UserBean());

        return "registration";
    }

    @PostMapping(path = "registration")
    public String saveUser (Model model, UserBean userBean) {
        System.out.println(userBean.getPassword());
        model.addAttribute("userRegistration",  userBean);
        User user = new User();
        user.setFirst_name(userBean.getFirst_name());
        user.setLast_name(userBean.getLast_name());
        user.setEmail(userBean.getEmail());
        user.setPassword(passwordEncoder.encode(userBean.getPassword()));
        Role roleStudent = roleRepository.findByName("STUDENT");
        user.setRole(roleStudent);
        user.setEnabled(true);
        System.out.println(user);
        userRepository.save(user);

        return "registration";

    }
}
