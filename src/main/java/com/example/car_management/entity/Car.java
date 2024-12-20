package com.example.car_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String model;

    @Min(1886)
    @Max(2024)
    @Column(name = "car_year", nullable = false)
    private int year;

    

	@Positive
    private double price;

    @NotBlank
    private String color;

    @NotBlank
    private String fuelType;
    

	public Car(Long id, @NotBlank String name, @NotBlank String model, @Min(1886) @Max(2024) int year,
			@Positive double price, @NotBlank String color, @NotBlank String fuelType) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.year = year;
		this.price = price;
		this.color = color;
		this.fuelType = fuelType;
	}


	public Car() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", model=" + model + ", year=" +year + ", price=" + price
				+ ", color=" + color + ", fuelType=" + fuelType + "]";
	}
    // Getters and Setters
}
