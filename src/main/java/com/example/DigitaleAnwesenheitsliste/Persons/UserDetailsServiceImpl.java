package com.example.DigitaleAnwesenheitsliste.Persons;

import com.example.DigitaleAnwesenheitsliste.Persons.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository personRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional <User> user = personRepo.findByEmail(email);
        if (user.isPresent()){
            return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                    .username(user.get().getUsername())
                    .password(user.get().getPassword()) //TODO: !!!
                    .roles("DOZENT")
                    .build();
        } else {
            throw new UsernameNotFoundException("username" + email + " not found");
        }
    }
}
