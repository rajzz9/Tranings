package com.example.studentservice.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.studentservice.model.Marks;

@Component
public class RestConnector {
	@Autowired
	private DiscoveryClient discoveryclient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	public Marks getMarks(int id) {
		/*
		 * String baseUrl = "http://localhost:8085"; String resultsUrl = baseUrl +
		 * "/results/" + id; RestTemplate restTemplate = new RestTemplate(); Map<String,
		 * Integer> marks = (Map) restTemplate.getForObject(resultsUrl, Object.class);
		 * return new Marks(marks.get("language"), marks.get("math"), marks.get("art"));
		 */
		//List<ServiceInstance> serviceInstances = discoveryclient.getInstances("results-service");
		//String baseUrl = serviceInstances.get(0).getUri().toString();
		//String resultsUrl = baseUrl + "/results/" + id;
		
		ServiceInstance serviceInstance = loadBalancerClient.choose("results-service");
		String resultsUrl = serviceInstance.getUri().toString() + "/results/" + id;
		System.out.println("Vardhan:: "+ resultsUrl);
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Integer> marks = (Map) restTemplate.getForObject(resultsUrl, Object.class);
		return new Marks(marks.get("language"), marks.get("math"), marks.get("art"));
	}
}
