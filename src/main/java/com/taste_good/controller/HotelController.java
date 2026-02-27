package com.taste_good.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.taste_good.model.Hotel;
import com.taste_good.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @GetMapping("/all")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Integer id) {
        return hotelService.getHotelById(id);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Integer id,
                             @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Integer id) {
        hotelService.deleteHotel(id);
        return "Hotel deleted successfully";
    }
}