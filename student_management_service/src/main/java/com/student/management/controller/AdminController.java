package com.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.dto.RequestDto;
import com.student.management.entity.Course;
import com.student.management.entity.Student;
import com.student.management.service.AdminService;
import com.student.management.service.StudentService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}
	
	@PostMapping("/addCourse")
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		return adminService.addCourse(course);
	}
	
	@PostMapping("/assignCourse")
	public ResponseEntity<?> assignCourseToStudent(@RequestBody RequestDto requestDto){
		return adminService.assignCourseToStudent(requestDto.getStuId(),requestDto.getCourseId());
	}
	
	@GetMapping("/listStudentByName/{name}")
	public List<Student> getStudentByName(@PathVariable String name){
		return adminService.getStudentByName(name);
	}
	
	@GetMapping("/studentsByCourseId")
	public List<Student> getStudentsByCourseId(@RequestBody RequestDto requestDto){
		return adminService.getStudentsByCourseId(requestDto.getCourseId());
	};
}
