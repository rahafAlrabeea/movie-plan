package com.movieplan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieplan.daos.UsersDao;
import com.movieplan.models.Users;

@Service
public class UsersService {
	@Autowired
	private UsersDao usersRepository;

	public UsersService() {

	}

	public UsersService(UsersDao usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	public Boolean signUpUser(Users user) {
		return this.usersRepository.signUp(user) > 0;

	}

	public Boolean signInUser(String email, String password) {
		// login code
		boolean validUser = usersRepository.signInUser(email, password);
		if (!validUser) {
			return false;
		}

		return true;
	}

}
