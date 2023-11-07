package com.adellapo.learning.springmicroservices.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserDaoService userService;

	public UserController(UserDaoService userService) {
		this.userService = userService;
	}

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@PostMapping(path = "/users")
	public User createUser(@RequestBody User userToCreate) {
		return userService.create(userToCreate);
	}

	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable(name = "id") Integer userId) {
		return userService.findUser(userId);
	}

	@DeleteMapping(path = "/users/{id}")
	public Long deleteUser(@PathVariable(name = "id") Integer userId) {
		return null;
	}

}
