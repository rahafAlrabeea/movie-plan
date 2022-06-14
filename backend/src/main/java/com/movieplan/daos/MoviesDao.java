package com.movieplan.daos;

import java.sql.SQLException;
import java.util.List;

import com.movieplan.models.Genres;
import com.movieplan.models.Movies;

public interface MoviesDao {
	
	List<Movies> getAllMovies();
	List<Movies> searchMovie(String keyword) throws SQLException;

	int editMovieDetails(Movies movie);

	int addGenre(Genres genre);

	int deleteGenre(int movie_id);

	List<Movies> sortMoviesByGenre() throws SQLException;

	List<Movies> sortMoviesByratings() throws SQLException;

	List<Movies> sortMoviesByprice() throws SQLException;

	Movies getMovieById(int movie_id) throws SQLException;

}
