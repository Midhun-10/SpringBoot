package com.taste_good.service;

import org.springframework.stereotype.Service;

import com.taste_good.Repository.UserRepo;
import com.taste_good.dto.LoginUser;
import com.taste_good.dto.RegisterUser;
import com.taste_good.exceptions.InvalidPasswordException;
import com.taste_good.exceptions.UserNotFoundException;
import com.taste_good.model.User;

@Service
public class UserService {
	
	final private UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public User registerUser(RegisterUser reqUser) {
		User user = new User();
		user.setName(reqUser.getUserName());
		user.setEmail(reqUser.getEmail());
		user.setPassword(reqUser.getPassword());
		
		return userRepo.save(user);
	}
	
	public User loginUser(LoginUser loginUser) {
		User user = userRepo.findByEmail(loginUser.getEmail()).orElseThrow(()->new UserNotFoundException("User not found"));
		if(!user.getPassword().equals(loginUser.getPassword())) throw new InvalidPasswordException("Password is wrong");
		return user;
	}
	
	public String deleteUser(LoginUser loginUser) {
		User user = userRepo.findByEmail(loginUser.getEmail()).orElseThrow(()->new UserNotFoundException("User not found"));
		if(!user.getPassword().equals(loginUser.getPassword())) throw new InvalidPasswordException("Password is wrong");
		userRepo.delete(user);
		return "delete successfull";
	}

}
