package com.org.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.foodapp.dto.User;
import com.org.foodapp.exception.CustomerIdNotFoundException;
import com.org.foodapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(int id) {
		Optional<User> find = userRepository.findById(id);
		if(find.isPresent()) {
			return find;
		}
		else {
			throw new CustomerIdNotFoundException("Customer ID not found");
		}
	}

	public User updateUser(User user) {
		Optional<User> findId=  userRepository.findById(user.getUserId());
		if(findId.isPresent()) {
			return userRepository.save(user);
		}
		else {
			throw new CustomerIdNotFoundException("Could not find ID");
		}
	}

	public User patchUpdateUser(int id, String userPassword) {
		Optional<User> patch = userRepository.findById(id);
		
		if(patch.isPresent()) {
			User user= patch.get();
			user.setUserPassword(userPassword);
			return userRepository.save(user);
		}
		else {
			throw new CustomerIdNotFoundException("User Id Not found");
		}
	}

	public User getUserByEmail(String email) {
		User userEmail= userRepository.findByUserEmail(email);
		if(userEmail!=null) {
			return userEmail;
		}
		else {
			throw new CustomerIdNotFoundException("User Not Found");
		}
	}

	public User deleteUser(int userId) {
		Optional<User> deleteUser= userRepository.findById(userId);
		if(deleteUser.isPresent()) {
			userRepository.deleteById(userId);
			return deleteUser.get();
		}
		else {
			throw new CustomerIdNotFoundException("ID not Found");
		}
	}


}
