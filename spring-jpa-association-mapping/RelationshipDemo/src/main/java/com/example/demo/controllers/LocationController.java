package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Location;
import com.example.demo.models.User;
import com.example.demo.services.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/locations")
	public List<Location> getAllLocations() {
		return locationService.findAll();
	}
	
	@GetMapping("/locations/{id}")
	public Optional<Location> getLocationById(@PathVariable Integer id) {
		return locationService.findById(id);
	}
	
	@GetMapping("/location/{id}/users")
	public List<User> GetUsersByLocation(@PathVariable Integer id) {
		Optional<Location> location = locationService.findById(id);		
		if(location.isPresent()) {
			return location.get().getUsers();
		}		
		return null;
	}
	
	@PostMapping("/locations/addNew")
	public void AddLocation(@RequestBody Location location) {	
		locationService.AddLocation(location);
	}
	
	@PutMapping("/location/{id}/update")
	public void UpdateLocation(@RequestBody Location location) {
		locationService.UpdateLocation(location);
	}
	
}
