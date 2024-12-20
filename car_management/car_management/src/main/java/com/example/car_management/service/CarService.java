package com.example.car_management.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.car_management.entity.Car;
import com.example.car_management.repository.CarRepository;
@Service
public class CarService {
    
    @Autowired
    private CarRepository repo;
    
    public List<Car> listAll() {
        return repo.findAll();
    }
     
    public void save(Car car) {
        repo.save(car);
    }
     
    public Car get(long id) {
        return repo.findById(id).get();
        
    }
    public List<Car> searchByName(String name) {
        return repo.findByName(name);
    }

     
    public void delete(long id) {
        repo.deleteById(id);
    }
}