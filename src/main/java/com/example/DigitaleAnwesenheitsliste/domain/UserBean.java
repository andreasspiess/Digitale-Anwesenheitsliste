package com.example.DigitaleAnwesenheitsliste.domain;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {

    @NotEmpty
    private String first_name;

    @NotEmpty
    private String last_name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String matchingPassword;

}
