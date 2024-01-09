package com.org.foodapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.foodapp.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserEmail(String email);
}
