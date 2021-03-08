package com.starse.kintai.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starse.kintai.model.EmployeeInfo;

public interface EmployeeInfoRepo extends JpaRepository<EmployeeInfo, Integer>{

	Optional<EmployeeInfo> findOneByMail(String mail);
	
}
