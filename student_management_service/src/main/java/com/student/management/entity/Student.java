package com.student.management.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "student_tbl")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stuId;
	
	@NotNull(message = "Name cannot be null")
	@Size(min = 2, message = "must be between 2 and 20 characters")
	private String name;
	
	@NotNull(message = "Date of birth cannot be null")
	private LocalDate dateOfBirth;
	
	private String gender;
	
	@NotNull(message = "Student code cannot be null")
    @Size(min = 5, max = 20, message = "Student code must be between 5 and 20 characters")
	private String studentCode;
	
	@Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be null")
	private String email;
	
	@NotNull(message = "Mobile number cannot be null")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
	private String mobileNumber;
	private String fatherName;
	
	private String motherName;

	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "stuId")
	@JsonManagedReference
	private List<Address> address = new ArrayList<Address>();

	@ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
	@JoinTable(name = "student_courses_tbl", 
	joinColumns = @JoinColumn(referencedColumnName = "stuId"), 
	inverseJoinColumns = @JoinColumn(referencedColumnName = "courseId"))
	private List<Course> courses = new ArrayList<Course>();

}
