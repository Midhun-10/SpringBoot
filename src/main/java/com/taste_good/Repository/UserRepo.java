package com.taste_good.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taste_good.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
