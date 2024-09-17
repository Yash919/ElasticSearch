package com.elastic.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elastic.entity.User;
import com.elastic.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> searchUsersByQuery(String query) {
		return userRepository.searchUsersByQuery(query);
	}

	public List<User> findAllUsers() {
		Pageable pageable = PageRequest.of(0, 100);
		Page<User> userPage = userRepository.findAll(pageable);
		return userPage.getContent();
	}

	public String populateUsers() {
		try {
			// Check if index already contains data
			if (userRepository.count() > 0) {
				return "Index already contains data.";
			}

			for (int i = 1; i <= 100; i++) {
				User user = new User();
				user.setId(UUID.randomUUID().toString());
				user.setUsername("User" + i);
				user.setEmail("user" + i + "@example.com");
				user.setPassword("password" + i);
				user.setBio("Bio for user " + i);
				user.setLinkedInUrl("https://linkedin.com/in/user" + i);
				user.setGithubUrl("https://github.com/user" + i);
				user.setTwitterUrl("https://twitter.com/user" + i);
				userRepository.save(user);
			}
			return "100 sample users added to Elasticsearch.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error occurred while adding sample users: " + e.getMessage();
		}
	}
}