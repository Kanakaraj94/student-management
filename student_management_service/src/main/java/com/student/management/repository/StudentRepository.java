package com.student.management.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.student.management.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByName(String name);

	Student findByStudentCode(String studentCode);
	
	List<Student> findByCourses_courseId(Long courseId);
	
	List<Student> findByCourses_courseName(String courseName);
	
	List<Student> findByCourses_topics(String topics);
	
	
}
