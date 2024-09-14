package com.elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.elastic.entity.User;


public interface UserRepository extends ElasticsearchRepository<User, String> {
	@Query("{ \"bool\": { \"should\": [ " +
			"{ \"wildcard\": { \"username\": \"*?0*\" } }, " +
			"{ \"wildcard\": { \"email\": \"*?0*\" } }, " +
			"{ \"wildcard\": { \"linkedInUrl\": \"*?0*\" } }, " +
			"{ \"wildcard\": { \"githubUrl\": \"*?0*\" } }, " +
			"{ \"wildcard\": { \"twitterUrl\": \"*?0*\" } } " +
			"] } }")
	List<User> searchUsersByQuery(String query);
}