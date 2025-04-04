package com.student.management.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.student.management.dto.StudentProfileUpdateDto;
import com.student.management.entity.Student;

public interface StudentService {

	ResponseEntity<?> getAllStudents();

	ResponseEntity<Student> addStudent(Student student);

	ResponseEntity<Student> updateStudentProfile(StudentProfileUpdateDto profileUpdateDto,Long stuId);

	ResponseEntity<List<Student>> studentsByCourseName(String courseName);
	
	ResponseEntity<List<Student>> studentsByTopic(String topics);

	ResponseEntity<?> leaveCourse(Long stuId, Long courseId);

	ResponseEntity<?> studentsByStudentCode(String studentCode);
}
