package com.example.DigitaleAnwesenheitsliste;


import com.example.DigitaleAnwesenheitsliste.Persons.DigitaleAnwesenheitslisteApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = DigitaleAnwesenheitslisteApplication.class)
class DigitaleAnwesenheitslisteApplicationTests {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	}


}
