package com.greatlearning.college.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.college.dao.UserRepository;
import com.greatlearning.college.model.DomainUserDetails;
import com.greatlearning.college.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DomainUserDetailService implements UserDetailsService {
	// this is like a bridge/adapter
	/*
	 * the input will be username output will be user details check the username in
	 * the database fetch the user covert the user to the format that spring
	 * security can understand and return the userdetails
	 * 
	 */

	private final UserRepository userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userrepo.findByName(username)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user id is passed"));
		return new DomainUserDetails(user); 
	}

}
