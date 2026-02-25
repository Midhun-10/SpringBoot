package com.taste_good.service;

import org.springframework.stereotype.Service;

import com.taste_good.Repository.AdminRepo;
import com.taste_good.dto.LoginUser;
import com.taste_good.dto.RegisterUser;
import com.taste_good.exceptions.InvalidPasswordException;
import com.taste_good.exceptions.UserNotFoundException;
import com.taste_good.model.Admin;

@Service
public class AdminService {
	
	private final AdminRepo adminRepo;
	
	public AdminService(AdminRepo adminRepo) {
		this.adminRepo = adminRepo;
	}
	
	public Admin registerUser(RegisterUser reqUser) {
		Admin admin = new Admin();
		admin.setName(reqUser.getUserName());
		admin.setEmail(reqUser.getEmail());
		admin.setPassword(reqUser.getPassword());
		
		return adminRepo.save(admin);
	}
	
	public Admin loginUser(LoginUser loginUser) {
		Admin admin = adminRepo.findByEmail(loginUser.getEmail()).orElseThrow(()->new UserNotFoundException("Admin not found"));
		if(!admin.getPassword().equals(loginUser.getPassword())) throw new InvalidPasswordException("Password is wrong");
		return admin;
	}
	
}
