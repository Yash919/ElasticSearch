package com.elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.elastic.entity.User;


public interface UserRepository extends ElasticsearchRepository<User, String> {
	@Query("{\"wildcard\": {\"username\": \"*?0*\"}}")
	List<User> findByUsernameContaining(String username);
}