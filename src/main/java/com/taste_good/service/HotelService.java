package com.taste_good.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taste_good.Repository.HotelRepo;
import com.taste_good.exceptions.HotelNotFoundException;
import com.taste_good.model.Hotel;

@Service
public class HotelService {

    private final HotelRepo hotelRepo;

    public HotelService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    public Hotel getHotelById(Integer id) {
        return hotelRepo.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found with id: " + id));
    }

    public Hotel updateHotel(Integer id, Hotel updatedHotel) {
        Hotel existingHotel = getHotelById(id);

        existingHotel.setHotelName(updatedHotel.getHotelName());
        existingHotel.setLocation(updatedHotel.getLocation());

        return hotelRepo.save(existingHotel);
    }

    public void deleteHotel(Integer id) {
        Hotel hotel = getHotelById(id);
        hotelRepo.delete(hotel);
    }
}