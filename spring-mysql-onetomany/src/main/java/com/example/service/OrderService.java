package com.example.service;

import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.CustomerOrder;
import com.example.entity.Orderlines;
import com.example.repository.OrderRepository;
import com.example.repository.OrderlinesRepository;
import com.example.repository.ProductRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final OrderlinesRepository orderlinesRepository;
	private final ProductRepository productRepository;
	
	public OrderService(OrderRepository orderRepository, OrderlinesRepository orderlinesRepository, ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.orderlinesRepository = orderlinesRepository;
		this.productRepository = productRepository;
	}
	
	public void createOrderByCustomer(String customerName) {
		CustomerOrder order = new CustomerOrder();
		
		order.setCustomerName(customerName);
		//order.setAddress("Hyderabad");
		//order.setPhoneNumber("8886119977");
		
		IntStream.range(1, 4).forEach(index -> {
			Orderlines orderlines = new Orderlines();
	
			orderlines.setQty(index);
			orderlines.setAmount(index * 100d);
			orderlines.setOrder(order);
		});
		
		orderRepository.saveAndFlush(order);
		
	}
	
	public void displayOrderInfoByLineId(int id) {
		Optional<Orderlines> orderlinesOl = orderlinesRepository.findById(id);
		
		System.out.println("Customer Order Information:::: " + orderlinesOl);
	}
	
	
}
