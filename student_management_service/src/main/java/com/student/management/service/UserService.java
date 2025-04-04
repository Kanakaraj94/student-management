package com.student.management.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.student.management.entity.User;

public interface UserService {

	ResponseEntity<User> createUser(User user);

	ResponseEntity<List<User>> getAllUsers();

}
