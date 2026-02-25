package com.taste_good.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taste_good.model.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {

}
