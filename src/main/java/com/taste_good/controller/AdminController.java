package com.taste_good.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taste_good.dto.LoginUser;
import com.taste_good.dto.RegisterUser;
import com.taste_good.model.Admin;
import com.taste_good.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody RegisterUser registerUser) {
        Admin savedAdmin = adminService.registerUser(registerUser);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> loginAdmin(@RequestBody LoginUser loginUser) {
        Admin admin = adminService.loginUser(loginUser);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
}