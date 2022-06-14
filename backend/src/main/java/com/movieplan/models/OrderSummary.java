package com.movieplan.models;

public class OrderSummary {
	private String full_name;
	private String email;
	private String name;
	private String timings;
	private int quantity;
	private double ticket_price;
	private String total;

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public OrderSummary() {

	}

	public OrderSummary(String full_name, String email, String name, String timings, int quantity, double ticket_price,
			String total) {
		super();
		this.full_name = full_name;
		this.email = email;
		this.name = name;
		this.timings = timings;
		this.quantity = quantity;
		this.ticket_price = ticket_price;
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderSummary [full_name=" + full_name + ", email=" + email + ", name=" + name + ", timings=" + timings
				+ ", quantity=" + quantity + ", ticket_price=" + ticket_price + ", total=" + total + "]";
	}

}
