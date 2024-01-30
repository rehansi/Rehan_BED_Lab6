package com.greatlearning.college.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.college.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByName(String Name);
}
