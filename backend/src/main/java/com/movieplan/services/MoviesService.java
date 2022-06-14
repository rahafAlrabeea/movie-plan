package com.movieplan.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieplan.daos.MoviesDao;
import com.movieplan.models.Genres;
import com.movieplan.models.Movies;

@Service
public class MoviesService {
	@Autowired
	private MoviesDao movieRepository;

	public MoviesService(MoviesDao movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	
	public List<Movies> getAllMovies() throws SQLException {
		return this.movieRepository.getAllMovies();
	}
	public List<Movies> getProductByName(String keyword) throws SQLException {
		return this.movieRepository.searchMovie(keyword);
	}

	public List<Movies> sortMoviesByGenre() throws SQLException {
		return this.movieRepository.sortMoviesByGenre();

	}

	public List<Movies> sortMoviesByratings() throws SQLException {
		return this.movieRepository.sortMoviesByratings();

	}

	public List<Movies> sortMoviesByprice() throws SQLException {
		return this.movieRepository.sortMoviesByprice();

	}

	public int addGenre(Genres genre) throws SQLException {
		return this.movieRepository.addGenre(genre);
	}

	public int deleteGenre(int genre_id) throws SQLException {
		return this.movieRepository.deleteGenre(genre_id);
	}

	public Movies getMovieById(int movie_id) throws SQLException {
		return this.movieRepository.getMovieById(movie_id);
	}

	public int editMovieDetails(Movies movie) {
		return this.movieRepository.editMovieDetails(movie);
	}
}
