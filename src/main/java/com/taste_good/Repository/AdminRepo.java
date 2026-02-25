package com.taste_good.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taste_good.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	Optional<Admin> findByEmail(String email);
	
}
