package com.carwala.repository;

import com.carwala.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository< Car, Long> {
    // Custom query methods can be added here if needed
}
