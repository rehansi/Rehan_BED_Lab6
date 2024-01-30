package com.greatlearning.college.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.college.dao.UserRepository;
import com.greatlearning.college.model.Roles;
import com.greatlearning.college.model.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootStrapData {

	private final UserRepository repo;

	private final PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional // if we dont write this we will face save the transient error
	public void bootStrapUserData(ApplicationReadyEvent event) {

		String encodedPassword = passwordEncoder.encode("welcome");

		User Kiran = User.builder().email("Kiran@Gmail.com").name("Kiran").password(encodedPassword).build();
		User Rehan = User.builder().email("Rehan@Gmail.com").name("Rehan").password(encodedPassword).build();

		Roles user = Roles.builder().RoleName("Role_User").build();
		Roles admin = Roles.builder().RoleName("Role_Admin").build();

		Kiran.addrole(user);
		Rehan.addrole(admin);

		repo.save(Rehan);
		repo.save(Kiran);

	}
}