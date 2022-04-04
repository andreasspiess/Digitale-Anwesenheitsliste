package com.example.DigitaleAnwesenheitsliste.Persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin();
        http
                .authorizeRequests().antMatchers("/h2-console/**", "/", "/login", "/css/**", "/img/**", "/images/**", "/noSecurity")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
    }

/*    @Bean
    public UserDetailsService users(@Autowired PasswordEncoder pwEnc) {
        UserDetails user = User.builder()
                .username("Andi")
                .password(pwEnc.encode("top"))
                .roles("Andi")
                .build();

        UserDetails dozent = User.builder()
                .username("Julius")
                .password(pwEnc.encode("secret"))
                .roles("Andi", "Julius")
                .build();
        return new InMemoryUserDetailsManager(user, dozent);
    }
 */

}