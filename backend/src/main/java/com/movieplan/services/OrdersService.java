package com.movieplan.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieplan.daos.OrdersDao;
import com.movieplan.models.OrderSummary;
import com.movieplan.models.Orders;
import com.movieplan.models.Users;

@Service
public class OrdersService {
	@Autowired
	private OrdersDao orderRepository;

	public OrdersService(OrdersDao orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	public boolean payment( String card_number, String expiration_date, String pin) {
		boolean success = true;
		
		
		if (!(card_number.length() == 10 && pin.length() == 4)) {
			return !success;
		}
		
		return success;
	}
	public int addOrder(Orders order) throws SQLException {
		return this.orderRepository.addOrder(order);

	}

	public List<OrderSummary> getOrderSummary(String full_name) throws SQLException {
		return this.orderRepository.getOrderSummary(full_name);
	}

	public Users getUserById(String email) throws SQLException {
		return this.orderRepository.getUserIdByEmail(email);
	}
}
