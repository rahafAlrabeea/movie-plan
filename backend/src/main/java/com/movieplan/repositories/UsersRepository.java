package com.movieplan.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movieplan.daos.UsersDao;
import com.movieplan.models.Users;

@Repository
public class UsersRepository implements UsersDao {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public boolean signInUser(String email, String password) {
		Boolean result = false;
		try {
			jdbc.queryForObject("select * from users where email=? AND password =?",
					BeanPropertyRowMapper.newInstance(Users.class), email, password);
			result = true;
			Users user =getUserIdByEmail(email);
		} catch (EmptyResultDataAccessException e) {
			return result;
		}
		return result ;
	}

	@Override
	public int signUp(Users user) {
		return jdbc.update("insert into users values(?,?,?,?)",
				new Object[] { user.getUser_id(),user.getEmail(), user.getFull_name(), user.getPassword() });
	}
	@Override
	public Users getUserIdByEmail(String email) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("SELECT user_id from users where email =?",
				BeanPropertyRowMapper.newInstance(Users.class), email);
	}

}
