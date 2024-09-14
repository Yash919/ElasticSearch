package com.elastic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.entity.User;
import com.elastic.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/search/es")
	public Map<String, Object> searchUsersElasticsearch(@RequestParam String query) {
		long startTime = System.currentTimeMillis();
		List<User> users = userService.searchUsersByQuery(query); // Updated method call
		long endTime = System.currentTimeMillis();

		Map<String, Object> response = new HashMap<>();
		response.put("users", users);
		response.put("timeTaken", (endTime - startTime) + " ms");
		return response;
	}
	@GetMapping
	public Iterable<User> getAllUsers() {
		return userService.findAllUsers();
	}

	@PostMapping("/populate")
	public String populateUsers() {
		return userService.populateUsers();
	}
}