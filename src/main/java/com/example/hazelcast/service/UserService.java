package com.example.hazelcast.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.hazelcast.entity.User;
import com.example.hazelcast.repository.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Cacheable(value="users-cache", key="#userId", unless = "#result==null")
	public Optional<User> getUserById(Integer userId) {
		return userDAO.findById(userId);
	}

	@CacheEvict(value="users-cache", key="#userId")
	public void deleteUser(Integer userId) {
		userDAO.deleteById(userId);
	}
	
	@CachePut(value="users-cache")
	public User updateUser(User user) {
		User updatedUser = null;
		int id = user.getId();
		User userFromDB = userDAO.findById(id).orElse(null);
		if(userFromDB != null) {
			userFromDB.setName("Go Jek");
			userFromDB.setContact("4444");
			updatedUser = userDAO.save(userFromDB);
		}
		return updatedUser;
	}
}
