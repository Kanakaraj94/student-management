package com.student.management.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.student.management.entity.Student;
import com.student.management.repository.StudentRepository;

@Service
public class StudentUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String studentCode) throws UsernameNotFoundException {
        Student student = studentRepository.findByStudentCode(studentCode);
        if (student == null) {
            throw new UsernameNotFoundException("Student not found");
        }

        return new org.springframework.security.core.userdetails.User(
                student.getStudentCode(), 
                student.getDateOfBirth().toString(), 
                List.of(new SimpleGrantedAuthority("ROLE_STUDENT"))
        );
    }
}