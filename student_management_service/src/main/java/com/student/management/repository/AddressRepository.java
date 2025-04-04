package com.student.management.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByStudent_stuId(Long stuId);
}
