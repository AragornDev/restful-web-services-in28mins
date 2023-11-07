package com.adellapo.learning.springmicroservices.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static Integer idCounter = 3;
	static {
		users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Eve", LocalDate.now().minusYears(30)));
		users.add(new User(3, "Jim", LocalDate.now().minusYears(30)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findUser(Integer userId) {
		return users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
	}

	public User create(User userToCreate) {
		User newUser = new User(++idCounter, userToCreate.getName(), userToCreate.getBirthDate());
		users.add(newUser);
		return newUser;
	}

}
