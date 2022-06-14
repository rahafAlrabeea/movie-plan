package com.movieplan.models;

public class Genres {
	private int genre_id;
	private String genre;

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Genres(int genre_id, String genre) {
		super();
		this.genre_id = genre_id;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Genres [genre_id=" + genre_id + ", genre=" + genre + "]";
	}

	public Genres() {

	}
}
