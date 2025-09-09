package com.jsp.crm.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.crm.model.Mixing;
import com.jsp.crm.model.Production;
import com.jsp.crm.model.Reports;



public interface MixRepository extends JpaRepository<Mixing, Long> {

	

	List<Mixing> findByDate(LocalDate now);

	Mixing findByRouteCardNo(String routeCardNo);

	

	

}
