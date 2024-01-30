package com.greatlearning.college.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.greatlearning.college.dao.UserRepository;
import com.greatlearning.college.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userrepo;

	public Set<User> listUser() {
		return Set.copyOf(userrepo.findAll());
	}

	public User getuserByid(long id) {
		return userrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user"));
	}

	public User saveUser(User user) {
		return this.userrepo.save(user);

	}
}
