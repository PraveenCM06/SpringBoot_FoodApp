package com.org.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.foodapp.dto.User;
import com.org.foodapp.response.ResponseStructure;
import com.org.foodapp.service.UserService;

@RestController
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path= "/insertUser")
	public ResponseEntity<?> insertUser(@RequestBody User user){
		ResponseStructure<?> responseStructure = userService.insertUser(user);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
	
	@GetMapping(path= "/getAllUsers")
	public ResponseEntity<?> getAllUsers(){
		ResponseStructure<?> responseStructure = userService.getAllUsers();
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
	
	/*Using @RequestParam*/
	@GetMapping(path="/getUserById")
	public ResponseEntity<?> getUserById(@RequestParam Integer id){
		ResponseStructure<?> responseStructure = userService.getUserById(id);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
	
	/*Using @PathVariable*/
	@GetMapping(path= "/getUserById/{id}")
	public ResponseEntity<?> getUserById2(@PathVariable Integer id){
		ResponseStructure<?> responseStructure= userService.getUserById(id);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
	
	@GetMapping(path= "/getUserByEmail")
	public ResponseEntity<?> findUserByEmail(@RequestParam String email, @RequestParam String password){
		ResponseStructure<User> responseStructure = userService.getUserByEmail(email, password);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
		
	@PutMapping(path = "/putMapping")
	public ResponseEntity<?> putMapping(@RequestBody User user){
		ResponseStructure<?> responseStructure = userService.updateUser(user);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
	
	@PatchMapping(path = "/patchMapping/{userPassword}")
	public ResponseEntity<?> patchMapping(@RequestParam int id,@PathVariable String userPassword){
		ResponseStructure<?> responseStructure = userService.patchUpdateUser(id, userPassword);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
	
	@DeleteMapping(path ="/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable int userId){
		ResponseStructure<?> responseStructure = userService.deleteUser(userId);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}
	
	
}
