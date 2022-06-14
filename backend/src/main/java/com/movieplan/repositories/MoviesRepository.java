package com.movieplan.repositories;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movieplan.daos.MoviesDao;
import com.movieplan.models.Genres;
import com.movieplan.models.Movies;

@Repository
public class MoviesRepository implements MoviesDao {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Movies> getAllMovies()  {
		return jdbc.query(
				"select * from movies inner join genres on movies.genre_id=genres.genre_id",
				BeanPropertyRowMapper.newInstance(Movies.class));
	}
	@Override
	public List<Movies> searchMovie(String keyword) throws SQLException {
		return jdbc.query(
				"select * from movies inner join genres on movies.genre_id=genres.genre_id where genres.genre like ? OR movies.name like ?",
				BeanPropertyRowMapper.newInstance(Movies.class), "%" + keyword + "%", "%" + keyword + "%");
	}

	@Override
	public int editMovieDetails(Movies movie) {
		return jdbc.update(
				"UPDATE movies SET name =?,  ticket_price =?, language=?, description =?, ratings =?, timings =?, genre_id =? WHERE movie_id =?",
				new Object[] { movie.getName(), movie.getTicket_price(), movie.getLanguage(), movie.getDescription(),
						movie.getRatings(), movie.getTimings(), movie.getGenre(), movie.getMovie_id() });
	}

	@Override
	public int addGenre(Genres genre) {

		return jdbc.update("insert into genres(genre)values(?)", new Object[] { genre.getGenre() });
	}

	@Override
	public int deleteGenre(int genre_id) {

		return jdbc.update("delete  from genres where genre_id =?", genre_id);
	}

	@Override
	public List<Movies> sortMoviesByGenre() throws SQLException {
		return jdbc.query(
				"select * from movies inner join genres on movies.genre_id=genres.genre_id order by genres.genre",
				BeanPropertyRowMapper.newInstance(Movies.class));
	}

	@Override
	public List<Movies> sortMoviesByratings() throws SQLException {
		return jdbc.query(
				"select * from movies inner join genres on movies.genre_id=genres.genre_id order by ratings DESC",
				BeanPropertyRowMapper.newInstance(Movies.class));
	}

	@Override
	public List<Movies> sortMoviesByprice() throws SQLException {

		return jdbc.query(
				"select * from movies inner join genres on movies.genre_id=genres.genre_id order by ticket_price",
				BeanPropertyRowMapper.newInstance(Movies.class));
	}

	@Override
	public Movies getMovieById(int movie_id) throws SQLException {
		return jdbc.queryForObject("select * from movies inner join genres on movies.genre_id=genres.genre_id where movie_id =?",
				BeanPropertyRowMapper.newInstance(Movies.class), movie_id);
	}
}
