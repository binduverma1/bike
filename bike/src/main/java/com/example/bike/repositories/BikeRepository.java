package com.example.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bike.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
