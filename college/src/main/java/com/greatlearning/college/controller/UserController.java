package com.greatlearning.college.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.college.model.User;
import com.greatlearning.college.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userservice;

	@GetMapping
	public Set<User> fetchUser() {
		return this.userservice.listUser();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") long  id) {
		return this.userservice.getuserByid(id);
	}

	@PostMapping
	public User saveuser(@RequestBody User user) {
		return this.userservice.saveUser(user);
	}
}
