package com.student.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.management.entity.User;
import com.student.management.repository.UserRepository;
import com.student.management.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<User> createUser(User user) {
		return ResponseEntity.ok(userRepository.save(user));
	}

	@Override
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userRepository.findAll());
	}

}
