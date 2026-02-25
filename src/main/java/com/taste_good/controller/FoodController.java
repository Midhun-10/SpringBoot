package com.taste_good.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taste_good.model.Food;
import com.taste_good.service.FoodService;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/add/{hotelId}")
    public ResponseEntity<Food> addFood(@PathVariable Integer hotelId, @RequestBody Food food) {
        Food savedFood = foodService.addFood(hotelId, food);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.getAllFoods();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Integer id) {
        Food food = foodService.getFoodById(id);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Integer id, @RequestBody Food food) {
        Food updatedFood = foodService.updateFood(id, food);
        return new ResponseEntity<>(updatedFood, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Integer id) {
        foodService.deleteFood(id);
        return new ResponseEntity<>("Food deleted successfully", HttpStatus.OK);
    }
}