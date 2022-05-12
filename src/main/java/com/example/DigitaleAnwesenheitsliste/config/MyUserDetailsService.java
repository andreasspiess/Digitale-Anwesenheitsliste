package com.example.DigitaleAnwesenheitsliste.config;

import com.example.DigitaleAnwesenheitsliste.domain.User;
import com.example.DigitaleAnwesenheitsliste.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j

//@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("loadUserByUserName: {}", email);

        Optional<User> user = userRepository.findByEmailIs((email));
        log.debug("user optional from database: {}", user.get().getEmail());
        log.debug("test: {}", passwordEncoder.encode("test"));
        log.debug("does pw match? {}, {}, {}", "test", "$2a$10$FhE/k3zvzWmHCe1wwGTRb.Ff4Uh72h1YLoNh1HGMbp0jPWszVTWGu",
                passwordEncoder.matches("test", "$2a$10$FhE/k3zvzWmHCe1wwGTRb.Ff4Uh72h1YLoNh1HGMbp0jPWszVTWGu" ));

        if (user.isPresent()) {
            return org.springframework.security.core.userdetails.User.withUsername(user.get().getEmail())
                    .password(user.get().getPassword())
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("username " + email + " not found");
        }

        /*return userRepository.findByUsernameIs(username)
                .map(u -> org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username(u.getUsername())
                        .password(u.getPasswordEncoded())
                        .roles("USER")
                        .build()
                        .orElseThrow;
        */
    }
}
