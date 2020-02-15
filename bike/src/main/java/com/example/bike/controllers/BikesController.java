package com.example.bike.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bike.models.Bike;
import com.example.bike.repositories.BikeRepository;
//annotation necessary for MVC controllers
@RestController
@RequestMapping("/api/v1/bikes")

public class BikesController {
	@Autowired
	private BikeRepository bikeRepository;
	
	@GetMapping
	public List<Bike> list(){ 		
		return bikeRepository.findAll();
	}
	
	//create method to handle registration information when user submits information via form. void method do not return 
	// create method will need @PostMapping for saving bike info the response status is simply going to be an ok we are cusmozing the response method with ok 
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {
		//to save bike info from from to db
		bikeRepository.save(bike);
		
	}
	// Bike method to get bike info based on id passed as parameter, Bike method will need @GetMapping with parameter of id
	@GetMapping("/{id")
	
	public Bike get(@PathVariable("id")long id) {
		// we are passing the id from the end point to getOne method to find that bike id info.
		return bikeRepository.getOne(id);
	}
	
	
}
