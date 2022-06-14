package com.movieplan.models;

public class Movies {
	private int movie_id;
	private String name;
	private String language;
	private String description;
	private String genre;
	private String timings;
	private double ticket_price;
	private int ratings;

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public double getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}

	public Movies() {

	}

	public Movies(int movie_id, String name, String language, String description, String genre, String timings,
			double ticket_price, int ratings) {
		super();
		this.movie_id = movie_id;
		this.name = name;
		this.language = language;
		this.description = description;
		this.genre = genre;
		this.timings = timings;
		this.ticket_price = ticket_price;
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "Movies [movie_id=" + movie_id + ", name=" + name + ", language=" + language + ", description="
				+ description + ", genre=" + genre + ", timings=" + timings + ", ticket_price=" + ticket_price
				+ ", ratings=" + ratings + "]";
	}

}
