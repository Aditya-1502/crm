package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.crm.model.Inspection;
import com.jsp.crm.model.QcSupervisor;


public interface InspectionRepository extends JpaRepository<Inspection, Long>{

	List<Inspection> findByDate(LocalDate now);

	Inspection findByRouteCardNo(String routeCardNo);
}
