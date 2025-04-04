package com.student.management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.management.dto.StudentProfileUpdateDto;
import com.student.management.entity.Address;
import com.student.management.entity.Course;
import com.student.management.entity.Student;
import com.student.management.repository.AddressRepository;
import com.student.management.repository.CourseRepository;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(studentRepository.findAll());
	}

	@Override
	public ResponseEntity<Student> addStudent(Student student) {
		return ResponseEntity.ok(studentRepository.save(student));
	}

	@Override
	public ResponseEntity<Student> updateStudentProfile(StudentProfileUpdateDto profileUpdateDto,Long stuId) {
		Student student = studentRepository.findById(stuId).orElseThrow(()->new RuntimeException("Student not found for ID : "+stuId));
		
		student.setEmail(profileUpdateDto.getEmail());
		student.setMobileNumber(profileUpdateDto.getMobileNumber());
		student.setFatherName(profileUpdateDto.getFatherName());
		student.setMotherName(profileUpdateDto.getMotherName());
		student.setAddress(profileUpdateDto.getAddress());	
		return ResponseEntity.ok(studentRepository.save(student));
	}

	@Override
	public ResponseEntity<List<Student>> studentsByCourseName(String courseName) {
		System.out.println("CourseName : "+courseName);
		return ResponseEntity.ok(studentRepository.findByCourses_courseName(courseName));
	}

	@Override
	public ResponseEntity<List<Student>> studentsByTopic(String topics) {
		System.out.println("Topic : "+topics);
		return ResponseEntity.ok(studentRepository.findByCourses_topics(topics));
	}

	@Override
	public ResponseEntity<?> leaveCourse(Long stuId, Long courseId) {
		Student student = studentRepository.findById(stuId).orElseThrow(()->new RuntimeException("Student not found for ID : "+stuId));
		Course course = courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("Course not found for ID : "+courseId));
		student.getCourses().remove(course);
		return ResponseEntity.ok(studentRepository.save(student));
	}

	@Override
	public ResponseEntity<?> studentsByStudentCode(String studentCode) {
		return ResponseEntity.ok(studentRepository.findByStudentCode(studentCode));
	}



}
