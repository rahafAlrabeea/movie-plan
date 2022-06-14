package com.movieplan.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.movieplan.models.Genres;
import com.movieplan.models.Movies;
import com.movieplan.services.MoviesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/movies")
public class MoviesController {
	@Autowired
	private MoviesService movieService;
	@Autowired
	JdbcTemplate jdbc;

	public MoviesController() {

	}

	public MoviesController(MoviesService movieService) {
		super();
		this.movieService = movieService;
	}
	@GetMapping("/{movie_id}")
	public Movies findProductById(@PathVariable("movie_id") int movie_id) throws SQLException {

		return movieService.getMovieById(movie_id);
	}
	@GetMapping("/view")
	public List<Movies> getAllMovies() throws SQLException {

		return movieService.getAllMovies();
	}
	@GetMapping("/search")
	public List<Movies> findProductByName(@RequestParam("keyword") String keyword) throws SQLException {

		return movieService.getProductByName(keyword);
	}

	@GetMapping("/sort/ratings")
	public List<Movies> SortMoviesbyRatings() throws SQLException {

		return movieService.sortMoviesByratings();
	}

	@GetMapping("/sort/genre")
	public List<Movies> SortMoviesbyGenre() throws SQLException {

		return movieService.sortMoviesByGenre();
	}

	@GetMapping("/sort/price")
	public List<Movies> SortMoviesbyPrice() throws SQLException {

		return movieService.sortMoviesByprice();
	}

	@PostMapping("/add")
	public String addGenre(@RequestBody Genres genre) throws SQLException {
		movieService.addGenre(genre);
		return "Genre has been created";
	}

	@DeleteMapping("/delete/{genre_id}")
	public String deleteGenre(@PathVariable("genre_id") int genre_id) throws SQLException {
		movieService.deleteGenre(genre_id);
		return "Genre has been deleted..";
	}

	@PatchMapping("update/movie/{movie_id}")
	public String editName(@PathVariable("movie_id") int movie_id, @RequestBody Movies movie) throws SQLException {
		Movies updatedMovie = movieService.getMovieById(movie_id);
		updatedMovie.setMovie_id(movie_id);
		updatedMovie.setName(movie.getName());
		updatedMovie.setLanguage(movie.getLanguage());
		updatedMovie.setDescription(movie.getDescription());
		updatedMovie.setTicket_price(movie.getTicket_price());
		updatedMovie.setTimings(movie.getTimings());
		updatedMovie.setGenre(movie.getGenre());
		updatedMovie.setRatings(movie.getRatings());
		movieService.editMovieDetails(updatedMovie);
		return "Movie has been changed..";
	}

}
