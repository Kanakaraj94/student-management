package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.dto.RequestDto;
import com.student.management.dto.StudentProfileUpdateDto;
import com.student.management.entity.Student;
import com.student.management.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	

	@GetMapping("/listAllStudents")
	public ResponseEntity<?> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@PutMapping("/updateStudentProfile/{stuId}")
	public ResponseEntity<Student> updateStudentProfile(@RequestBody StudentProfileUpdateDto profileUpdateDto,@PathVariable Long stuId) {
		return studentService.updateStudentProfile(profileUpdateDto,stuId);
	}
	
	@PostMapping("/studentsByCourseName")
	public ResponseEntity<?> getAllStudentsByCourseName(@RequestBody RequestDto requestDto) {
		return studentService.studentsByCourseName(requestDto.getCourseName());
	}
	
	@PostMapping("/studentsByTopic")
	public ResponseEntity<?> getAllStudentsByTopic(@RequestBody RequestDto requestDto) {
		return studentService.studentsByTopic(requestDto.getTopics());
	}

	@PostMapping("/leaveCourse")
	public ResponseEntity<?> leaveCourse(@RequestBody RequestDto requestDto) {
		return studentService.leaveCourse(requestDto.getStuId(),requestDto.getCourseId());
	}
	
	@GetMapping("/studentsByStudentCode")
	public ResponseEntity<?> studentsByStudentCode(@RequestBody RequestDto requestDto) {
		return studentService.studentsByStudentCode(requestDto.getStudentCode());
	}
}
