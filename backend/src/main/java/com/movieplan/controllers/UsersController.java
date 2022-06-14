package com.movieplan.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieplan.services.OrdersService;
import com.movieplan.services.UsersService;
import com.movieplan.models.Users;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private OrdersService oService;
	@Autowired
	JdbcTemplate jdbc;

	public UsersController() {

	}

	public UsersController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}

	@PostMapping("/signup")
	public String UserSignup(@RequestBody Users user) {
		usersService.signUpUser(user);

		return "registered.. ";
	}

	@PostMapping("/signin")
	public String signIn(@RequestBody Users user) throws SQLException {
		String signInResponse = null;
		String email = user.getEmail();
		String password = user.getPassword();
		boolean userAuthenticated = usersService.signInUser(email, password);
		Users u= oService.getUserById(email);
		
		if (userAuthenticated) {

			signInResponse = ""+u.getUser_id();
			
		} else {

			signInResponse = "Incorrect credentials..";
		}
		return signInResponse;

	}
}
