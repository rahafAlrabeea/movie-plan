package com.movieplan.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieplan.models.Movies;
import com.movieplan.models.OrderSummary;
import com.movieplan.models.Orders;
import com.movieplan.models.Users;
import com.movieplan.services.MoviesService;
import com.movieplan.services.OrdersService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	JdbcTemplate jdbc;

	public OrdersController() {

	}

	public OrdersController(OrdersService ordersService) {
		super();
		this.ordersService = ordersService;
	}

	@GetMapping("/pay")
	public String pay( @RequestParam("card_number") String card_number,
			@RequestParam("expiration_date") String expiration_date, @RequestParam("pin") String pin) {
		String paymentResponse = null;

		boolean paymentSuccess = ordersService.payment( card_number, expiration_date, pin);
		if (paymentSuccess) {

			paymentResponse = "paid successfully..";
		} else {

			paymentResponse = "Incorrect card number or pin..";
		}
		return paymentResponse;
	}

	@PostMapping("/add")
	public String addOrder(@RequestBody Orders order) throws SQLException {
		ordersService.addOrder(order);
		return "Order has been created";
	}

	@GetMapping("/view/{full_name}")
	public List<OrderSummary> viewOrderSummary(@PathVariable("full_name") String full_name) throws SQLException {

		return ordersService.getOrderSummary(full_name);
	}
	

}
