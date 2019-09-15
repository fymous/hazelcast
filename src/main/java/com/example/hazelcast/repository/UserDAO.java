package com.example.hazelcast.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hazelcast.entity.User;

public interface UserDAO extends CrudRepository<User, Integer>{
	
}
