package com.student.management.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.student.management.entity.User;
import com.student.management.repository.UserRepository;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Admin user not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), 
                user.getPassword(), 
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}