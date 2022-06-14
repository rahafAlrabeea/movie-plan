package com.movieplan.daos;

import java.sql.SQLException;
import java.util.List;

import com.movieplan.models.OrderSummary;
import com.movieplan.models.Orders;
import com.movieplan.models.Users;

public interface OrdersDao {
	int addOrder(Orders order);

	List<OrderSummary> getOrderSummary(String full_name) throws SQLException;
	Users getUserIdByEmail(String email);
	

}
