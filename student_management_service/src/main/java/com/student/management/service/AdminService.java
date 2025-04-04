package com.student.management.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.student.management.entity.Course;
import com.student.management.entity.Student;

public interface AdminService {

	List<Student> getStudentByName(String name);

	ResponseEntity<Course> addCourse(Course course);

	ResponseEntity<?> assignCourseToStudent(Long stuId, Long courseId);

	List<Student> getStudentsByCourseId(Long courseId);


}
