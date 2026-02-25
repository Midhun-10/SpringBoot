package com.taste_good.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taste_good.Repository.FoodRepo;
import com.taste_good.Repository.HotelRepo;
import com.taste_good.exceptions.HotelNotFoundException;
import com.taste_good.model.Food;
import com.taste_good.model.Hotel;

@Service
public class FoodService {

    private final FoodRepo foodRepo;
    private final HotelRepo hotelRepo;

    public FoodService(FoodRepo foodRepo, HotelRepo hotelRepo) {
        this.foodRepo = foodRepo;
        this.hotelRepo = hotelRepo;
    }

    public Food addFood(Integer hotelId, Food food) {
        Hotel hotel = hotelRepo.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found with id: " + hotelId));
        food.setHotel(hotel);
        return foodRepo.save(food);
    }

    public List<Food> getAllFoods() {
        return foodRepo.findAll();
    }

    public Food getFoodById(Integer id) {
        return foodRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
    }

    public Food updateFood(Integer id, Food updatedFood) {
        Food existingFood = getFoodById(id);
        existingFood.setFoodName(updatedFood.getFoodName());
        existingFood.setImg(updatedFood.getImg());
        existingFood.setPrice(updatedFood.getPrice());
        return foodRepo.save(existingFood);
    }

    public void deleteFood(Integer id) {
        Food food = getFoodById(id);
        foodRepo.delete(food);
    }
}