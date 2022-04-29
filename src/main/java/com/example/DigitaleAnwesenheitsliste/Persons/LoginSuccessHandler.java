package com.example.DigitaleAnwesenheitsliste.Persons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DigitaleAnwesenheitsliste.Persons.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String redirectURL = request.getContextPath();

        if (userDetails.hasRole("USER")) {
            redirectURL = "umschuler";
        } else if (userDetails.hasRole("CREATOR")) {
            redirectURL = "dozent";
        } else if (userDetails.hasRole("EDITOR")) {
            redirectURL = "index";
        } else if (userDetails.hasRole("ADMIN")) {
            redirectURL = "users";
        }

        response.sendRedirect(redirectURL);

    }

}