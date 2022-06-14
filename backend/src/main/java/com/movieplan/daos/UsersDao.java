package com.movieplan.daos;

import com.movieplan.models.Users;

public interface UsersDao {
//just add the methods no need to anything else
	boolean signInUser(String email, String password);
	int signUp(Users user);
	Users getUserIdByEmail(String email);
}
