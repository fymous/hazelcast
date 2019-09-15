package com.example.hazelcast.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hazelcast.entity.User;
import com.example.hazelcast.service.UserService;

@RestController
@RequestMapping("hazelcast")
public class HazelCastController {
	
	@Autowired
	private UserService userService;
		
	@GetMapping(value="/user/{userId}")
	public Optional<User> getUserById(@PathVariable("userId") int userId){
		return userService.getUserById(userId);
	}
	
	@DeleteMapping(value="/user/{userId}")
	public void deleteUser(@PathVariable("userId")int UserId){
		userService.deleteUser(UserId);
	}
	
	@PutMapping(value="/user")
	public User updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
}
