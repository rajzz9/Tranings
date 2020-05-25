package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.BookService;
import com.example.service.OrderService;

@SpringBootApplication
public class SpringMysqlOnetomanyApplication implements CommandLineRunner  {

	private final BookService bookService;
	private final OrderService orderService;

    public SpringMysqlOnetomanyApplication(BookService bookService, OrderService orderService) {
        this.bookService = bookService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        bookService.create();
        bookService.read();
        bookService.delete();
        
        orderService.createOrderByCustomer("Sahasra");
        
        //orderService.createOrderByCustomer("Harisha");
        //orderService.createOrderByCustomer("Jyothi");
         
        
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlOnetomanyApplication.class, args);
	}

}
