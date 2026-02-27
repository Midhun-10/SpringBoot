package com.taste_good.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Transient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Food {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer fid;
	private String foodName;
	private String img;
	private double price;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	@JsonIgnore
	private Hotel hotel;

	@Transient
	public String getHotelName() {
	    return hotel != null ? hotel.getHotelName() : null;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
