package com.org.foodapp.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.org.foodapp.dao.UserDao;
import com.org.foodapp.dto.User;
import com.org.foodapp.response.ResponseStructure;
import com.org.foodapp.service.UserService;

@Service
public class service_Implementation implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public ResponseStructure<?> insertUser(User user) {
		User userInsert= userDao.insertUser(user);
		ResponseStructure<User> responseStructure= new ResponseStructure<>();
		responseStructure.setData(userInsert);
		responseStructure.setHttpStatus(HttpStatus.CREATED);
		responseStructure.setMessage("Account Created Successfully");
		return responseStructure;
	}

	@Override
	public ResponseStructure<?> getAllUsers() {
		List<User> getAllUsers = userDao.getAllUsers();
		ResponseStructure<List<User>> responseStructure =new ResponseStructure<>();
		responseStructure.setData(getAllUsers);
		responseStructure.setHttpStatus(HttpStatus.FOUND);
		responseStructure.setMessage("Found list of Users");
		return responseStructure;
	}

	@Override
	public ResponseStructure<?> getUserById(int id) {
		Optional<User> getUserById = userDao.getUserById(id);
		
		ResponseStructure<User> responseStructure= new ResponseStructure<>();
		User userDetails= getUserById.get();
		responseStructure.setData(userDetails);
		responseStructure.setHttpStatus(HttpStatus.FOUND);
		responseStructure.setMessage("User Found");
		return responseStructure;
	}

	@Override
	public ResponseStructure<?> updateUser(User user) {
		User updateuser= userDao.updateUser(user);
		
		ResponseStructure<User> responseStructure= new ResponseStructure<>();
		responseStructure.setData(updateuser);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("Updated Successfully");
		return responseStructure;
	}

	@Override
	public ResponseStructure<?> patchUpdateUser(int id, String userPassword) {
		User patchUpdate = userDao.patchUpdateUser(id, userPassword);
		
		ResponseStructure<User> responseStructure= new ResponseStructure<>();
		responseStructure.setData(patchUpdate);
		responseStructure.setHttpStatus(HttpStatus.FOUND);
		responseStructure.setMessage("User Updated");
		return responseStructure;
	}

	@Override
	public ResponseStructure<User> getUserByEmail(String email, String password) {
		User user= userDao.getUserByEmail(email);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setData(userDao.getUserByEmail(email));
		responseStructure.setHttpStatus(HttpStatus.FOUND);
		responseStructure.setMessage("User Found");
		return responseStructure;
	}

	@Override
	public ResponseStructure<?> deleteUser(int userId) {
		User user= userDao.deleteUser(userId);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setData(user);
		responseStructure.setHttpStatus(HttpStatus.ACCEPTED);
		responseStructure.setMessage("Data Deleted Successfully");
		return responseStructure;
	}
	
	
}