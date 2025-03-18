package com.carwala.controller;

import com.carwala.model.Car;
import com.carwala.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping ("/listOfCars")
    public ResponseEntity<List<Car>> getAllCars()
	{
	  List<Car> car =  carService.getAllCars();
		return new ResponseEntity<>(car,HttpStatus.OK);
	}
    @GetMapping("/getById/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addCar")
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

   @PutMapping("/updateCar/{id}")
   public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
       Car updatedCar = carService.updateCar(id, car);

       if (updatedCar != null) {
           return new ResponseEntity<>(updatedCar, HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);    }
}
