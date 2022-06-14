package com.movieplan.models;

public class Orders {
	private int order_id;
	private String date;
	private int movie_id;
	private int user_id;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Orders() {

	}

	public Orders(int order_id, String date, int movie_id, int user_id, int quantity) {
		super();
		this.order_id = order_id;
		this.date = date;
		this.movie_id = movie_id;
		this.user_id = user_id;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", date=" + date + ", movie_id=" + movie_id + ", user_id=" + user_id
				+ ", quantity=" + quantity + "]";
	}

}
