package com.greatlearning.college.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecutrityApplicationSecurity {

	private final UserDetailsService userDetailService;

	@Bean
	PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	// authorization
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.requestMatchers("/h2-console**", "/login**", "/logout", "/actutator")
				.permitAll().requestMatchers(HttpMethod.GET, "/student**").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.POST, "/student**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/student**").hasRole("ADMIN").anyRequest().fullyAuthenticated())
				
		.formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
						.permitAll())
			
				.exceptionHandling(customizer -> customizer.accessDeniedPage("/access-denied"))
				.logout(logout -> logout.permitAll());
		http.cors(cors -> cors.disable());
		http.csrf(csrf -> csrf.disable());
		http.httpBasic(Customizer.withDefaults());

		return http.build();
	}

	//// this is how we tie our spring application and spring security
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
		authprovider.setPasswordEncoder(passwordEncoder());
		authprovider.setUserDetailsService(this.userDetailService);

		return authprovider;
	}
}
