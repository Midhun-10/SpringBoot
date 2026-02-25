package com.taste_good.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taste_good.model.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}
