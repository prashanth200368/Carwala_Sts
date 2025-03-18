package com.carwala.service;

import com.carwala.model.Car;
import com.carwala.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl extends CarService {

    @Autowired
    private CarRepository carRepository;

    // Get all cars
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Get a car by ID
    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    // Save a new car
    @Override
    public Car saveCar(Car car) {
        // You could add additional validation or logic here
        return carRepository.save(car);
    }

    // Delete a car by ID
    @Override
    public void deleteCar(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            carRepository.deleteById(id);
        } else {
            // Handle case where car is not found
            throw new RuntimeException("Car not found with id: " + id);
        }
    }
}
