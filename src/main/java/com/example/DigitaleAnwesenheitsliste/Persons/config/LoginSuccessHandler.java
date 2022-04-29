package com.example.DigitaleAnwesenheitsliste.Persons.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DigitaleAnwesenheitsliste.Persons.config.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

        String redirectURL = request.getContextPath();

        if (userDetails.hasRole("USER")) {
            redirectURL = "umschuler";
        } else if (userDetails.hasRole("DOZENT")) {
            redirectURL = "dozent";

            response.sendRedirect(redirectURL);

        }
    }
}