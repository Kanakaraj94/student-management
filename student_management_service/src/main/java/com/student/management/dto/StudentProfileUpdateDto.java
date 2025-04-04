package com.student.management.dto;

import java.util.ArrayList;
import java.util.List;

import com.student.management.entity.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileUpdateDto {

	@Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be null")
	private String email;
	
	@NotNull(message = "Mobile number cannot be null")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
	private String mobileNumber;
	private String fatherName;
	private String motherName;
	private List<Address> address = new ArrayList<Address>();
}
