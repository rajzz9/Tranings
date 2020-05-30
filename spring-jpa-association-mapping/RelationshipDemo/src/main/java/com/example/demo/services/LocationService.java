package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Location;
import com.example.demo.models.repositories.LocationRepository;

@Service
public class LocationService {
	 
	@Autowired
	private LocationRepository locationRepository;

	public List<Location> findAll() {
		return (List<Location>) locationRepository.findAll();
	}

	public Optional<Location> findById(Integer id) {
		return locationRepository.findById(id);
	}

	public void AddLocation(Location location) {
		locationRepository.save(location);
	}
	
	public void UpdateLocation(Location location) {
		locationRepository.save(location);
	}
	
}
