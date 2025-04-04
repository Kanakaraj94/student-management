package com.student.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.management.entity.Course;
import com.student.management.entity.Student;
import com.student.management.repository.CourseRepository;
import com.student.management.repository.StudentRepository;
import com.student.management.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public ResponseEntity<Course> addCourse(Course course) {
		return ResponseEntity.ok(courseRepository.save(course));
	}

	@Override
	public ResponseEntity<?> assignCourseToStudent(Long stuId, Long courseId) {
		Student student = studentRepository.findById(stuId).orElse(null);
		Course course = courseRepository.findById(courseId).orElse(null);
		student.getCourses().add(course);
		studentRepository.save(student);
		return ResponseEntity.ok("Course assigned to Student successfully");  
	}

	@Override
	public List<Student> getStudentsByCourseId(Long courseId) {
		return studentRepository.findByCourses_courseId(courseId);
	}


}
