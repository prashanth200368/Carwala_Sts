package com.carwala.service;

import com.carwala.model.Car;
import com.carwala.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
    public Car updateCar(Long id, Car updatedCar) {
        Optional<Car> existingCarOpt = carRepository.findById(id);
        
        if (existingCarOpt.isPresent()) {
            Car existingCar = existingCarOpt.get();
            
            if (updatedCar.getName() != null) {
                existingCar.setName(updatedCar.getName());
            } else {
                existingCar.setName(existingCar.getName());
            }
            
            if (updatedCar.getBrand() != null) {
                existingCar.setBrand(updatedCar.getBrand());
            } else {
                existingCar.setBrand(existingCar.getBrand()); 
            }
            
            if (updatedCar.getPrice() != 0.0) {
                existingCar.setPrice(updatedCar.getPrice());
            } else {
                existingCar.setPrice(existingCar.getPrice()); 
            }
            
            if (updatedCar.getMfgYear() != 0) {
                existingCar.setMfgYear(updatedCar.getMfgYear());
            } else {
                existingCar.setMfgYear(existingCar.getMfgYear()); }

            return carRepository.save(existingCar);
        } else {
            return null;
        }
    }
}