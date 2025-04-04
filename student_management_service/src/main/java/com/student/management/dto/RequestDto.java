package com.student.management.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

	private Long stuId;
	private String name;
	private LocalDate dateOfBirth;
	private String gender;
	private String studentCode;
	private Long courseId;
	private String courseName;
	private String description;
	private String courseType;
	private String duration;
	private String topics;
}
