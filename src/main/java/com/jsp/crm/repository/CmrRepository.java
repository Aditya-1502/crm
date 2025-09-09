package com.jsp.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.crm.model.Reports;



public interface CmrRepository extends JpaRepository<Reports, Integer>{
	
}
