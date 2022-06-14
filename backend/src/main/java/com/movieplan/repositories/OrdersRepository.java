package com.movieplan.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movieplan.daos.OrdersDao;
import com.movieplan.models.OrderSummary;
import com.movieplan.models.Orders;
import com.movieplan.models.Users;

@Repository
public class OrdersRepository implements OrdersDao {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int addOrder(Orders order) {
		return jdbc.update("insert into orders(date, user_id, movie_id, quantity)values(?,?,?,?)",
				new Object[] { order.getDate(), order.getUser_id(), order.getMovie_id(), order.getQuantity() });

	}

	@Override
	public List<OrderSummary> getOrderSummary(String full_name) {
		return jdbc.query("SELECT *, (quantity * ticket_price)  AS total from booking_summary where email =?",
				BeanPropertyRowMapper.newInstance(OrderSummary.class), full_name);

	}

	@Override
	public Users getUserIdByEmail(String email) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("SELECT user_id from users where email =?",
				BeanPropertyRowMapper.newInstance(Users.class), email);
	}
}
