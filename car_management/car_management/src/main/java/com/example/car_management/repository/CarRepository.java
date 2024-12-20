package com.example.car_management.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.car_management.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	  @Query("SELECT c FROM Car c WHERE c.name LIKE %:name%")
	  List<Car> findByName(String name);
}