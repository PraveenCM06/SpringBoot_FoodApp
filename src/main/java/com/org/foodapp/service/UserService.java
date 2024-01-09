package com.org.foodapp.service;

import org.springframework.http.ResponseEntity;

import com.org.foodapp.dto.User;
import com.org.foodapp.response.ResponseStructure;

public interface UserService {
	
	public ResponseStructure<?> insertUser(User user);

	public ResponseStructure<?> getAllUsers();

	public ResponseStructure<?> getUserById(int id);

	public ResponseStructure<?> updateUser(User user);

	public ResponseStructure<?> patchUpdateUser(int id, String userPassword);

	public ResponseStructure<User> getUserByEmail(String email, String password);

	public ResponseStructure<?> deleteUser(int userId);
}
