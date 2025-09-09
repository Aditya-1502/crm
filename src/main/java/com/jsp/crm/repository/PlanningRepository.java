package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jsp.crm.model.Planning;

public interface PlanningRepository extends JpaRepository<Planning, Long>{

	List<Planning> findByDate(LocalDate now);

	Planning findByRouteCardNo(String routeCardNo);
}
