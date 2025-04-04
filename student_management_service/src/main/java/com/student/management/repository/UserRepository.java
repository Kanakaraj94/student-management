package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String userName);
}
